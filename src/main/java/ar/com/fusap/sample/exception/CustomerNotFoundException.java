package ar.com.fusap.sample.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Customer")
public class CustomerNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

}
