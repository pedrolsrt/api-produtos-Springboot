package com.example.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.app.model.Produto;
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}

