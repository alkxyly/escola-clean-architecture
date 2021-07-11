package br.com.alura.escola.academico.dominio.aluno;

import java.util.ArrayList;
import java.util.List;

import br.com.alura.escola.academico.dominio.exception.NumeroMaximoTelefoneAlunoException;

public class Aluno {
	
	private CPF cpf;
	private String nome;
	private Email email;
	
	private List<Telefone> telefones = new  ArrayList<>();
	
	private String senha;
	
	public Aluno(CPF cpf, String nome, Email email) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void adicionarTelefone(String ddd, String telefone) {
		if(this.telefones.size() == 2) 
			throw new NumeroMaximoTelefoneAlunoException("Número máximo de telefone atingido");

		this.telefones.add(new Telefone(ddd, telefone));
	}


	public CPF getCpf() {
		return cpf;
	}


	public void setCpf(CPF cpf) {
		this.cpf = cpf;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email.getEndereco();
	}


	public void setEmail(Email email) {
		this.email = email;
	}


	public List<Telefone> getTelefones() {
		return telefones;
	}


	public void setTelefones(List<Telefone> telefones) {
		this.telefones = telefones;
	}
	
	
}
