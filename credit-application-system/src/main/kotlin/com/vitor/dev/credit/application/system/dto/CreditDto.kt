package com.vitor.dev.credit.application.system.dto

import com.vitor.dev.credit.application.system.entity.Credit
import com.vitor.dev.credit.application.system.entity.Customer
import jakarta.persistence.Column
import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import jakarta.validation.constraints.Positive
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

data class CreditDto(
    @field: NotNull(message = "Invalid Input") val creditValue: BigDecimal,
    @field: Future val dateFirstOfInstallment: LocalDate,
    @field: NotNull(message = "Invalid Input") @field: Positive val numberOfInstallment: Int,
    @field: NotNull(message = "Invalid Input") val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dateFirstOfInstallment = this.dateFirstOfInstallment,
        numberOfInstallment = this.numberOfInstallment,
        customer = Customer(id = this.customerId)
    )

}
