package com.example.demo.repository;

import com.example.demo.model.CategoriaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaModel, Long> {
        @Query("SELECT c FROM CategoriaModel c JOIN FETCH c.produtos WHERE c.id = :id")
        Optional<CategoriaModel> findByIdWithProdutos(@Param("id") Long id);
}
