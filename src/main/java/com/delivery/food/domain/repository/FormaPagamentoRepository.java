package com.delivery.food.domain.repository;

import java.util.List;

import com.delivery.food.domain.model.FormaPagamento;

public interface FormaPagamentoRepository {

	List<FormaPagamento> listar();
	FormaPagamento buscar(Long id);
	void salvar(FormaPagamento formaPagamento);
	void remover(FormaPagamento formaPagamento);

}
