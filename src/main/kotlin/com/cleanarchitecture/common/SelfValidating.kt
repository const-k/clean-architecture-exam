package com.cleanarchitecture.common

import javax.validation.ConstraintViolationException
import javax.validation.Validation
import javax.validation.Validator

abstract class SelfValidating<T>() {
  private var validator: Validator

  init {
    val factory = Validation.buildDefaultValidatorFactory()
    validator = factory.validator
  }

  protected fun validateSelf() {
    val violations = validator.validate(this)
    if (violations.isNotEmpty()) {
      throw ConstraintViolationException(violations)
    }
  }


}