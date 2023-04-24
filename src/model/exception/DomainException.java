package model.exception;

public class DomainException extends RuntimeException { // Declaração da classe de exceção DomainException que é uma extensão da classe RuntimeException.
	private static final long serialVersionUID = 1L; // Declaração da versão da classe serializible (Exception).
	
	public DomainException(String msg) { // Construtor que recebe uma String como argumento que repassa msg para o contrutor da superclasse.
		super(msg);
	}

}
