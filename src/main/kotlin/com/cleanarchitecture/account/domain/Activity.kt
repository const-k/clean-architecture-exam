package com.cleanarchitecture.account.domain

import java.time.LocalDateTime

/**
 * 한 계좌에 대한 활동
 */
data class Activity(
  val id: ActivityId? = null,
  val ownerAccountId: AccountId,
  val sourceAccountId: AccountId,
  val targetAccountId: AccountId,
  val timestamp: LocalDateTime,
  val money: Money
)