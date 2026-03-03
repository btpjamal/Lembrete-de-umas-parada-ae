package com.example.demo.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoriaDTO {

    private Long id;
    private String nome;
    private List<ProdutoDTO> produtos = new ArrayList<>();
}
