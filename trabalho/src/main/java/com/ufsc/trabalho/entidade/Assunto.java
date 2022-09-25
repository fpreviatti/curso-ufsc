package com.ufsc.trabalho.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.*;

@Entity
public class Assunto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    public Assunto(){

    }

    @JsonIgnore
    @ManyToMany(mappedBy = "assuntos")
    private List<Postagem> postagens = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public List<Postagem> getPostagens() {
        return postagens;
    }

    public void setPostagens(List<Postagem> postagens) {
        this.postagens = postagens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Assunto assunto = (Assunto) o;
        return id.equals(assunto.id) && descricao.equals(assunto.descricao) && postagens.equals(assunto.postagens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, postagens);
    }
}
