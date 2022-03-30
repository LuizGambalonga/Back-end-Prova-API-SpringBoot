package com.Projeto.Betha.Exception;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity handleException(Exception e) {
		 MensagemResponse mensagem = new MensagemResponse();
		 mensagem.setCodigo(HttpStatus.BAD_REQUEST.value());
		 mensagem.setMensagem("Algum campo está invalido, verifique os dados e tente novamente!");
		return new ResponseEntity(mensagem, HttpStatus.BAD_REQUEST);
	}
}
