package com.delivery.food.domain.repository;

import com.delivery.food.domain.model.Cidade;

import java.util.List;

public interface CidadeRepository {

    List<Cidade> listar();
    Cidade buscar(Long id);
    void salvar(Cidade cidade);
    void remover(Long id);

}
