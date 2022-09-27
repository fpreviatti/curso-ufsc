package com.ufsc.trabalho.service;

import com.ufsc.trabalho.entidade.Assunto;
import com.ufsc.trabalho.entidade.Editor;
import com.ufsc.trabalho.repository.AssuntoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class AssuntoService {


    @Autowired
    private AssuntoRepository assuntoRepository;

    public List<Assunto> getAssuntos(){

        return assuntoRepository.findAll();

    }

    public Assunto findById(Long id){

        try {
            return assuntoRepository.findById(id).get();
        } catch(NoSuchElementException e) {
            throw new EntityNotFoundException("Assunto id " + id +" não encontrado");
        }

    }

    public Assunto saveAssunto(Assunto assunto){
        return assuntoRepository.save(assunto);
    }

    public Assunto updateAssunto(Long id, Assunto assunto) {

        Assunto assuntoEntity = findById(id);
        assuntoEntity.setDescricao(assunto.getDescricao());

        return assuntoRepository.save(assuntoEntity);

    }

    public void deleteById(Long id) {
        findById(id);
        assuntoRepository.deleteById(id);
    }
}
