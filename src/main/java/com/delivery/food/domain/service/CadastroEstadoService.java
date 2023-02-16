package com.delivery.food.domain.service;

import com.delivery.food.domain.exception.EntidadeEmUsoException;
import com.delivery.food.domain.exception.EntidadeNaoEncontradaException;
import com.delivery.food.domain.model.Estado;
import com.delivery.food.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroEstadoService {

    @Autowired
    private EstadoRepository estadoRepository;

    public void salvar(Estado estado) {
        estadoRepository.save(estado);
    }

    public void excluir(Long estadoId) {
        try {
            Optional<Estado> estado = estadoRepository.findById(estadoId);
            estado.ifPresent(value -> estadoRepository.delete(value));

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de estado com código %d", estadoId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Estado de código %d não pode ser removido, pois está em uso", estadoId));
        }
    }

}
