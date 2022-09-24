package com.ufsc.trabalho.service;

import com.ufsc.trabalho.entidade.Comentario;
import com.ufsc.trabalho.entidade.Postagem;
import com.ufsc.trabalho.repository.ComentarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ComentarioService {

    @Autowired
    private ComentarioRepository comentarioRepository;

    public void salvarComentario(Comentario comentario, Postagem postagem){
        comentario.setPostagem(postagem);
        comentarioRepository.save(comentario);
    }

    public void salvarListaComentarios(List<Comentario> comentarios){
        comentarioRepository.saveAll(comentarios);
    }

    public List<Comentario> findAll(){
        return comentarioRepository.findAll();
    }

    public Comentario findById(Long id){

        try {
            return comentarioRepository.findById(id).get();
        } catch(NoSuchElementException e) {
            throw new EntityNotFoundException("Comentario id " + id +" não encontrado");
        }

    }

    public Comentario update(Long id, Comentario comentario){
        Comentario comentarioEntity = findById(id);

        comentarioEntity.setData(comentario.getData());
        comentarioEntity.setNome(comentario.getNome());
        comentarioEntity.setText(comentario.getText());

        return comentarioRepository.save(comentarioEntity);

    }

    public void delete(Long id){
        Comentario comentario = findById(id);
        comentarioRepository.deleteById(id);
    }

}
