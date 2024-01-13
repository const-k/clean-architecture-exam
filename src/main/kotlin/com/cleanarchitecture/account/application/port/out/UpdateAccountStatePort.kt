package com.cleanarchitecture.account.application.port.out

import com.cleanarchitecture.account.domain.Account

interface UpdateAccountStatePort {
  fun updateActivities(account: Account)
}