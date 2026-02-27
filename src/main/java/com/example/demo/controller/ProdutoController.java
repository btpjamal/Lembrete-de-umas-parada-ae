package com.example.demo.controller;

import com.example.demo.model.ProdutoModel;
import com.example.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController{

    @Autowired
    private ProdutoService produtoService;

    // Endpoint para criar um novo produto
    @PostMapping("/create")
    public ProdutoModel createProduto(@RequestBody ProdutoModel produto) {
        return produtoService.createProduto(produto);
    }

    // Endpoint para obter todos os produtos
    @GetMapping("/readAll")
    public List<ProdutoModel> getAllProdutos() {
        return produtoService.getAllProdutos();
    }

    // Endpoint para obter um produto por ID
    @GetMapping("/read/{id}")
    public ProdutoModel getProdutoById(@PathVariable Long id) {
        return produtoService.getProdutoById(id);
    }

    // Endpoint para atualizar um produto existente
    @PutMapping("/update/{id}")
    public ProdutoModel updateProduto(@PathVariable Long id, @RequestBody ProdutoModel produto)
    {
        return produtoService.updateProduto(id, produto);
    }

    // Endpoint para deletar um produto por ID
    @DeleteMapping("/delete/{id}")
    public void deleteProdutoById(@PathVariable Long id) {
        produtoService.deleteProdutoById(id);
    }

}
