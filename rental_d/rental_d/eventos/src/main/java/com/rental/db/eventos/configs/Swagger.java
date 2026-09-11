
package com.rental.db.eventos.configs;

import org.springframework.context.annotation.Configuration;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
info = @Info(
title = "Rental Eventos",
version = "1.0",
description = "Gerencie equipamentos, usuários e movimentações de locação em um só lugar."
)
)
public class Swagger {
    
}