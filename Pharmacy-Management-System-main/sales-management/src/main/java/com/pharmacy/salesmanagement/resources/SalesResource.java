package com.pharmacy.salesmanagement.resources;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class SalesResource {

    @RequestMapping("/sales")
    public String getSalesInfo(){
        return "hello Sales Information ";
    }

    @Configuration
    @EnableWebSecurity
    public static class AppSecurityConfig extends WebSecurityConfigurerAdapter {
        @Bean
        @Override
        protected UserDetailsService userDetailsService(){
            List<UserDetails> users= new ArrayList<>();
            users.add(User.withDefaultPasswordEncoder().username("user1").password("1234").roles("USER").build());
            return new InMemoryUserDetailsManager(users);
        }

    }
}
