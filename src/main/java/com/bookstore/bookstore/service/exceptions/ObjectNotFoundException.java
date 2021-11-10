package com.bookstore.bookstore.service.exceptions;

public class ObjectNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ObjectNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
}

/*
 * Classe utilizada para tratar exceção de objeto não encontrado: em casos onde
 * o método get tem requisição bem sucedida (retornando código 200) mas não existem
 * objetos cadastrados para aquela "categoria". No lugar, tratamos a requisição bem
 * sucedida seguida de nenhum retorno como objeto não encontrado de código 404.
 */