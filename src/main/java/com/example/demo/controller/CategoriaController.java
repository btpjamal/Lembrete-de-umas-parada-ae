package com.example.demo.controller;

import com.example.demo.model.CategoriaModel;
import com.example.demo.model.ProdutoModel;
import com.example.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    // Endpoint para criar uma nova categoria
    @PostMapping("/create")
    public CategoriaModel createCategoria(@RequestBody CategoriaModel categoria) {
         return categoriaService.createCategoria(categoria);
    }

    // Endpoint para obter todas as categorias
    @GetMapping("/readAll")
    public List<CategoriaModel> getAllCategorias() {
        return categoriaService.getAllCategorias();
    }

    // Endpoint para obter uma categoria por ID
    @GetMapping("/read/{id}")
    public CategoriaModel getCategoriaById(@PathVariable Long id) {
        return categoriaService.getCategoriaById(id);
    }

    // Endpoint para atualizar uma categoria existente
    @PutMapping("/update/{id}")
    public CategoriaModel updateCategoria(@PathVariable Long id, @RequestBody CategoriaModel categoria) {
        return categoriaService.updateCategoria(id, categoria);
    }

    // Endpoint para deletar uma categoria por ID
    @DeleteMapping("/delete/{id}")
    public void deleteCategoriaById(@PathVariable Long id) {
        categoriaService.deleteCategoriaById(id);
    }

    // Endpoint para obter produtos por categoria
    @GetMapping("/{id}/produtos")
    public List<ProdutoModel> getProdutosByCategoriaId(@PathVariable Long id) {
        return categoriaService.getProdutosByCategoriaId(id);
    }
}
