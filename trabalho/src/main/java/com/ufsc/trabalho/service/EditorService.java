package com.ufsc.trabalho.service;

import com.ufsc.trabalho.entidade.Comentario;
import com.ufsc.trabalho.entidade.Editor;
import com.ufsc.trabalho.entidade.Postagem;
import com.ufsc.trabalho.repository.ComentarioRepository;
import com.ufsc.trabalho.repository.EditorRepository;
import com.ufsc.trabalho.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class EditorService {

    @Autowired
    private EditorRepository editorRepository;

    @Autowired
    private PostagemRepository postagemRepository;

    @Autowired
    private ComentarioRepository comentarioRepository;

    public Editor save(Editor editor){

        List<Editor> editores = findAll();

        for(Editor editorCompare: editores){
            if(editor.getId() == editorCompare.getId()){
                throw new IllegalArgumentException("Editor id " + editor.getId() +" já está cadastrado");
            }
        }

        return editorRepository.save(editor);

    }

    public List<Editor> findAll(){
        return editorRepository.findAll();
    }

    public Editor findById(Long id){

        try {
            return editorRepository.findById(id).get();
        } catch(NoSuchElementException e) {
            throw new EntityNotFoundException("Editor id " + id +" não encontrado");
        }

    }

    public Editor update(Long id, Editor editor){

        Editor editorEntity = findById(id);

        editorEntity.setNome(editor.getNome());
        editorEntity.setSenha(editor.getSenha());

        return editorRepository.save(editorEntity);
    }

    public void deleteById(Long id){
        Editor editor = findById(id);
        List<Postagem> postagens = postagemRepository.findAll();

        List<Comentario> comentarios = new ArrayList<>();

        for(Postagem postagem: postagens){
            if(postagem.getEditor().getId() == editor.getId()){
                comentarios = postagem.getComentarios();

                for(Comentario comentario: comentarios){
                    comentarioRepository.deleteById(comentario.getId());
                }
                postagemRepository.deleteById(postagem.getId());
            }
        }
        editorRepository.deleteById(id);
    }

    /*public List<Editor> getEditorByPostagemId(Long id){

       return editorRepository.getAllEditoresByPostagemId(id);

    }*/

}
