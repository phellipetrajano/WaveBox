package br.com.wavebox.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean 
    public PasswordEncoder passwordEncoder() { 
        return new BCryptPasswordEncoder(); 
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> auth
            .anyRequest().permitAll() // Permite acesso a todas as requisições
        )
        .formLogin(formLogin -> formLogin
            .loginPage("/login")
            .permitAll() // Permite que todos acessem a página de login
        )
        .logout(logout -> logout
            .logoutUrl("/signout")
            .permitAll() // Permite que todos acessem a funcionalidade de logout
        );

        return http.build();
    }
}