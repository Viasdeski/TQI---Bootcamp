package com.vitor.dev.credit.application.system.dto

import com.vitor.dev.credit.application.system.entity.Address
import com.vitor.dev.credit.application.system.entity.Customer
import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field: NotEmpty(message = "Invalid Input") val firstName: String,
    @field: NotEmpty(message = "Invalid Input") val lastName: String,
    @field: NotEmpty(message = "Invalid Input") @field: CPF(message = "This CPF is invalid") val cpf: String,
    @field: NotNull(message = "Invalid Input") val income: BigDecimal,
    @field: NotEmpty(message = "Invalid Input") @field: Email(message = "This email is invalid") val email: String,
    @field: NotEmpty(message = "Invalid Input") val password: String,
    @field: NotEmpty(message = "Invalid Input") val zipCode: String,
    @field: NotEmpty(message = "Invalid Input") val street: String
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        income = this.income,
        email = this.email,
        password = this.password,
        address = Address(zipCode = this.zipCode, street = this.street)
    )
}
