package com.ufsc.trabalho.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Editor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String senha;

    @JsonIgnore
    @OneToMany(mappedBy = "editor")
    private List<Postagem> postagens;

    public Editor(){

    }

    public Editor(Long id, String nome, String senha) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public List<Postagem> getPostagens() {
        return postagens;
    }

    public Double getTotalPostagens(){
        double totalPostagens = 0d;

        totalPostagens = getPostagens().size();

        return totalPostagens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Editor editor = (Editor) o;
        return id.equals(editor.id) && nome.equals(editor.nome) && senha.equals(editor.senha) && postagens.equals(editor.postagens);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, senha, postagens);
    }
}
