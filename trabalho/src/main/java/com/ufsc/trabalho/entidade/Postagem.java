package com.ufsc.trabalho.entidade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;
    private String titulo;
    private String texto;

    @OneToMany(mappedBy = "postagem")
    private List<Comentario> comentarios;


    @ManyToOne
    @JoinColumn(name = "editor_id")
    private Editor editor;

    public Postagem(){

    }

    public Editor getEditor() {
        return editor;
    }

    public void setEditor(Editor editor) {
        this.editor = editor;
    }

    public Postagem(Long id, Date data, String titulo, String texto, Editor editor) {
        this.editor = editor;
        this.id = id;
        this.data = data;
        this.titulo = titulo;
        this.texto = texto;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Postagem postagem = (Postagem) o;
        return id.equals(postagem.id) && data.equals(postagem.data) && titulo.equals(postagem.titulo) && texto.equals(postagem.texto) && comentarios.equals(postagem.comentarios) && editor.equals(postagem.editor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, titulo, texto, comentarios, editor);
    }
}
