package com.maxecommerce.ecom.service;

import com.maxecommerce.ecom.domain.product.Product;
import com.maxecommerce.ecom.repository.ProductRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

@RequiredArgsConstructor
@ApplicationScoped
public class ProductServiceImpl implements ProductService {

  final ProductRepository productRepository;

  @Override
  public Product create(Product entity) {
    return productRepository.save(entity);
  }

  @Override
  public Product update(Product entity) {
    if (entity != null && entity.hasId()) throw new NoSuchElementException();
    return productRepository.save(entity);
  }

  @Override
  public void delete(Long id) {
    productRepository.deleteById(id);
  }

  @Override
  public Optional<Product> findById(Long id) {
    return productRepository.findById(id);
  }

  @Override
  public Optional<Product> findByUuid(UUID uuid) {
    return productRepository.findProductsByUuid(uuid).stream().findFirst();
  }

  @Override
  public List<Product> page() {
    return null;
  }
}
