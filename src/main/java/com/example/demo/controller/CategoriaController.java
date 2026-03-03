package com.example.demo.controller;

import com.example.demo.DTO.CategoriaDTO;
import com.example.demo.service.CategoriaService;
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
    public ResponseEntity<CategoriaDTO> criarCategoria(@RequestBody CategoriaDTO categoria) {
        CategoriaDTO novaCategoria = categoriaService.criarCategoria(categoria);
        return ResponseEntity.status(HttpStatus.CREATED).body(novaCategoria);
    }

    // Listar todas as categorias
    @GetMapping("/readAll")
    public List<CategoriaDTO> listarTodas() {
        return categoriaService.listarTodas();
    }

    // Buscar categoria por ID
    @GetMapping("/read/{id}")
    public ResponseEntity<CategoriaDTO> buscarPorId(@PathVariable Long id) {
        return categoriaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Buscar categoria com produtos associados
    @GetMapping("/read/{id}/produtos")
    public ResponseEntity<CategoriaDTO> buscarPorIdComProdutos(@PathVariable Long id) {
        return categoriaService.buscarPorIdComProdutos(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Atualizar categoria existente
    @PutMapping("/update/{id}")
    public ResponseEntity<CategoriaDTO> atualizarCategoria(@PathVariable Long id, @RequestBody CategoriaDTO categoria) {
        categoria.setId(id);
        CategoriaDTO atualizada = categoriaService.atualizarCategoria(id,categoria);
        return ResponseEntity.ok(atualizada);
    }

    // Deletar categoria
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
        return ResponseEntity.noContent().build();
    }

}
