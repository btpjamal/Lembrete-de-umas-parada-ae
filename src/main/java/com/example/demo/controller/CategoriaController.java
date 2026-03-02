package com.example.demo.controller;

import com.example.demo.model.CategoriaModel;
import com.example.demo.model.ProdutoModel;
import com.example.demo.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    private final CategoriaService categoriaService;


    public CategoriaController(CategoriaService categoriaService) {
        this.categoriaService = categoriaService;
    }

    // Criar nova categoria
    @PostMapping("/create")
    public ResponseEntity<CategoriaModel> criarCategoria(@RequestBody CategoriaModel categoria) {
        CategoriaModel novaCategoria = categoriaService.criarCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
    }

    // Listar todas as categorias
    @GetMapping("/readAll")
    public List<CategoriaModel> listarTodas() {
        return categoriaService.listarTodas();
    }

    // Buscar categoria por ID
    @GetMapping("/read/{id}")
    public ResponseEntity<CategoriaModel> buscarPorId(@PathVariable Long id) {
        return categoriaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Buscar categoria com produtos associados
    @GetMapping("/read/{id}/produtos")
    public ResponseEntity<CategoriaModel> buscarPorIdComProdutos(@PathVariable Long id) {
        return categoriaService.buscarPorIdComProdutos(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar categoria existente
    @PutMapping("/update/{id}")
    public ResponseEntity<CategoriaModel> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaModel categoria) {
        categoria.setId(id);
        CategoriaModel atualizada = categoriaService.atualizarCategoria(categoria);
        return ResponseEntity.ok(atualizada);
    }

    // Deletar categoria
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
