package com.example.demo.repository;

import com.example.demo.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<ProdutoModel, Long> {
    // busca todos os produtos de uma categoria pelo ID
    List<ProdutoModel> findByCategoriaId(Long categoriaId);
}
