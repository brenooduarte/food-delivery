package com.delivery.food.domain.service;

import com.delivery.food.domain.exception.EntidadeEmUsoException;
import com.delivery.food.domain.exception.EntidadeNaoEncontradaException;
import com.delivery.food.domain.model.Cidade;
import com.delivery.food.domain.model.Estado;
import com.delivery.food.domain.repository.CidadeRepository;
import com.delivery.food.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CadastroCidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    public void salvar(Cidade cidade) {
        Long estadoId = cidade.getEstado().getId();
        Optional<Estado> estado = estadoRepository.findById(estadoId);

        if (estado.isEmpty()) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe cadastro de estado com código %d", estadoId));
        }

        cidade.setEstado(estado.get());

        cidadeRepository.save(cidade);
    }

    public void excluir(Long cidadeId) {
        try {
            Optional<Cidade> cidade = cidadeRepository.findById(cidadeId);
            cidade.ifPresent(value -> cidadeRepository.delete(value));

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de cidade com código %d", cidadeId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Cidade de código %d não pode ser removida, pois está em uso", cidadeId));
        }
    }

}
