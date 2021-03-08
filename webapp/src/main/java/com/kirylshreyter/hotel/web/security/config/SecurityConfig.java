package com.kirylshreyter.hotel.web.security.config;

import com.kirylshreyter.hotel.web.filter.ApiAuthenticationFilter;
import com.kirylshreyter.hotel.web.security.manager.TokenAuthenticationManager;
import com.kirylshreyter.hotel.web.security.model.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)

@ComponentScan(basePackageClasses = {
        com.kirylshreyter.hotel.web.security.manager.TokenAuthenticationManager.class,
        com.kirylshreyter.hotel.web.security.provider.impl.JwtProviderImpl.class
})

public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("userDetailsService")
    UserDetailsService userDetailsService;

    @Autowired
    TokenAuthenticationManager tokenAuthenticationManager;

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .headers().frameOptions().sameOrigin()
//                .and()
//                .addFilterAfter(apiAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
//                .authorizeRequests()
//                .antMatchers("/api/*").authenticated();
//    }

    @Bean
    public ApiAuthenticationFilter apiAuthenticationFilter() {
        ApiAuthenticationFilter apiAuthenticationFilter = new ApiAuthenticationFilter();
        tokenAuthenticationManager.setUserDetailsService(userDetailsService);
        apiAuthenticationFilter.setAuthenticationManager(tokenAuthenticationManager);
        return apiAuthenticationFilter;
    }

    @Bean
    public UserDetailsService userDetailsService(){
        return username -> null;
    }
}
