package com.delivery.food.infrastructure.spec;

import com.delivery.food.domain.model.Produto;
import org.springframework.data.jpa.domain.Specification;

import java.math.BigDecimal;

public class ProdutoSpecs {

    public static Specification<Produto> comFaixaDePrecoEntre(
            BigDecimal precoMinimo, BigDecimal precoMaximo) {

        return (root, query, builder) ->
                builder.between(root.get("preco"), precoMinimo, precoMaximo);

    }

}