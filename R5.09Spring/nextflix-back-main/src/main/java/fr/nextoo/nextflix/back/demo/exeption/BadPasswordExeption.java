package fr.nextoo.nextflix.back.demo.exeption;

import org.springframework.validation.Errors;

public class BadPasswordExeption extends BadInputException{

	public BadPasswordExeption(final String message) {
		super(message);
	}

	public BadPasswordExeption(final String message, Throwable cause) {
		super(message,cause);
	}

	public BadPasswordExeption(final String message, Errors errors) {
		super(message, (Throwable) errors);
	}
}
