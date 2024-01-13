package com.cleanarchitecture.account.application.service

import com.cleanarchitecture.account.application.port.`in`.SendMoneyCommand
import com.cleanarchitecture.account.application.port.`in`.SendMoneyUseCase
import com.cleanarchitecture.account.application.port.out.AccountLock
import com.cleanarchitecture.account.application.port.out.LoadAccountPort
import com.cleanarchitecture.account.application.port.out.UpdateAccountStatePort
import org.springframework.transaction.annotation.Transactional

/**
 * 클린 아키텍처의 유즈 케이스에 해당
 * 일반적으로 유즈케이스는 다음과 같은 단계를 따름
 *  1. 입력을 받는다
 *  2. 비즈니스 규칙을 검증한다
 *  3. 모델 상태를 조작한다.
 *  4. 출력을 반환한다
 */
@Transactional
class SendMoneyService(
  private val loadAccountPort: LoadAccountPort,
  private val accountLock: AccountLock,
  private val updateAccountStatePort: UpdateAccountStatePort
): SendMoneyUseCase {


  override fun sendMoney(command: SendMoneyCommand): Boolean {
    // todo. 비즈니스 규칙 검증
    // todo. 모델 상태 조작
    // todo. 출력 값 반환

//    만약 도메인 엔티티에서 비즈니스 규칙을 검증하기가 여의치 않다면 유스케이스 코드에서 도메인 엔티티를 사용하기 전에 해도 됨
//    requireAccountExists(command.sourceAccountId)
//    requireAccountExists(command.targetAccountId)

    return true
  }
}