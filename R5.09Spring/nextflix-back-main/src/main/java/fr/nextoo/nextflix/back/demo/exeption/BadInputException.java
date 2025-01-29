package fr.nextoo.nextflix.back.demo.exeption;

import org.springframework.validation.Errors;

public class BadInputException extends GlobalExeption {

	public BadInputException(final String message) {
		super(message);
	}

	public BadInputException(final String message, Throwable cause) {
		super(message,cause);
	}

	public BadInputException(final String message, Errors errors) {
		super(message, (Throwable) errors);
	}
}
