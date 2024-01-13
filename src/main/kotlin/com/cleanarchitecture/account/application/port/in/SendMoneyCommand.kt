package com.cleanarchitecture.account.application.port.`in`

import com.cleanarchitecture.account.domain.AccountId
import com.cleanarchitecture.account.domain.Money
import com.cleanarchitecture.common.SelfValidating
import org.jetbrains.annotations.NotNull

class SendMoneyCommand(
  @field:NotNull // bean validation api 사용하기 위해 추가. 참고. https://blog.leocat.kr/notes/2020/12/10/kotest-bean-validation-in-kotlin
  val sourceAccountId: AccountId,
  @field:NotNull
  val targetAccountId: AccountId,
  @field:NotNull
  val money: Money
): SelfValidating<SendMoneyCommand>() {

  init {
    this.validateSelf()
  }
}