package com.delivery.food.domain.repository;

import com.delivery.food.domain.model.Cozinha;

import java.util.List;

public interface CozinhaRepository {

    List<Cozinha> listar();
    Cozinha buscar(Long id);
    void salvar(Cozinha cozinha);
    void remover(Long id);

}
