package com.diya.microservices.product.dto;

import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import org.apache.logging.log4j.core.config.plugins.validation.constraints.NotBlank;

import java.math.BigDecimal;

public record ProductRequest(String id,
                             @NotNull @NotBlank(message = "Can't be empty name!") String name,
                             @NotNull @NotBlank(message = "Can't be empty description!") String description,
                             @NotNull @NotBlank(message = "Can't be empty price!") BigDecimal price) {
}
