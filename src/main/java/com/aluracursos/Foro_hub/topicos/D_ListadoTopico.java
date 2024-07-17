package com.aluracursos.Foro_hub.topicos;

public record D_ListadoTopico(Long id,
    String titulo,
    String mensaje,
    String fechaCreacion,
    Estado estado,
    String autor,
    String curso
) {

    public D_ListadoTopico(Topico topico) {
        this(topico.getId(), topico.getTitulo(), topico.getMensaje(),
                topico.getFechaCreacion().toString(), topico.getStatus(),
                topico.getAutor(), topico.getCurso());
    }
}
