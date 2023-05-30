package com.vitor.dev.credit.application.system.service.impl

import com.vitor.dev.credit.application.system.entity.Customer
import com.vitor.dev.credit.application.system.exception.BusinesException
import com.vitor.dev.credit.application.system.repository.CustomerRepository
import com.vitor.dev.credit.application.system.service.ICustomerService
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service
class CustomerService(
    private val customerRepository: CustomerRepository
) : ICustomerService {
    override fun save(customer: Customer): Customer = this.customerRepository.save(customer)

    override fun findById(customerId: Long): Customer {
        return this.customerRepository.findById(customerId)
            .orElseThrow { throw BusinesException("Id: $customerId, não pode ser localizado") }
    }

    override fun delete(customerId: Long) {
        val customer = this.findById(customerId)
         this.customerRepository.delete(customer)
    }
}