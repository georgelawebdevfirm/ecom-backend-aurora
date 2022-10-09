package com.maxecommerce.ecom.action;

import lombok.AllArgsConstructor;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;

@AllArgsConstructor
public enum ActionEventConfig {

  // @ActionEvent(value = "create-product")
  PRODUCT_CREATE(Set.of("product/create", "create-product"));

  // @ActionEvent(value = "list-products")
  // @ActionEvent(value = "page-products")
  // @ActionEvent(value = "delete-product")
  // @ActionEvent(value = "get-product")
  // @ActionEvent(value = "find-product")

  final Set<String> events;

  public static Optional<ActionEventConfig> getActionEventConfig(final String actionEventType) {
    return Arrays.stream(values()).filter(f -> f.events.contains(actionEventType)).findFirst();
  }
}
