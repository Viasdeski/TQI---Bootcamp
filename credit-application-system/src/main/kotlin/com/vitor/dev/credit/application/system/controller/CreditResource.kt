package com.vitor.dev.credit.application.system.controller

import com.vitor.dev.credit.application.system.dto.CreditDto
import com.vitor.dev.credit.application.system.dto.CreditView
import com.vitor.dev.credit.application.system.dto.CreditViewList
import com.vitor.dev.credit.application.system.entity.Credit
import com.vitor.dev.credit.application.system.service.impl.CreditService
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.util.*
import java.util.stream.Collectors


@RestController
@RequestMapping("/api/credits")
class CreditResource(
    private val creditService: CreditService
) {
    @PostMapping
    fun saveCredit(@RequestBody @Valid creditDto: CreditDto): ResponseEntity<String> {
        val credit = this.creditService.save(creditDto.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED)
            .body("Credit ${credit.creditCode} for customer:${credit.customer?.firstName} saved")
    }

    @GetMapping
    fun findByAllCustomerId(@RequestParam(value = "id") id: Long): ResponseEntity<List<CreditViewList>> {
        val listCredits = this.creditService.findByAllCustomer(id)
            .stream()
            .map { credit: Credit -> CreditViewList(credit) }
            .collect(Collectors.toList())
        return ResponseEntity.status(HttpStatus.OK).body(listCredits)
    }

    @GetMapping("/{creditCode}")
    fun findByCreditCode(
        @RequestParam(value = "id") id: Long,
        @PathVariable creditCode: UUID
    ): ResponseEntity<CreditView> {
        val credit = this.creditService.findByCreditCode(id, creditCode)
        return ResponseEntity.status(HttpStatus.OK).body(CreditView(credit))
    }
}