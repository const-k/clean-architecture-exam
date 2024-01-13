package com.cleanarchitecture.account.application.port.out

import com.cleanarchitecture.account.domain.AccountId

interface AccountLock {
  fun lockAccount(accountInt: AccountId)
  fun releaseAccount(accountInt: AccountId)

}