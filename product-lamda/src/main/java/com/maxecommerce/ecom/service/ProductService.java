package com.maxecommerce.ecom.service;

import com.maxecommerce.ecom.domain.product.Product;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ProductService {
    Product create(Product entity);
    Product update(Product entity);
    void delete(Long id);
    Optional<Product> findById(Long id);
    Optional<Product> findByUuid(UUID uuid);
    List<Product> page();

}
