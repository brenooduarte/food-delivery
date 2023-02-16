package com.delivery.food.domain.service;

import com.delivery.food.domain.exception.EntidadeEmUsoException;
import com.delivery.food.domain.exception.EntidadeNaoEncontradaException;
import com.delivery.food.domain.model.Cozinha;
import com.delivery.food.domain.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroCozinhaService {

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public void salvar(Cozinha cozinha) {
        cozinhaRepository.save(cozinha);
    }

    public void excluir(Long cozinhaId) {
        try {
            Optional<Cozinha> cozinha = cozinhaRepository.findById(cozinhaId);
            cozinha.ifPresent(value -> cozinhaRepository.delete(cozinha.get()));

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de cozinha com código %d", cozinhaId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Cozinha de código %d não pode ser removida, pois está em uso", cozinhaId));
        }
    }

}
