package com.example.demo.DTO;

import com.example.demo.model.CategoriaModel;
import com.example.demo.model.ProdutoModel;
import org.mapstruct.Mapping;


@org.mapstruct.Mapper(componentModel = "spring")
public interface Mapper {

    @Mapping(source = "categoria.id", target = "categoriaId")
    ProdutoDTO toProdutoDTO(ProdutoModel produtoModel);

    @Mapping(target = "categoria", ignore = true)
    ProdutoModel toProdutoModel(ProdutoDTO produtoDTO);

    CategoriaDTO toCategoriaDTO(CategoriaModel categoriaModel);

    @Mapping(target = "produtos", ignore = true)
    CategoriaModel toCategoriaModel(CategoriaDTO categoriaDTO);
}
