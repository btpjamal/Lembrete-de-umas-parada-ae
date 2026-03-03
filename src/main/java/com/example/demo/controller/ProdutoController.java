package com.example.demo.controller;

import com.example.demo.DTO.ProdutoDTO;
import com.example.demo.model.ProdutoModel;
import com.example.demo.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController{

    private final ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    // Criar novo produto
    @PostMapping("/create")
    public ResponseEntity<ProdutoDTO> criarProduto(@RequestBody ProdutoDTO produto) {
        ProdutoDTO novoProduto = produtoService.criarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoProduto);
    }

    // Listar todos os produtos
    @GetMapping("/readAll")
    public List<ProdutoDTO> listarTodos() {
        return produtoService.listarTodos();
    }

    // Buscar produto por ID
    @GetMapping("/read/{id}")
    public ResponseEntity<ProdutoDTO> buscarPorId(@PathVariable Long id) {
        return produtoService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Buscar produtos por categoria
    @GetMapping("/categoria/{categoriaId}")
    public List<ProdutoDTO> buscarPorCategoria(@PathVariable Long categoriaId) {
        return produtoService.buscarPorCategoria(categoriaId);
    }

    // Atualizar produto existente
    @PutMapping("/update/{id}")
    public ResponseEntity<ProdutoDTO> atualizarProduto(@PathVariable Long id, @RequestBody ProdutoDTO produto) {
        produto.setId(id);
        ProdutoDTO atualizado = produtoService.atualizarProduto(id,produto);
        return ResponseEntity.ok(atualizado);
    }

    // Deletar produto
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
