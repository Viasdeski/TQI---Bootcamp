package com.vitor.dev.credit.application.system.dto


import com.vitor.dev.credit.application.system.entity.Credit
import com.vitor.dev.credit.application.system.entity.Status
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import java.math.BigDecimal
import java.util.UUID

data class CreditView(
    val creditCode: UUID,
    @field: NotNull(message = "Invalid Input") val creditValue: BigDecimal,
    val numberOfInstallment: Int,
    @field: NotEmpty(message = "Invalid Input") val status: Status,
    val emailCustomer: String?,
    @field: NotNull(message = "Invalid Input") val income: BigDecimal?

) {
    constructor(credit: Credit) : this(
        creditCode = credit.creditCode,
        creditValue = credit.creditValue,
        numberOfInstallment = credit.numberOfInstallment,
        status = credit.status,
        emailCustomer = credit.customer?.email,
        income = credit.customer?.income
    )
}
