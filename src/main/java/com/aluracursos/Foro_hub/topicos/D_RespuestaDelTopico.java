package com.aluracursos.Foro_hub.topicos;

public record D_RespuestaDelTopico(
        Long id,
        String autor,
        String mensaje,
        String curso,
        String titulo,
        String estado,
        String fechaCreacion
) {

    public D_RespuestaDelTopico(Topico topico){
        this(topico.getId(), topico.getAutor(), topico.getMensaje(), topico.getCurso(), topico.getTitulo(),
        topico.getStatus().toString(), topico.getFechaCreacion().toString());
    }
}
