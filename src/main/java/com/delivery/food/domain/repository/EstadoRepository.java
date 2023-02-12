package com.delivery.food.domain.repository;

import com.delivery.food.domain.model.Estado;

import java.util.List;

public interface EstadoRepository {

    List<Estado> listar();
    Estado buscar(Long id);
    void salvar(Estado estado);
    void remover(Long id);

}
