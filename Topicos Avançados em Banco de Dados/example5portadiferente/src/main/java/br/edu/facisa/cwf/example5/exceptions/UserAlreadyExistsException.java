package br.edu.facisa.cwf.example5.exceptions;

public class UserAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 9215114550740054933L;

	public UserAlreadyExistsException() {
		super();
	}

	public UserAlreadyExistsException(String arg0) {
		super(arg0);
	}

}
