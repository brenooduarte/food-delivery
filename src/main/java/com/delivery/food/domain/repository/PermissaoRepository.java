package com.delivery.food.domain.repository;

import com.delivery.food.domain.model.Permissao;

import java.util.List;

public interface PermissaoRepository {

    List<Permissao> listar();
    Permissao buscar(Long id);
    void salvar(Permissao permissao);
    void remover(Permissao permissao);

}
