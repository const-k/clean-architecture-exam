package com.cleanarchitecture.account.application.port.out

import com.cleanarchitecture.account.domain.Account
import com.cleanarchitecture.account.domain.AccountId
import java.time.LocalDateTime

interface LoadAccountPort {
  fun loadAccount(accountId: AccountId, baselineDate: LocalDateTime): Account
}