package com.vitor.dev.credit.application.system.service.impl

import com.vitor.dev.credit.application.system.entity.Credit
import com.vitor.dev.credit.application.system.exception.BusinesException
import com.vitor.dev.credit.application.system.repository.CreditRepository
import com.vitor.dev.credit.application.system.repository.CustomerRepository
import com.vitor.dev.credit.application.system.service.ICreditService
import org.springframework.stereotype.Service
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {

    override fun save(credit: Credit): Credit {
       //Primeiro verificamos se o Credito existe
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        //Após verificar, salvamos
        return this.creditRepository.save(credit)
    }

    override fun findByAllCustomer(customerId: Long): List<Credit> {
        return this.creditRepository.findAllByCustomerId(customerId)
    }


    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw BusinesException("O código: $creditCode não foi encontrado."))

        return if(credit.customer?.id == customerId) credit else throw IllegalArgumentException("Contate o administrador da aplicação")
    }
}