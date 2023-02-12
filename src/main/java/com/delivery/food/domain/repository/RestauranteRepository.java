package com.delivery.food.domain.repository;

import com.delivery.food.domain.model.Restaurante;

import java.util.List;

public interface RestauranteRepository {

    List<Restaurante> listar();
    Restaurante buscar(Long id);
    void salvar(Restaurante restaurante);
    void remover(Restaurante restaurante);

}
