package com.vitor.dev.credit.application.system.service

import com.vitor.dev.credit.application.system.entity.Credit
import java.util.UUID

interface ICreditService {

    fun save(credit: Credit): Credit

    fun findByAllCustomer(customerId: Long): List<Credit>

    fun findByCreditCode(customerId: Long, creditCode: UUID): Credit

}