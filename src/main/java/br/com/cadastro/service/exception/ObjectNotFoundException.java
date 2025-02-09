package br.com.cadastro.service.exception;

// Service to handle exceptions for an object that's not found
public class ObjectNotFoundException extends RuntimeException {

	// Serialized version
	private static final long serialVersionUID = 1L;
	
	// Overloads
	public ObjectNotFoundException (String message) {
		super(message);
	}
	
	public ObjectNotFoundException (String message, Exception exception) {
		super (message, exception);
	}
	
	public ObjectNotFoundException (Exception exception) {
		super (exception);
	}

	
}
