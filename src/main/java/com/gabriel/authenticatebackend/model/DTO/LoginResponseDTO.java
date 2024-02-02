package com.gabriel.authenticatebackend.model.DTO;

import com.gabriel.authenticatebackend.model.ApplicationUser;

public record LoginResponseDTO(
        ApplicationUser user,
        String jwt
) {
}
