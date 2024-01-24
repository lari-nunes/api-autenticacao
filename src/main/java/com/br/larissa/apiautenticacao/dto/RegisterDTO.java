package com.br.larissa.apiautenticacao.dto;

import com.br.larissa.apiautenticacao.model.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
