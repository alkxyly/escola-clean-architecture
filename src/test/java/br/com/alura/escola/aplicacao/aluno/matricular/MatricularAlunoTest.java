package br.com.alura.escola.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.PublicadorDeEventos;
import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

class MatricularAlunoTest {

	@Test
	void AlunoDeveriaSerPersistido() {
		RepositorioDeAlunos repositorio = new RepositorioDeAlunosEmMemoria();
		
		PublicadorDeEventos publicador = new PublicadorDeEventos();
		publicador.adicionar(new LogDeAlunoMatriculado());
		
		MatricularAluno useCase = new MatricularAluno(repositorio, publicador);
		
		MatricularAlunoDTO dados = new MatricularAlunoDTO("Fulano","123.123.456-89", "fulano@gmail.com");
		useCase.executa(dados);
		
		Aluno encontrado = repositorio.buscarPorCpf(new CPF("123.123.456-89"));
		
		assertEquals("Fulano", encontrado.getNome());
		assertEquals("123.123.456-89", encontrado.getCpf().getNumero());
		
	}
	
}
