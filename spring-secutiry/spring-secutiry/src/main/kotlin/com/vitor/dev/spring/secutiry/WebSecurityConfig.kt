package com.vitor.dev.spring.secutiry


import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.crypto.factory.PasswordEncoderFactories
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.provisioning.InMemoryUserDetailsManager
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class WebSecurityConfig {

    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain{
        http.authorizeHttpRequests()
            .requestMatchers("/")
            .permitAll()
            .requestMatchers(HttpMethod.POST, "/login")
            .permitAll()
            .requestMatchers( "/managers")
            .hasAnyRole("MANAGERS")
            .requestMatchers("/users")
            .hasAnyRole("USERS", "MANAGERS")
            .anyRequest()
            .authenticated()
            .and()
            .formLogin()

        return http.build()
    }

    @Bean
    fun userDetailsService(auth: AuthenticationManagerBuilder) : UserDetailsService{

        val passwordEncoder: PasswordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder()

        val userDetailsService = InMemoryUserDetailsManager()

        val user = User.withUsername("user")
            .password(passwordEncoder().encode("user123"))
            .roles("USERS")
            .build()

        val admin =User.withUsername("admin")
            .password(passwordEncoder().encode("master123"))
            .roles("MANAGERS")
            .build()

        userDetailsService.createUser(user)
        userDetailsService.createUser(admin)

        return userDetailsService
    }

    @Bean
    fun passwordEncoder(): PasswordEncoder{
        return PasswordEncoderFactories.createDelegatingPasswordEncoder()
    }

}