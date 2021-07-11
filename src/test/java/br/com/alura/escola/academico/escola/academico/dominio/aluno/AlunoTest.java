package br.com.alura.escola.academico.escola.academico.dominio.aluno;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.alura.escola.academico.dominio.aluno.Aluno;
import br.com.alura.escola.academico.dominio.aluno.Email;
import br.com.alura.escola.academico.dominio.exception.NumeroMaximoTelefoneAlunoException;
import br.com.alura.escola.shared.dominio.CPF;

class AlunoTest {

	private Aluno aluno;

	@BeforeEach
	void BeforeEach() {
		this.aluno = new Aluno(new CPF("123.456.789-78"), 
				"Fulano",
				new Email("fulano@gmail.com"));
	}

	@Test
	void deveriaPermitirAdicionar1Aluno() {
		this.aluno.adicionarTelefone("79", "9999998");
		assertEquals(1, this.aluno.getTelefones().size());
	}

	@Test
	void deveriaPermitirAdicionar2Aluno() {
		this.aluno.adicionarTelefone("79", "9999998");
		this.aluno.adicionarTelefone("79", "9999998");
		assertEquals(2, this.aluno.getTelefones().size());
	}

	@Test
	void naoDeveriaPermitir3Telefones() {
		assertThrows(NumeroMaximoTelefoneAlunoException.class, () ->{			
			this.aluno.adicionarTelefone("79", "9999998");
			this.aluno.adicionarTelefone("79", "9999998");
			this.aluno.adicionarTelefone("79", "9999998");
		});
	}

}
