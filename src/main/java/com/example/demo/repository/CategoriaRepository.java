package com.example.demo.repository;

import com.example.demo.model.CategoriaModel;
import com.example.demo.model.ProdutoModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
}
