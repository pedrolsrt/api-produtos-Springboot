package com.example.app.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.app.model.Produto;
import com.example.app.service.ProdutoService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

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
        
        @GetMapping(path = "/{id}")
        public ResponseEntity<Produto> buscarProdutoPorID(@PathVariable Long id) {
            Optional<Produto> produto = produtoService.buscarProdutoPorId(id);
            return new ResponseEntity<>(produto.get(), HttpStatus.OK);
        }

        @PostMapping
        public ResponseEntity<Produto> adicionarProduto(@Valid @RequestBody Produto produto) {
            Produto novoProduto = produtoService.salvarProduto(produto);
            return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);
        }

        @PutMapping(path = "/{id}")
        public ResponseEntity<?> atualizarProduto(@PathVariable Long id, @RequestBody Produto produtoAtualizado) {

            try {
                Produto produto = produtoService.atualizarProduto(id, produtoAtualizado);
                return new ResponseEntity<>(produto, HttpStatus.OK);

            } catch (IllegalArgumentException e) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
            }

    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> excluir(@PathVariable("id") Long id) {
        produtoService.excluirProduto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}