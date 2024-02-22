package com.booking.bookingFlightsAndHotels.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {


    @Bean
    public SecurityFilterChain filterChain (HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(HttpMethod.POST,"/user/add").permitAll()
                .requestMatchers(HttpMethod.GET,"/user/getAll").permitAll()
                .requestMatchers(HttpMethod.GET,"/user/{id}").permitAll()
                .requestMatchers(HttpMethod.DELETE,"/user/delete/{id}").permitAll()
                .requestMatchers(HttpMethod.GET,"/room/getAll").permitAll()
                .requestMatchers(HttpMethod.GET,"/room/{id}").permitAll()
                .requestMatchers(HttpMethod.POST,"/room/reserve/{id}").permitAll()
                .requestMatchers(HttpMethod.POST,"/room/reserveByDate").permitAll()
                .requestMatchers(HttpMethod.POST,"/flight/reserve/{id}").permitAll()
                .requestMatchers(HttpMethod.GET,"/flight/getAll").permitAll()
                .requestMatchers(HttpMethod.GET,"/find/{origin}/{destination}/{isBooked}").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin().permitAll()
                .and()
                .httpBasic()
                .and()
                .build();
    }
}