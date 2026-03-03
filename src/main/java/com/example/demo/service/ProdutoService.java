package com.example.demo.service;

import com.example.demo.DTO.Mapper;
import com.example.demo.DTO.ProdutoDTO;
import com.example.demo.model.CategoriaModel;
import com.example.demo.model.ProdutoModel;
import com.example.demo.repository.CategoriaRepository;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final CategoriaRepository categoriaRepository;
    private final Mapper mapper;



    public ProdutoService(ProdutoRepository produtoRepository, CategoriaRepository categoriaRepository, Mapper mapper) {
        this.produtoRepository = produtoRepository;
        this.categoriaRepository = categoriaRepository;
        this.mapper = mapper;
    }

    // CRUD - Create, Read, Update, Delete

    public ProdutoDTO criarProduto(ProdutoDTO produtoDTO) {
        ProdutoModel produtoModel = mapper.toProdutoModel(produtoDTO);

        // Se veio categoriaId, buscar a categoria e associar
        if (produtoDTO.getCategoriaId() != null) {
            CategoriaModel categoria = categoriaRepository.findById(produtoDTO.getCategoriaId())
                    .orElseThrow(() -> new RuntimeException("Categoria não encontrada"));
            produtoModel.setCategoria(categoria);
        }

        ProdutoModel salvo = produtoRepository.save(produtoModel);
        return mapper.toProdutoDTO(salvo);
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
