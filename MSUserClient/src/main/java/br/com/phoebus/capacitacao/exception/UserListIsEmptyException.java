package br.com.phoebus.capacitacao.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class UserListIsEmptyException extends Exception {

	private static final long serialVersionUID = 1L;

}