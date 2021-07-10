package br.com.alura.escola.aplicacao.aluno.matricular;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import br.com.alura.escola.dominio.aluno.Aluno;
import br.com.alura.escola.dominio.aluno.CPF;
import br.com.alura.escola.dominio.aluno.Email;
import br.com.alura.escola.dominio.aluno.RepositorioDeAlunos;
import br.com.alura.escola.dominio.exception.NumeroMaximoTelefoneAlunoException;
import br.com.alura.escola.infra.aluno.RepositorioDeAlunosEmMemoria;

class MatricularAlunoTest {

	@Test
	void AlunoDeveriaSerPersistido() {
		RepositorioDeAlunos repositorio = new RepositorioDeAlunosEmMemoria();
		
		MatricularAluno useCase = new MatricularAluno(repositorio);
		
		MatricularAlunoDTO dados = new MatricularAlunoDTO("Fulano","123.123.456-89", "fulano@gmail.com");
		useCase.executa(dados);
		
		Aluno encontrado = repositorio.buscarPorCpf(new CPF("123.123.456-89"));
		
		assertEquals("Fulano", encontrado.getNome());
		assertEquals("123.123.456-89", encontrado.getCpf());
		
	}
	
}
