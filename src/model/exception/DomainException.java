package model.exception;

public class DomainException extends RuntimeException { // Declara��o da classe de exce��o DomainException que � uma extens�o da classe RuntimeException.
	private static final long serialVersionUID = 1L; // Declara��o da vers�o da classe serializible (Exception).
	
	public DomainException(String msg) { // Construtor que recebe uma String como argumento que repassa msg para o contrutor da superclasse.
		super(msg);
	}

}
