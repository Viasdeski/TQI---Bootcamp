package com.vitor.dev.credit.application.system.repository

import com.vitor.dev.credit.application.system.entity.Credit
import com.vitor.dev.credit.application.system.entity.Customer
import com.vitor.dev.credit.application.system.service.impl.CreditService
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import java.lang.annotation.Native
import java.util.UUID

@Repository
interface CreditRepository: JpaRepository<Credit,Long>{

    fun findByCreditCode(creditCode: UUID) : Credit?

    @Query(value = "SELECT * FROM CREDIT WHERE CREDIT_ID = ?1", nativeQuery = true)
    fun findAllByCustomerId(customerId: Long) : List<Credit>
}