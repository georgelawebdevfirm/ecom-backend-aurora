package com.maxecommerce.ecom.repository;

import com.maxecommerce.ecom.domain.product.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {}
