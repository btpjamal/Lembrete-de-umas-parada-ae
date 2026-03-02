package com.example.demo.service;

import com.example.demo.model.CategoriaModel;
import com.example.demo.model.ProdutoModel;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    // CRUD - Create, Read, Update, Delete

    // Criar novo produto
    public ProdutoModel criarProduto(ProdutoModel produto) {
        return produtoRepository.save(produto);
    }

    // Atualizar produto existente
    public ProdutoModel atualizarProduto(ProdutoModel produto) {
        return produtoRepository.save(produto);
    }

    // Listar todos
    public List<ProdutoModel> listarTodos() {
        return produtoRepository.findAll();
    }

    // Buscar por ID
    public Optional<ProdutoModel> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    // Deletar
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    // Buscar produtos por categoria
    public List<ProdutoModel> buscarPorCategoria(Long categoriaId) {
        return produtoRepository.findByCategoriaId(categoriaId);
    }
}
