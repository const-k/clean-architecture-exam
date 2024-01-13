package com.cleanarchitecture.account.domain

import java.time.LocalDateTime

/**
 * Account 엔티티는 실제 계좌의 현재 스냅샷을 제공
 * 총 잔고 = baselineBalance + activityWindow 내의 모든 활동
 */
class Account(
  val id: AccountId,
  val baselineBalance: Money, // 활동창(activity window)의 첫 번째 활동 바로 전의 잔로를 의미하는 기준 잔고
  val activityWindow: ActivityWindow
) {

  fun calculateBalance(): Money {
    return Money.add(
      this.baselineBalance,
      this.activityWindow.calculateBalance(this.id)
    )
  }

  fun withdraw(money: Money, targetAccountId: AccountId): Boolean {
    // 비즈니스 규칙 검증에 해당
    if (!mayWithdraw(money)) {
      return false
    }
    this.activityWindow.addActivity(
      Activity(
        ownerAccountId = this.id,
        sourceAccountId = this.id,
        targetAccountId = targetAccountId,
        timestamp = LocalDateTime.now(),
        money = money
      )
    )

    return true
  }

  fun deposit(money: Money, sourceAccountId: AccountId): Boolean {
    this.activityWindow.addActivity(
      Activity(
        ownerAccountId = this.id,
        sourceAccountId = sourceAccountId,
        targetAccountId = this.id,
        timestamp = LocalDateTime.now(),
        money = money
      )
    )
    return true
  }

  private fun mayWithdraw(money: Money): Boolean {
    return Money.add(
      this.calculateBalance(),
      money.negate()
    ).isPositive()
  }
}