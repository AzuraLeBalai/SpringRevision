package fr.nextoo.nextflix.back.demo.config;

import fr.nextoo.nextflix.back.demo.exeption.BadInputException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExeptionHandlerAvisor {
	@ExceptionHandler(BadInputException.class)
	public ResponseEntity<String> handleBadInputException(BadInputException e) {
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
}
