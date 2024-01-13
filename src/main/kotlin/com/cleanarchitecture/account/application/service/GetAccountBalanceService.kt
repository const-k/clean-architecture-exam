package com.cleanarchitecture.account.application.service

import com.cleanarchitecture.account.application.port.`in`.GetAccountBalanceQuery
import com.cleanarchitecture.account.application.port.out.LoadAccountPort
import com.cleanarchitecture.account.domain.AccountId
import com.cleanarchitecture.account.domain.Money
import java.time.LocalDateTime

class GetAccountBalanceService(
  private val loadAccountPort: LoadAccountPort
): GetAccountBalanceQuery {
  override fun getAccountBalance(accountId: AccountId): Money {
    return loadAccountPort.loadAccount(accountId, LocalDateTime.now()).calculateBalance()
  }
}