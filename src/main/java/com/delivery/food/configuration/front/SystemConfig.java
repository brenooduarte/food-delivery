package com.delivery.food.configuration.front;

import com.delivery.food.domain.model.Pedido;
import com.delivery.food.domain.model.enums.StatusPedido;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Date;

@Configuration
public class SystemConfig {

    @Bean
    public Pedido init () {
        return new Pedido(new Date(), StatusPedido.CRIADO);
    }


}
