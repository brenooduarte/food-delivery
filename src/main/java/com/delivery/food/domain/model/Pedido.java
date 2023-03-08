package com.delivery.food.domain.model;

import com.delivery.food.domain.model.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Pedido {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private BigDecimal subtotal;

    @Column(nullable = false)
    private BigDecimal taxaFrete;

    @Column(nullable = false)
    private BigDecimal valorTotal;
    @Column(nullable = false)
    private Date dataCriacao;

    private Date dataConfirmacao;

    private Date dataCancelamento;

    private Date dataEntrega;

    @ManyToOne
    @JoinColumn(name = "forma_pagamento_id", nullable = false)
    private FormaPagamento formaPagamento;

    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    private Restaurante restaurante;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario cliente;

    @Embedded
    private Endereco enderecoEntrega;

    @Column(nullable = false)
    private StatusPedido statusPedido;

    public Pedido (Date dataCriacao, StatusPedido status) {
        this.dataCriacao = dataCriacao;
        this.statusPedido = status;
    }

}
