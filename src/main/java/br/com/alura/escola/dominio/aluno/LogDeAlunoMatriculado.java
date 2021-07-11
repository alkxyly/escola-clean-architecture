package br.com.alura.escola.dominio.aluno;

import java.time.format.DateTimeFormatter;

import br.com.alura.escola.dominio.Evento;
import br.com.alura.escola.dominio.Ouvinte;

public class LogDeAlunoMatriculado extends Ouvinte{
	
	public void reageAo(Evento evento) {
		String momentoFormatado = ((AlunoMatriculado) evento).getMomento()
				.format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
		
		System.out.println(
				String.format("Aluno com cpf %s  matriculado em: %s", 
						((AlunoMatriculado) evento).getCpfDoAluno().getNumero(),
						momentoFormatado));
	}

	@Override
	protected boolean deveProcessar(Evento evento) {
		return evento instanceof AlunoMatriculado;
	}
}
