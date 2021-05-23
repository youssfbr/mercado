package com.github.youssfbr.mercado.domain.repositories.exception;

public class ProdutoNaoEncontradoException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public ProdutoNaoEncontradoException(String message) {
		super(message);
	}	

}
