package com.vitor.dev.spring.secutiry

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class WelcomeController {

    @GetMapping
    fun welcome(): String{
        return "Welcome to Vitor's Spring Security Application"
    }

    @GetMapping("/users")
    fun users(): String{
        return "Authorizes user"
    }

    @GetMapping("/managers")
    fun managers(): String{
        return "Authorizes manager"
    }

}