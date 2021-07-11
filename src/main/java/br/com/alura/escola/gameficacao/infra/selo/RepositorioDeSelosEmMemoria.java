package br.com.alura.escola.gameficacao.infra.selo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import br.com.alura.escola.gameficacao.dominio.selo.RepositorioDeSelos;
import br.com.alura.escola.gameficacao.dominio.selo.Selo;
import br.com.alura.escola.shared.dominio.CPF;

public class RepositorioDeSelosEmMemoria implements RepositorioDeSelos{
	private List<Selo> selos  = new ArrayList<>(); 
	@Override
	public void adicionar(Selo selo) {
		selos.add(selo);
	}

	@Override
	public List<Selo> selosDeAlunoDeCPF(CPF cpf) {
		return selos.stream().filter(selo ->
		            selo.getCpfDoAluno().getNumero().equals(cpf.getNumero()))
				.collect(Collectors.toList());
	}
	
}
