package com.exemplo.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.exemplo.app.model.Produto;

public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}

