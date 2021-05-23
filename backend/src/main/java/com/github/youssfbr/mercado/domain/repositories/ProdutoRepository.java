package com.github.youssfbr.mercado.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.youssfbr.mercado.domain.models.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
