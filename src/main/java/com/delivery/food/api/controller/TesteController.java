package com.delivery.food.api.controller;

import com.delivery.food.domain.model.Produto;
import com.delivery.food.domain.model.Restaurante;
import com.delivery.food.domain.repository.ProdutoRepository;
import com.delivery.food.domain.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static com.delivery.food.infrastructure.spec.ProdutoSpecs.comFaixaDePrecoEntre;
import static com.delivery.food.infrastructure.spec.RestauranteSpecs.comFreteGratis;
import static com.delivery.food.infrastructure.spec.RestauranteSpecs.comNomeSemelhante;

@RestController
@RequestMapping("/testes")
public class TesteController {

    @Autowired
    private RestauranteRepository repository;

    @Autowired
    private ProdutoRepository produtoRepository;

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

    @GetMapping("/produtos")
    public List<Produto> buscaProdutosNaFaixaDePreco (
            @RequestParam BigDecimal precoMinimo, @RequestParam BigDecimal precoMaximo) {

        return produtoRepository.findAll(comFaixaDePrecoEntre(precoMinimo, precoMaximo));
    }

    @PostMapping("/produtos")
    public Produto adicionar (@RequestBody Produto produto) {
        return produtoRepository.save(produto);
    }

}