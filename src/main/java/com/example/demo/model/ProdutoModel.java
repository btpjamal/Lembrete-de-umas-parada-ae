package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "produto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome")
    private String nome;
    @Column(name = "descricao")
    private String descricao;
    @Column(name = "preco")
    private Double preco;
    @Column(name = "quantidade")
    private Integer quantidade;

    // Relacionamento ManyToOne com CategoriaModel
    @ManyToOne(fetch = FetchType.EAGER) // carregamento imediato da categoria
    @JoinColumn(name = "categoria_id")
    @JsonBackReference
    private CategoriaModel categoria;

}
