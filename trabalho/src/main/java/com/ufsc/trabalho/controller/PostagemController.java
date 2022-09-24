package com.ufsc.trabalho.controller;

import com.ufsc.trabalho.entidade.Comentario;
import com.ufsc.trabalho.entidade.Editor;
import com.ufsc.trabalho.entidade.Postagem;
import com.ufsc.trabalho.service.ComentarioService;
import com.ufsc.trabalho.service.EditorService;
import com.ufsc.trabalho.service.PostagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PostagemController {

    @Autowired
    private PostagemService postagemService;

    @Autowired
    private EditorService editorService;

    @Autowired
    private ComentarioService comentarioService;

    @GetMapping(value = "/postagens")
    public ResponseEntity<List<Postagem>> getPostagens(){
        List<Postagem> postagens = postagemService.findAll();
        return ResponseEntity.ok().body(postagens);
    }

    @GetMapping(value = "/postagens/{id}")
    public ResponseEntity<Postagem> getPostagemById(@PathVariable Long id){
        Postagem postagem = postagemService.findById(id);
        return ResponseEntity.ok().body(postagem);
    }

    @GetMapping(value = "/postagens/editor/{id}")
    public ResponseEntity<List<Postagem>> getPostagensByEditorId(@PathVariable Long id){
        Editor editor = editorService.findById(id);
        List<Postagem> postagensDoEditor = editor.getPostagens();
        return ResponseEntity.ok().body(postagensDoEditor);
    }

    @PostMapping(value = "/postagens/editor/{id}")
    public ResponseEntity<Postagem> savePostagemByEditorId(@PathVariable Long id, @RequestBody Postagem postagem){
        Editor editor = editorService.findById(id);
        Postagem postagemSalva = postagemService.salvarPostagem(postagem,editor);
        return ResponseEntity.ok().body(postagemSalva);
    }

    @PutMapping(value = "/postagens/{id}")
    public ResponseEntity<Postagem> updatePostagem(@PathVariable Long id, @RequestBody Postagem postagem){

        Postagem postagemAtualizada = postagemService.update(id,postagem);
        return ResponseEntity.ok().body(postagemAtualizada);

    }

}
