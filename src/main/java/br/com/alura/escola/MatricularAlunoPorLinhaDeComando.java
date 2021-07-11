package br.com.alura.escola;

import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAluno;
import br.com.alura.escola.academico.aplicacao.aluno.matricular.MatricularAlunoDTO;
import br.com.alura.escola.academico.dominio.aluno.LogDeAlunoMatriculado;
import br.com.alura.escola.academico.infra.aluno.RepositorioDeAlunosEmMemoria;
import br.com.alura.escola.gameficacao.aplicacao.GeraSeloAlunoNovato;
import br.com.alura.escola.gameficacao.infra.selo.RepositorioDeSelosEmMemoria;
import br.com.alura.escola.shared.dominio.evento.PublicadorDeEventos;

public class MatricularAlunoPorLinhaDeComando {

	public static void main(String[] args) {
		String nome = "João Costa";
		String cpf = "123.456.789-89";
		String email =  "fulano@gmail.com";
		
		PublicadorDeEventos publicador = new PublicadorDeEventos();
		publicador.adicionar(new LogDeAlunoMatriculado());
		publicador.adicionar(new GeraSeloAlunoNovato(new RepositorioDeSelosEmMemoria()));
		
		MatricularAluno matricular = new MatricularAluno(new RepositorioDeAlunosEmMemoria(), publicador);
		matricular.executa(new MatricularAlunoDTO(nome, cpf, email));
	}

}
