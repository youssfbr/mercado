package com.github.youssfbr.mercado.api.models;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdutoModel {
	
	private Long id;
	private String nome;
	private BigDecimal preco;
	private SituacaoEstoque situacaoEstoque;
	private CategoriaModel categoria;

}
