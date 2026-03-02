package com.example.demo.DTO;

import com.example.demo.model.CategoriaModel;
import com.example.demo.model.ProdutoModel;


@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {

    ProdutoDTO toProdutoDTO(ProdutoModel produtoModel);

    ProdutoModel toProdutoModel(ProdutoDTO produtoDTO);

    CategoriaDTO toCategoriaDTO(CategoriaModel categoriaModel);

    CategoriaModel toCategoriaModel(CategoriaDTO categoriaDTO);
}
