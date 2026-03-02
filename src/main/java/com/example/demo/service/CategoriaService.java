package com.example.demo.service;

import com.example.demo.DTO.CategoriaDTO;
import com.example.demo.DTO.Mapper;
import com.example.demo.model.CategoriaModel;
import com.example.demo.model.ProdutoModel;
import com.example.demo.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final Mapper mapper;



    public CategoriaService(CategoriaRepository categoriaRepository, Mapper mapper) {
        this.categoriaRepository = categoriaRepository;
        this.mapper = mapper;
    }

    // CRUD - Create, Read, Update, Delete

    // Criar nova categoria
    public CategoriaDTO criarCategoria(CategoriaDTO categoriaDTO) {
        CategoriaModel categoriaModel = mapper.toCategoriaModel(categoriaDTO);
        CategoriaModel salva = categoriaRepository.save(categoriaModel);
        return mapper.toCategoriaDTO(salva);
    }

    // Atualizar categoria existente
    public CategoriaDTO atualizarCategoria(Long id, CategoriaDTO categoriaDTO) {
        CategoriaModel categoriaModel = mapper.toCategoriaModel(categoriaDTO);
        categoriaModel.setId(id);
        CategoriaModel atualizada = categoriaRepository.save(categoriaModel);
        return mapper.toCategoriaDTO(atualizada);
    }

    // Listar todas as categorias
    public List<CategoriaDTO> listarTodas() {
        return categoriaRepository.findAll()
                .stream()
                .map(mapper::toCategoriaDTO)
                .collect(Collectors.toList());
    }

    // Buscar categoria por ID
    public Optional<CategoriaDTO> buscarPorId(Long id) {
        return categoriaRepository.findById(id)
                .map(mapper::toCategoriaDTO);
    }

    // Buscar categoria com produtos associados
    public Optional<CategoriaDTO> buscarPorIdComProdutos(Long id) {
        return categoriaRepository.findByIdWithProdutos(id)
                .map(mapper::toCategoriaDTO);
    }

    // Deletar categoria
    public void deletar(Long id) {
        categoriaRepository.deleteById(id);
    }
}
