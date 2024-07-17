package com.aluracursos.Foro_hub.controller;

import com.aluracursos.Foro_hub.topicos.D_ListadoTopico;
import com.aluracursos.Foro_hub.topicos.ITopicoRepositorio;
import com.aluracursos.Foro_hub.topicos.*;
import com.aluracursos.Foro_hub.topicos.D_ActulizarElTopico;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.hibernate.query.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    ITopicoRepositorio iTopicoRepositorio;

    @GetMapping
    public ResponseEntity<Page<D_ListadoTopico>> llamar(@PageableDefault(page=0, size=10, sort={"fechaCreacion"}) Pageable paginacion) {
        Page<Topico> topicos = iTopicoRepositorio.findAll(paginacion);
        Page<D_ListadoTopico> listadoTopicos = topicos.map(D_ListadoTopico::new);
        return ResponseEntity.ok(listadoTopicos);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<D_ListadoTopico> listarTopicoPorId(@PathVariable Long id) {
        try {
            Topico topicoEncontrado = ITopicoRepositorio.getReferenceById(id);
            return ResponseEntity.ok(new D_ListadoTopico(topicoEncontrado));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<D_RespuestaDelTopico> registrarTopico(@RequestBody @Valid D_RegistroTopico datosRegistroTopico,
                                                                UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = ITopicoRepositorio.save(new Topico(datosRegistroTopico));
        D_RespuestaDelTopico datosRespuestaTopico = new D_RespuestaDelTopico(topico);

        URI url;
        url = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();
        return ResponseEntity.created(url).body(datosRespuestaTopico);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity actualizarElTopico(@PathVariable Long id,  @RequestBody D_ActualizarTopico d_ActualizarTopico) {
        Optional<Topico> topicoBuscado = Optional.of(ITopicoRepositorio.getReferenceById(id));
        if (topicoBuscado.isPresent()) {
            Topico topicoEncontrado = topicoBuscado.get();
            topicoEncontrado.actualizarElTopico(d_ActualizarTopico);
            return ResponseEntity.ok(new D_RespuestaTopico(topicoEncontrado));
        }

        return ResponseEntity.notFound().build();
    }

}
