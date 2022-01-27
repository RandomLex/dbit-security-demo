package com.dbit.config;


import com.dbit.services.auth.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index.html").permitAll()
                .antMatchers("/api/employees").authenticated()
                .antMatchers("/info").hasAnyAuthority("ROLE_ADMIN", "READ_INFO")
//                .antMatchers("/info").hasAnyAuthority("ROLE_ADMIN")
                .antMatchers("/self").hasRole("USER")
                .and().formLogin()
                .and().httpBasic()
                .and().logout().logoutSuccessUrl("/")
                .and().csrf().disable();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider(@Autowired UserDetailsService userService,
                                                               @Autowired PasswordEncoder passwordEncoder) {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder);
        return daoAuthenticationProvider;
    }

//    @Bean
//    public UserDetailsService userDetailsService(@Autowired DataSource dataSource) {
//        return new JdbcUserDetailsManager(dataSource);
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
//    }
}
