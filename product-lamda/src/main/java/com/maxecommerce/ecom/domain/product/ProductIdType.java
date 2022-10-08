package com.maxecommerce.ecom.domain.product;

public enum ProductIdType {
  UPC,
  GTIN,
  ISBN,
  EAN;
  public static final String COLUMN_DEFINITION = "ENUM('UPC', 'GTIN', 'ISBN', 'EAN')";
}
