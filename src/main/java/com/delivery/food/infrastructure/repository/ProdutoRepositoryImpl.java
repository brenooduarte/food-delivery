package com.delivery.food.infrastructure.repository;

import com.delivery.food.domain.model.Produto;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public class ProdutoRepositoryImpl implements ProdutoRepositoryQueries {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Produto> comFaixaDePrecoEntre(BigDecimal precoMinimo, BigDecimal precoMaximo) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Produto> query = builder.createQuery(Produto.class);
        System.out.println(query.toString());

        Root<Produto> root = query.from(Produto.class);
        System.out.println(root.toString());

        query.select(root).where(builder.between(root.get("preco"), precoMinimo, precoMaximo));

        return entityManager.createQuery(query).getResultList();
    }



}
