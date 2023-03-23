package com.delivery.food.infrastructure.repository;

import com.delivery.food.domain.model.Produto;

import java.math.BigDecimal;
import java.util.List;

public interface ProdutoRepositoryQueries {

    List<Produto> comFaixaDePrecoEntre(BigDecimal precoMinimo, BigDecimal precoMaximo);

}
