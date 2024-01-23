package com.br.larissa.apiautenticacao.repository;

import com.br.larissa.apiautenticacao.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UserRepository extends JpaRepository<User, String> {

    // consulta usuários pelo login (nome, email, etc...).
    UserDetails findByLogin(String login);
}
