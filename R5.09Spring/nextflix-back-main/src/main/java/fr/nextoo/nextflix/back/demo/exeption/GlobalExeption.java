package fr.nextoo.nextflix.back.demo.exeption;

import java.util.Collections;
import java.util.List;
import java.util.MissingFormatArgumentException;
import java.util.concurrent.ExecutionException;

public class GlobalExeption extends RuntimeException {

	public GlobalExeption(String message) {
		super(message);
	}

	public GlobalExeption(String message, Throwable cause) {
		super(message, cause);
	}
}
