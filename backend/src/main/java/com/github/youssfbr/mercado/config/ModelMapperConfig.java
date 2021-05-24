package com.github.youssfbr.mercado.config;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.github.youssfbr.mercado.api.models.ProdutoModel;
import com.github.youssfbr.mercado.api.models.ProdutoSummaryModel;
import com.github.youssfbr.mercado.api.models.SituacaoEstoque;
import com.github.youssfbr.mercado.domain.models.Produto;

@Configuration
public class ModelMapperConfig {

	@Bean
	public ModelMapper modelMapper() {
		var modelMapper = new ModelMapper();
		
		Converter<Integer, SituacaoEstoque> situacaoEstoqueConverter = context 
				-> context.getSource() > 0 ? SituacaoEstoque.DISPONIVEL : SituacaoEstoque.ESGOTADO;
				
		modelMapper.createTypeMap(Produto.class, ProdutoModel.class)
			.addMappings(mapper -> mapper.using(situacaoEstoqueConverter)
				.map(Produto::getQuantidadeEstoque, ProdutoModel::setSituacaoEstoque));
		
		modelMapper.createTypeMap(Produto.class, ProdutoSummaryModel.class)
			.<String>addMapping(src -> src.getCategoria().getNome(), 
				(dest, value) -> dest.setCategoria(value));
		
		return modelMapper;
	}
}
