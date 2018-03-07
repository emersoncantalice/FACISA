package br.edu.facisa.cwf.example5.exceptions;

public class ProductAlreadyExistsException extends Exception {

	private static final long serialVersionUID = 4592205311945878925L;

	public ProductAlreadyExistsException() {
		super();
	}

	public ProductAlreadyExistsException(String arg0) {
		super(arg0);
	}

}
