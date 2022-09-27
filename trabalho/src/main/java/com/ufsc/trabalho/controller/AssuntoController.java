package com.ufsc.trabalho.controller;

import com.ufsc.trabalho.entidade.Assunto;

import com.ufsc.trabalho.service.AssuntoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class AssuntoController {

    @Autowired
    private AssuntoService assuntoService;

    @GetMapping(value = "/assuntos")
    public ResponseEntity<List<Assunto>> getAssuntos(){

        List<Assunto> assuntos = assuntoService.getAssuntos();
        return ResponseEntity.ok().body(assuntos);
    }

    @GetMapping(value = "/assuntos/{id}")
    public ResponseEntity<Assunto> getAssuntoById(@PathVariable Long id){
        Assunto assunto = assuntoService.findById(id);

        return ResponseEntity.ok().body(assunto);
    }

    @PostMapping(value = "/assuntos")
    public ResponseEntity<Assunto> saveAssunto(@RequestBody Assunto assunto){

        Assunto assuntoSalvo = assuntoService.saveAssunto(assunto);

        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/assuntos/{id}")
                .buildAndExpand(assuntoSalvo.getId()).toUri();

        return ResponseEntity.created(uri).body(assuntoSalvo);

    }

    @PutMapping(value = "/assuntos/{id}")
    public ResponseEntity<Assunto> atualizaAssunto(@PathVariable Long id, @RequestBody Assunto assunto){

        Assunto assuntoAtualizado = assuntoService.findById(id);
        assuntoAtualizado = assuntoService.updateAssunto(id, assunto);

        return ResponseEntity.ok().body(assuntoAtualizado);

    }

    @DeleteMapping(value = "/assuntos/{id}")
    public ResponseEntity<Assunto> deleteAssunto(@PathVariable Long id){

        assuntoService.deleteById(id);
        return ResponseEntity.noContent().build();

    }

}
