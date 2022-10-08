package com.maxecommerce.ecom.domain.dimension;

public enum WeightUnitType {
  LB, KG, OZ;
  public static final String COLUMN_DEFINITION = "ENUM('LB', 'KG', 'OZ')";
}
