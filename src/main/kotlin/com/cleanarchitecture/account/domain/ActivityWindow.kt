package com.cleanarchitecture.account.domain

import java.time.LocalDateTime


/**
 * 일정 기간 동안의 활동만 메모리에 로딩하기 위한 값 객체
 */
class ActivityWindow(
  private var activities: MutableList<Activity>
) {
  fun getStartTimestamp(): LocalDateTime {
    return activities.minByOrNull { it.timestamp }?.timestamp ?: throw IllegalStateException()
  }

  fun getEndTimestamp(): LocalDateTime {
    return activities.maxByOrNull { it.timestamp }?.timestamp ?: throw IllegalStateException()
  }

  /**
   * Calculates the balance by summing up the values of all activities within this window.
   */
  fun calculateBalance(accountId: AccountId): Money {
    val depositBalance = activities.filter { it.targetAccountId == accountId }
      .map { it.money }
      .fold(Money.ZERO, Money::add)

    val withdrawalBalance = activities.filter { it.sourceAccountId == accountId }
      .map { it.money }
      .fold(Money.ZERO, Money::add)

    return Money.add(depositBalance, withdrawalBalance.negate())
  }

  fun getActivities(): List<Activity> {
    return activities.toList()
  }

  fun addActivity(activity: Activity) {
    activities.add(activity)
  }
}
