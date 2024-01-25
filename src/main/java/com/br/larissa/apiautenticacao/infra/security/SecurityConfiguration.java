package com.br.larissa.apiautenticacao.infra.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity // habilita a configuração de web security na classe
public class SecurityConfiguration {

    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity
                .csrf(csrf -> csrf.disable()) // Desativa a proteção contra CSRF (Cross-Site Request Forgery), uma vez que a aplicação parece estar utilizando autenticação baseada em token (STATELESS).
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS)) // Define a política de gerenciamento de sessão como STATELESS, o que implica que a aplicação não deve criar ou usar sessões HTTP.
                .authorizeHttpRequests(authorize -> authorize // Inicia a configuração de autorização para diferentes tipos de requisições HTTP.
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll() // Permite requisições HTTP POST para o endpoint "/auth/login sem necessidade de autenticação.
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll() // Permite requisições HTTP POST para o endpoint "/auth/register" sem necessidade de autenticação.
                        .requestMatchers(HttpMethod.POST, "/product").hasRole("ADMIN") // qualquer request que seja do tipo POST pro endpoint /product, o usuário terá a role de admin
                        .anyRequest().authenticated() // pra todas as demais requesições, será autenticado que será um usuário normal
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    // fornece a autenticação central para a aplicação, é usado para autenticar usuários para processar solicitações de autenticação.
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    // define a lógica para codificar e comparar senhas, é usada para garantir a segurança das senhas armazenadas no sistema.
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder(); // BCryptPasswordEncoder é uma classe que faz criptografia de senhas dos usuários
    }
}
