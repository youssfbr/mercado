package com.github.youssfbr.mercado.api.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.youssfbr.mercado.api.models.ProdutoModel;
import com.github.youssfbr.mercado.api.models.ProdutoSummaryModel;
import com.github.youssfbr.mercado.domain.models.Produto;
import com.github.youssfbr.mercado.domain.repositories.ProdutoRepository;
import com.github.youssfbr.mercado.domain.repositories.exception.ProdutoNaoEncontradoException;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	
	private ProdutoRepository produtoRepository;
	private ModelMapper modelMapper;
	
	@GetMapping
	public List<ProdutoSummaryModel> listarTodos() {
		return produtoRepository.findAll()
				.stream().map(this::toProdutoSummaryModel)
				.collect(Collectors.toList());
	}
	
	@GetMapping("{id}")
	public ProdutoModel buscar(@PathVariable Long id) {
		Produto produto = produtoRepository.findById(id)
				.orElseThrow(() -> new ProdutoNaoEncontradoException("sdf"));
		
		return toProdutoModel(produto);
	}
	
	private ProdutoModel toProdutoModel(Produto produto) {
		
		return modelMapper.map(produto, ProdutoModel.class);		
	}
	
	private ProdutoSummaryModel toProdutoSummaryModel(Produto produto) {
		
		return modelMapper.map(produto, ProdutoSummaryModel.class);		
	}

}
