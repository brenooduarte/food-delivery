package com.delivery.food.domain.repository;

import com.delivery.food.domain.model.Produto;
import com.delivery.food.infrastructure.repository.ProdutoRepositoryQueries;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface ProdutoRepository extends JpaRepository<Produto, Long>, ProdutoRepositoryQueries,
        JpaSpecificationExecutor<Produto> {

}
