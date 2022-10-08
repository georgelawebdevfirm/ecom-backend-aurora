package com.maxecommerce.ecom.service;

import com.maxecommerce.ecom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.transaction.Transactional;

@RequiredArgsConstructor
@ApplicationScoped
public class ProductService {

    final ProductRepository productRepository;

    @Transactional
    public long count() {
        return productRepository.count();
    }

}
