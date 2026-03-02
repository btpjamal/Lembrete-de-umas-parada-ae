package com.example.demo.DTO;

import com.example.demo.model.ProdutoModel;
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
    private List<ProdutoModel> produtos = new ArrayList<>();
}
