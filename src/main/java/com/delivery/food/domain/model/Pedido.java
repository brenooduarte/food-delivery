package com.delivery.food.domain.model;

import com.delivery.food.domain.enums.StatusPedido;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Pedido {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "subtotal", nullable = false)
    private BigDecimal subtotal;

    @Column(name = "taxa_frete", nullable = false)
    private BigDecimal taxaFrete;

    @Column(name = "valor_total", nullable = false)
    private BigDecimal valorTotal;
    @Column(name = "data_criacao", nullable = false)
    private Date dataCriacao;

    @Column(name = "data_confirmacao")
    private Date dataConfirmacao;

    @Column(name = "data_cancelamento")
    private Date dataCancelamento;

    @Column(name = "data_entrega")
    private Date dataEntrega;

    @ManyToOne
    @JoinColumn(name = "forma_pagamento_id", nullable = false)
    private FormaPagamento formaPagamento;

    @ManyToOne
    @JoinColumn(name = "restaurante_id", nullable = false)
    private Restaurante restaurante;

    @ManyToOne
    @JoinColumn(name = "usuario_cliente_id", nullable = false)
    private Usuario cliente;

    @Embedded
    @Column(name = "endereco_entrega")
    private Endereco enderecoEntrega;

    @Enumerated
    @Column(name = "status_pedido", nullable = false)
    private StatusPedido statusPedido;

    @OneToMany(mappedBy = "pedido")
    private List<ItemPedido> itens = new ArrayList<>();

    public Pedido (Date dataCriacao, StatusPedido status) {
        this.dataCriacao = dataCriacao;
        this.statusPedido = status;
    }

}
