package com.aluracursos.Foro_hub.topicos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of="id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String autor;
    private String mensaje;
    private String curso;
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Estado status;
    private LocalDateTime fechaCreacion;

    public Topico(D_RegistroTopico d_registroTopico){
        this.autor = d_registroTopico.autor();
        this.mensaje = d_registroTopico.mensaje();
        this.curso = d_registroTopico.nombreCurso();
        this.titulo =d_registroTopico.titulo();
        this.status = d_registroTopico.status();
        this.fechaCreacion = LocalDateTime.now();
    }

    public void actualizarElTopico(D_ActulizarElTopico actulizarElTopico){
        this.autor = actulizarElTopico.autor();
        this.mensaje = actulizarElTopico.mensaje();
        this.curso = actulizarElTopico.nombreCurso();
        this.titulo = actulizarElTopico.titulo();
        this.status = Estado.valueOf(actulizarElTopico.estatus());
        this.fechaCreacion = LocalDateTime.now();
    }



}
