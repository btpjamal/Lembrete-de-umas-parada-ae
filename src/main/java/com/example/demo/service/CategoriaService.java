package com.example.demo.service;

import com.example.demo.model.CategoriaModel;
import com.example.demo.model.ProdutoModel;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // CRUD - Create, Read, Update, Delete

    // Criar nova categoria
    public CategoriaModel criarCategoria(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }

    // Atualizar categoria existente
    public CategoriaModel atualizarCategoria(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }

    // Listar todas
    public List<CategoriaModel> listarTodas() {
        return categoriaRepository.findAll();
    }

    // Buscar por ID
    public Optional<CategoriaModel> buscarPorId(Long id) {
        return categoriaRepository.findById(id);
    }

    // Buscar categoria com produtos
    public Optional<CategoriaModel> buscarPorIdComProdutos(Long id) {
        return categoriaRepository.findByIdWithProdutos(id);
    }

    // Deletar
    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }
}
