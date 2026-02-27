package com.example.demo.service;

import com.example.demo.model.CategoriaModel;
import com.example.demo.model.ProdutoModel;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    // CRUD - Create, Read, Update, Delete

    // Create - Criar uma nova categoria
    public CategoriaModel createCategoria(CategoriaModel categoria) {
        return categoriaRepository.save(categoria);
    }

    // Read - Ler todas as categorias ou uma categoria específica
    public List<CategoriaModel> getAllCategorias() {
        return categoriaRepository.findAll();
    }

    public CategoriaModel getCategoriaById(Long id) {
        return categoriaRepository.findById(id).orElse(null);
    }

    // Update - Atualizar uma categoria existente
    public CategoriaModel updateCategoria(Long id, CategoriaModel categoria) {
        CategoriaModel existingCategoria = categoriaRepository.findById(id).orElse(null);
        if (existingCategoria != null) {
            existingCategoria.setNome(categoria.getNome());
            existingCategoria.setProdutos(categoria.getProdutos());
            return categoriaRepository.save(existingCategoria);
        }
        return null;
    }

    // Delete - Deletar uma categoria por ID
    public void deleteCategoriaById(Long id) {
        categoriaRepository.deleteById(id);
    }

    // Método para obter produtos por categoria
    public List<ProdutoModel> getProdutosByCategoriaId(Long id) {
        CategoriaModel categoria = categoriaRepository.findById(id).orElse(null);
        if (categoria != null) {
            return categoria.getProdutos();
        }
        return null;
    }
}
