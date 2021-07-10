package br.com.alura.escola.dominio.exception;

public class NumeroMaximoTelefoneAlunoException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NumeroMaximoTelefoneAlunoException(String mensagem) {
		super(mensagem);
	}

	public NumeroMaximoTelefoneAlunoException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}
}
