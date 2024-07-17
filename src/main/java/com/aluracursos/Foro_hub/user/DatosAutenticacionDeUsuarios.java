package com.aluracursos.Foro_hub.user;

import jakarta.validation.constraints.NotBlank;

public record DatosAutenticacionDeUsuarios(
        @NotBlank
        String login,
        @NotBlank
        String clave
) {
}
