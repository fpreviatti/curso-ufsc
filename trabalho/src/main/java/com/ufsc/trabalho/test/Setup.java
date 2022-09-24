package com.ufsc.trabalho.test;

import com.ufsc.trabalho.entidade.Comentario;
import com.ufsc.trabalho.entidade.Editor;
import com.ufsc.trabalho.entidade.Postagem;
import com.ufsc.trabalho.repository.ComentarioRepository;
import com.ufsc.trabalho.repository.EditorRepository;
import com.ufsc.trabalho.repository.PostagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Configuration
@Profile("test")
public class Setup implements CommandLineRunner{

	// dependency injection
	@Autowired
	private ComentarioRepository comentarioRepository;

	@Autowired
	private PostagemRepository postagemRepository;

	@Autowired
	private EditorRepository editorRepository;

	@Override
	public void run(String... args) throws Exception {

		Editor e1 = new Editor(1L, "Marcos Peixoto", "123456");
		Editor e2 = new Editor(2L, "Daniela Beltrão", "123456");
		Editor e3 = new Editor(3L, "Fernando Cardoso", "123456");

		editorRepository.saveAll(Arrays.asList(e1,e2,e3));

		Postagem p1 = new Postagem(1L, new Date(), "Alerta de temporal", "Alerta de fortes chuvas preocupa moradores",e1);
		Postagem p2 = new Postagem(2L, new Date(), "Nova pesquisa eleitoral", "Nova pesquisa eleitoral trás candidato x na frente de candidato y",e2);
		Postagem p3 = new Postagem(3L, new Date(), "Novidades na área de T.I", "Esta semana temos novidades na área de T.I",e3);

		postagemRepository.saveAll(Arrays.asList(p1,p2,p3));

		Comentario c1 = new Comentario(1l, "Juquinha", new Date(), "Estou preocupado com este alerta",p1);
		Comentario c2 = new Comentario(2l, "Marco Aurélio", new Date(), "Não há motivos para preocupação, deve vai passar em breve",p1);
		Comentario c3 = new Comentario(3l, "Maria Francisca", new Date(), "O Candidato x vai ganhar com facilidade.",p2);
		Comentario c4 = new Comentario(4l, "Amanda Nunes", new Date(), "Muita coisa ainda pode acontecer até as eleições.",p2);
		Comentario c5 = new Comentario(5l, "Pedro Pedroso", new Date(), "Muito legal estas novidades",p3);
		Comentario c6 = new Comentario(6l, "Bruno Monteiro", new Date(), "Não estou tão empolgado com esta notícia.",p3);

		comentarioRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6));

	}

}
