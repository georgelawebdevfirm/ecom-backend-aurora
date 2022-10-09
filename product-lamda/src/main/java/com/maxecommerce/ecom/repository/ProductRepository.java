package com.maxecommerce.ecom.repository;

import com.maxecommerce.ecom.domain.product.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface ProductRepository extends CrudRepository<Product, Long> {

  List<Product> findProductsByUuid(UUID uuid);
}
