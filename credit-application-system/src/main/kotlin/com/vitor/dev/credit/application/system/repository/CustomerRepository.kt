package com.vitor.dev.credit.application.system.repository

import com.vitor.dev.credit.application.system.entity.Customer
import org.springframework.data.jpa.repository.JpaRepository

interface CustomerRepository: JpaRepository<Customer, Long> {
}