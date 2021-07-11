package br.com.alura.escola.gameficacao.dominio.selo;

import java.util.List;

import br.com.alura.escola.academico.dominio.aluno.CPF;

public interface RepositorioDeSelos {
	
	void adicionar(Selo selo);
	List<Selo> selosDeAlunoDeCPF(CPF cpf);
}
