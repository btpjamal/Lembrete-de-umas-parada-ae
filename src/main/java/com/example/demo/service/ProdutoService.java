package com.example.demo.service;

import com.example.demo.DTO.Mapper;
import com.example.demo.DTO.ProdutoDTO;
import com.example.demo.model.CategoriaModel;
import com.example.demo.model.ProdutoModel;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final Mapper mapper;



    public ProdutoService(ProdutoRepository produtoRepository, Mapper mapper) {
        this.produtoRepository = produtoRepository;
        this.mapper = mapper;
    }

    // CRUD - Create, Read, Update, Delete

    // Criar novo produto
    public ProdutoDTO criarProduto(ProdutoDTO produtoDTO) {
        ProdutoModel produtoModel = mapper.toProdutoModel(produtoDTO);
        ProdutoModel Salvo = produtoRepository.save(produtoModel);
        return mapper.toProdutoDTO(Salvo);
    }

    // Atualizar produto existente
    public ProdutoDTO atualizarProduto(Long id, ProdutoDTO produtoDTO) {
        ProdutoModel produtoModel = mapper.toProdutoModel(produtoDTO);
        produtoModel.setId(id);
        ProdutoModel atualizado = produtoRepository.save(produtoModel);
        return mapper.toProdutoDTO(atualizado);
    }

    // Listar todos
    public List<ProdutoDTO> listarTodos() {
        return produtoRepository.findAll()
                .stream()
                .map(mapper::toProdutoDTO)
                .collect(Collectors.toList());
    }

    // Buscar por ID
    public Optional<ProdutoDTO> buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .map(mapper::toProdutoDTO);
    }

    // Deletar
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }

    // Buscar produtos por categoria
    public List<ProdutoDTO> buscarPorCategoria(Long categoriaId) {
        return produtoRepository.findByCategoriaId(categoriaId)
                .stream()
                .map(mapper::toProdutoDTO)
                .collect(Collectors.toList());
    }
}
