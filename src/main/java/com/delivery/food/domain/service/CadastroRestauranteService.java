package com.delivery.food.domain.service;

import com.delivery.food.domain.exception.EntidadeNaoEncontradaException;
import com.delivery.food.domain.model.Cozinha;
import com.delivery.food.domain.model.Restaurante;
import com.delivery.food.domain.repository.CozinhaRepository;
import com.delivery.food.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public void salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();
        Optional<Cozinha> cozinha = cozinhaRepository.findById(cozinhaId);

        if (cozinha.isEmpty()) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cadastro de cozinha com código %d", cozinhaId));
        }

        restaurante.setCozinha(cozinha.get());

        restauranteRepository.save(restaurante);
    }

}
