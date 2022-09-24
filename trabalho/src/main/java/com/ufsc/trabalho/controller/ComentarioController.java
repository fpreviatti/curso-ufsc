package com.ufsc.trabalho.controller;

import com.ufsc.trabalho.entidade.Comentario;
import com.ufsc.trabalho.entidade.Postagem;
import com.ufsc.trabalho.service.ComentarioService;
import com.ufsc.trabalho.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComentarioController {

    @Autowired
    private ComentarioService comentarioService;

    @Autowired
    private PostagemService postagemService;

    @GetMapping(value = "/comentarios")
    public ResponseEntity<List<Comentario>> findAll(){

        List<Comentario> comentarios = comentarioService.findAll();
        return ResponseEntity.ok().body(comentarios);
    }

    @GetMapping(value = "/comentarios/postagem/{id}")
    public ResponseEntity<List<Comentario>> getComentariosPostagem(@PathVariable Long id){
        Postagem postagem = postagemService.findById(id);
        return ResponseEntity.ok().body(postagem.getComentarios());
    }

    @PostMapping(value = "/comentarios/postagem/{id}")
    public ResponseEntity<Comentario> saveComentario(@PathVariable Long id, @RequestBody Comentario comentario){
        Postagem postagem = postagemService.findById(id);
        comentarioService.salvarComentario(comentario, postagem);
        return ResponseEntity.ok().body(comentario);
    }

    @PutMapping(value = "/comentarios/{id}")
    public ResponseEntity<Comentario> updateComentario(@PathVariable Long id, @RequestBody Comentario comentario){

        Comentario comentarioAtualizado = comentarioService.update(id,comentario);
        return ResponseEntity.ok().body(comentarioAtualizado);
    }

    @DeleteMapping(value = "/comentarios/{id}")
    public ResponseEntity<Comentario> deleteComentario(@PathVariable Long id){
        comentarioService.delete(id);
        return ResponseEntity.noContent().build();
    }

}
