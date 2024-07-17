package com.aluracursos.Foro_hub.topicos;

import org.springframework.data.jpa.repository.JpaRepository;

//el contrato
public interface ITopicoRepositorio extends JpaRepository<Topico, Long> {
}
