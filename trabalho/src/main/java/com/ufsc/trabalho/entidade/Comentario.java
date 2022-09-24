package com.ufsc.trabalho.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Comentario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Date data;
    private String text;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "postagem_id")
    private Postagem postagem;

    public Comentario(){

    }

    public Comentario(Long id, String nome, Date data, String text, Postagem postagem) {
        this.postagem = postagem;
        this.id = id;
        this.nome = nome;
        this.data = data;
        this.text = text;
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Postagem getPostagem() {
        return postagem;
    }

    public void setPostagem(Postagem postagem) {
        this.postagem = postagem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comentario that = (Comentario) o;
        return id.equals(that.id) && nome.equals(that.nome) && data.equals(that.data) && text.equals(that.text) && postagem.equals(that.postagem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, data, text, postagem);
    }
}
