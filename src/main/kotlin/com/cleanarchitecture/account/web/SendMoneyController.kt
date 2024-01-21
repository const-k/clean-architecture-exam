package com.cleanarchitecture.account.web

import com.cleanarchitecture.account.application.port.`in`.SendMoneyCommand
import com.cleanarchitecture.account.application.port.`in`.SendMoneyUseCase
import com.cleanarchitecture.account.domain.AccountId
import com.cleanarchitecture.account.domain.Money
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SendMoneyController(
  private val sendMoneyUseCase: SendMoneyUseCase
) {

  @PostMapping("/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
  fun sendMoney(
    @PathVariable("sourceAccountId") sourceAccountId: Long,
    @PathVariable("targetAccountId") targetAccountId: Long,
    @PathVariable("amount") amount: Long
  ) {
    val command = SendMoneyCommand(
      AccountId(sourceAccountId),
      AccountId(targetAccountId),
      Money.of(amount)
    )

    sendMoneyUseCase.sendMoney(command)
  }


}