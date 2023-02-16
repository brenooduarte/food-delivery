package com.delivery.food.api.controller;

import com.delivery.food.domain.model.Restaurante;
import com.delivery.food.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.delivery.food.infrastructure.spec.RestauranteSpecs.*;

@RestController
@RequestMapping("/testes")
public class TesteController {

    @Autowired
    private RestauranteRepository repository;

    @GetMapping("/restaurantes/por-nome-e-frete")
    public List<Restaurante> buscaPorNomeEFrete(
            @RequestParam String nome, @RequestParam BigDecimal taxaFreteInicial, @RequestParam BigDecimal taxaFreteFinal) {

        return repository.listarRestaurantesPorNomeFrete(nome, taxaFreteInicial, taxaFreteFinal);
    }

    @GetMapping("/restaurantes/com-frete-gratis")
    public List<Restaurante> buscaRestaurantesComFreteGratis(String nome) {
        return repository.findAll(comFreteGratis().and(comNomeSemelhante(nome)));
    }

    @GetMapping("/restaurantes/primeiro")
    public Optional<Restaurante> buscaPrimeiroRestaurante() {
        return repository.buscarPrimeiro();
    }

}
