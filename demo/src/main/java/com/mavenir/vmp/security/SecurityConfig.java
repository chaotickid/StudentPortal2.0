package com.mavenir.vmp.security;

import com.mavenir.vmp.security.handler.*;
import com.mavenir.vmp.user.UserDetailsFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import jakarta.servlet.Filter;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true) // Equivalent to EnableGlobalMethodSecurity
public class SecurityConfig {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private NoOpLogoutHandler logoutHandler;

    @Autowired
    private NoOpAuthenticationSuccessHandler loginHandler;

    @Autowired
    private UserDetailsFactory userDetailsFactory;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsFactory);
        authProvider.setPasswordEncoder(passwordEncoder);
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {
        return authConfig.getAuthenticationManager();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf
                        .requireCsrfProtectionMatcher(new CsrfRequestMatcher())
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/").permitAll()
                        .anyRequest().authenticated()
                )
                .exceptionHandling(exception -> exception
                        .authenticationEntryPoint(new CsrfAuthenticationEntryPoint())
                        .accessDeniedHandler(new CsrfAccessDeniedHandler())
                )
                .rememberMe(rememberMe -> rememberMe
                        .useSecureCookie(true)
                        .tokenValiditySeconds(60)
                        .authenticationSuccessHandler(loginHandler)
                )
                .logout(logout -> logout
                        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                        .addLogoutHandler(logoutHandler)
                        .logoutSuccessHandler(new NoOpLogoutSuccessHandler())
                        .deleteCookies("remember-me")
                )
                .authenticationProvider(authenticationProvider()); // Add the custom authentication provider
                //.addFilterBefore(createAuthenticationFilter(authenticationManager()), UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    /**
     * Custom Authentication Filter.
     */
    @Bean
    public Filter createAuthenticationFilter(AuthenticationManager authenticationManager) {
        UsernamePasswordAuthenticationFilter filter = new UsernamePasswordAuthenticationFilter();
        filter.setAuthenticationManager(authenticationManager);
        filter.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login"));
        filter.setUsernameParameter("username");
        filter.setPasswordParameter("password");
        filter.setAuthenticationSuccessHandler(loginHandler);
        return filter;
    }
}
