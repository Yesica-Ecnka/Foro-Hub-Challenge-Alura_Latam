package com.aluracursos.Foro_hub.topicos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record D_RegistroTopico(
        @NotBlank
        String autor,
        @NotBlank
        String mensaje,
        @NotBlank
        String nombreCurso,
        @NotBlank
        String titulo,
        @NotNull
        Estado status
) {
}
