package com.ufsc.trabalho.controller;

import com.ufsc.trabalho.entidade.Editor;
import com.ufsc.trabalho.entidade.Postagem;
import com.ufsc.trabalho.service.EditorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class EditorController {

    @Autowired
    private EditorService editorService;

    @GetMapping(value = "/editores")
    public ResponseEntity<List<Editor>> getEditores(){
        List<Editor> editores = editorService.findAll();
        return ResponseEntity.ok().body(editores);
    }

    @GetMapping(value = "/editores/{id}")
    public ResponseEntity<Editor> getEditorById(@PathVariable Long id){
        Editor editor = editorService.findById(id);
        return ResponseEntity.ok().body(editor);
    }

    @PostMapping(value = "/editores")
    public ResponseEntity<Editor> saveEditor(@RequestBody Editor editor){

        Editor editorSalvo = editorService.save(editor);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/editores/{id}")
                .buildAndExpand(editorSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(editorSalvo);

    }

    @PutMapping(value = "/editores/{id}")
    public ResponseEntity<Editor> updateEditor(@PathVariable Long id, @RequestBody Editor editor){
        Editor editorAtualizado = editorService.findById(id);
        editorAtualizado = editorService.update(id,editor);
        return ResponseEntity.ok().body(editorAtualizado);
    }

    @DeleteMapping(value = "/editores/{id}")
    public ResponseEntity<Editor> deleteEditor(@PathVariable Long id){
        editorService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
