package com.remedios.projeto.dto.user;

import com.remedios.projeto.domain.user.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
