package com.cleanarchitecture.account.application.port.`in`

interface SendMoneyUseCase {
  fun sendMoney(command: SendMoneyCommand): Boolean
}