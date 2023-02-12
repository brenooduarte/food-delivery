package com.delivery.food.domain.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Cozinha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nome;

	public Cozinha() {
	}

	public Cozinha(String nome) {
		this.nome = nome;
	}
    
}
