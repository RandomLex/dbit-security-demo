package com.dbit.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index.html").permitAll()
                .antMatchers("/api/employees").authenticated()
                .antMatchers("/info").hasRole("ADMIN")
                .and().formLogin()
                .and().httpBasic()
                .and().logout().logoutSuccessUrl("/");
    }

    @Bean
    public UserDetailsService userDetailsService(@Autowired DataSource dataSource) {
        return new JdbcUserDetailsManager(dataSource);
//        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
//        manager.createUser(User.builder()
//                        .username("alex")
//                        .password("{bcrypt}$2a$12$Lv22bizCGwR5rzLhB1eUaO5CWp/7CVx3iYyT8B/bQYJ60Dn387k02")
//                        .roles("USER", "ADMIN")
//                .build());
//        manager.createUser(User.builder()
//                        .username("john")
//                        .password("s")
//                        .roles("USER")
//                .build());
//        return manager;
    }
}
