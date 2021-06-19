package escola;

import java.util.ArrayList;
import java.util.List;

public class Aluno {
	
	private CPF cpf;
	private String nome;
	private Email email;
	private List<Telefone> telefones = new  ArrayList<>();
	
	public void adicionarTelefone(String ddd, String telefone) {
		this.telefones.add(new Telefone(ddd, telefone));
	}
}
