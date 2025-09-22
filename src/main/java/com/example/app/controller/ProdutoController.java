package com.example.app.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.app.model.Produto;
import com.example.app.service.ProdutoService;

import lombok.AllArgsConstructor;

// localhost:8000/api/v1/produtos/all

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/produtos")
public class ProdutoController {
    
        @Autowired
        private final ProdutoService produtoService;

        @GetMapping(path = "/all")
        public ResponseEntity<List<Produto>> listarProdutos(){
            List<Produto> produtos = produtoService.listarTodosProdutos();
            return new ResponseEntity<>(produtos, HttpStatus.OK);
        }
}
