//package aea.user_management.security;
//
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfiguration {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                .requestMatchers("/swagger-ui/**", "/swagger-resources/**", "/v2/api-docs", "/webjars/**").permitAll()
//                .requestMatchers("/api/**").authenticated()
//                .anyRequest().permitAll()
//                .and()
//                .formLogin()
//                .loginPage("/login") // صفحه ورود کاربر
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//    }
//}