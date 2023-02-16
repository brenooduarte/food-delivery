package com.delivery.food.domain.repository;

import com.delivery.food.domain.model.Restaurante;
import com.delivery.food.infrastructure.repository.RestauranteRepositoryQueries;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface RestauranteRepository
        extends CustomJpaRepository<Restaurante, Long>, RestauranteRepositoryQueries,
        JpaSpecificationExecutor<Restaurante> {

}
