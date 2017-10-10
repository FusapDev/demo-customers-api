package ar.com.fusap.sample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value=HttpStatus.CONFLICT, reason="Customer already exists")
public class CustomerConflictException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
