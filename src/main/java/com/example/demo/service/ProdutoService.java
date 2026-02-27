package com.example.demo.service;

import com.example.demo.model.ProdutoModel;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // CRUD - Create, Read, Update, Delete

    // Create - Criar um novo produto
    public ProdutoModel createProduto(ProdutoModel produto) {
        return produtoRepository.save(produto);
    }

    // Read - Ler todos os produtos ou um produto específico
    public List<ProdutoModel> getAllProdutos() {
        return produtoRepository.findAll();
    }

    public ProdutoModel getProdutoById(Long id) {
        return produtoRepository.findById(id).orElse(null);
    }

    // Update - Atualizar um produto existente
    public ProdutoModel updateProduto(Long id, ProdutoModel produto) {
        ProdutoModel existingProduto = produtoRepository.findById(id).orElse(null);
        if (existingProduto != null) {
            existingProduto.setNome(produto.getNome());
            existingProduto.setDescricao(produto.getDescricao());
            existingProduto.setPreco(produto.getPreco());
            existingProduto.setQuantidade(produto.getQuantidade());
            return produtoRepository.save(existingProduto);
        }
        return null;
    }

    // Delete - Deletar um produto por ID
    public void deleteProdutoById(Long id) {
        produtoRepository.deleteById(id);
    }
}
