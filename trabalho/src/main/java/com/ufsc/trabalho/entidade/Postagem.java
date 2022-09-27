package com.ufsc.trabalho.entidade;

import javax.persistence.*;
import java.util.*;

@Entity
public class Postagem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date data;
    private String titulo;
    private String texto;

    private Double totalPalavras=0d;

    @ManyToMany
    @JoinTable(name = "assunto_postagem", joinColumns = @JoinColumn(name = "postagem_id"),
            inverseJoinColumns = @JoinColumn(name="assunto_id"))
    private List<Assunto> assuntos = new ArrayList<>();

    @OneToMany(mappedBy = "postagem")
    private List<Comentario> comentarios;

    public List<Assunto> getAssuntos() {
        return assuntos;
    }

    public void setAssuntos(List<Assunto> assuntos) {
        this.assuntos = assuntos;
    }

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

    public Double getTotalPalavras() {

        StringTokenizer stTexto = new StringTokenizer(this.getTexto());
        stTexto.countTokens();

        StringTokenizer stTitulo = new StringTokenizer(this.getTitulo());
        stTitulo.countTokens();

        return Double.valueOf(stTexto.countTokens() + stTitulo.countTokens());
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Postagem postagem = (Postagem) o;
        return id.equals(postagem.id) && data.equals(postagem.data) && titulo.equals(postagem.titulo) && texto.equals(postagem.texto) && assuntos.equals(postagem.assuntos) && comentarios.equals(postagem.comentarios) && editor.equals(postagem.editor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, data, titulo, texto, assuntos, comentarios, editor);
    }
}
