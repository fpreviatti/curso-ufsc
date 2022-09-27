package com.ufsc.trabalho.service;

import com.ufsc.trabalho.entidade.Comentario;
import com.ufsc.trabalho.entidade.Editor;
import com.ufsc.trabalho.entidade.Postagem;
import com.ufsc.trabalho.repository.ComentarioRepository;
import com.ufsc.trabalho.repository.EditorRepository;
import com.ufsc.trabalho.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PostagemService {

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    @Autowired
    private ComentarioService comentarioService;

    @Autowired
    private EditorService editorService;

    public Postagem salvarPostagem(Postagem postagem, Editor editor){
        postagem.setId(null);
        postagem.setEditor(editor);

        List<Comentario> comentarios = postagem.getComentarios();
        List<Comentario> comentariosDaPostagem = new ArrayList<>();

        for(Comentario comentario: postagem.getComentarios()){
            comentario.setId(null);
            comentario.setPostagem(postagem);
            comentariosDaPostagem.add(comentario);
        }

        Postagem savedPostagem = postagemRepository.save(postagem);

        comentarioService.salvarListaComentarios(postagem.getComentarios());

        if(comentarios!=null){
            for(int i=0; i<comentarios.size();i++){
                comentarios.get(i).setPostagem(savedPostagem);
            }

            comentarioService.salvarListaComentarios(postagem.getComentarios());
        }
        return savedPostagem;
    }

    public List<Postagem> findAll(){
        return postagemRepository.findAll();
    }

    public Postagem findById(Long id){

        try {
            return postagemRepository.findById(id).get();
        } catch(NoSuchElementException e) {
            throw new EntityNotFoundException("Postagem id " + id +" não encontrada");
        }

    }

    public Postagem update(Long id, Postagem postagem){

        Postagem postagemEntity = findById(id);

        List<Comentario> comentariosDaPostagem = new ArrayList<>();

        for(Comentario comentario: postagem.getComentarios()){
            comentarioService.findById(comentario.getId());
            comentario.setPostagem(postagemEntity);
            comentariosDaPostagem.add(comentario);
        }

        postagemEntity.setData(postagem.getData());
        postagemEntity.setTexto(postagem.getTexto());
        postagemEntity.setTitulo(postagem.getTitulo());

        Postagem savedPostagem = postagemRepository.save(postagemEntity);

        long aux=0L;
        for(int i=0; i<comentariosDaPostagem.size();i++){

            if(comentariosDaPostagem.get(i).getId()<=0){
                throw new IllegalArgumentException();
            }
            aux = comentariosDaPostagem.get(i).getId();
            comentarioRepository.findById(aux);

        }

        comentarioService.salvarListaComentarios(comentariosDaPostagem);
        return savedPostagem;

    }

    public void deletePostagem(Long id){

        Postagem postagem = findById(id);

        for(Comentario comentario: postagem.getComentarios()){
            comentarioService.findById(comentario.getId());
            comentarioService.delete(comentario.getId());

        }

        postagemRepository.deleteById(id);

    }

}
