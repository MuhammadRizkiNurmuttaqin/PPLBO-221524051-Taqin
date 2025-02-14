package com.techie.microservices.product.dto;

import java.math.BigDecimal;

public record ProductRequest(String name, String id, BigDecimal price, String description) {

}
