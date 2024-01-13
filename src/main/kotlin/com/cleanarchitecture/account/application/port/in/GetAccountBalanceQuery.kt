package com.cleanarchitecture.account.application.port.`in`

import com.cleanarchitecture.account.domain.AccountId
import com.cleanarchitecture.account.domain.Money

interface GetAccountBalanceQuery {
  fun getAccountBalance(accountId: AccountId): Money
}