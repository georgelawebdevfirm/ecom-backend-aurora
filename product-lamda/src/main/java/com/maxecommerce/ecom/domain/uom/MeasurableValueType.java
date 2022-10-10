package com.maxecommerce.ecom.domain.uom;

public enum MeasurableValueType {
  WEIGHT,
  VOLUME,
  AREA,
  LENGTH,
  NUMBER_OF_PIECES; // CAPACITY, ENERGY, ELECTRIC_CHARGE, TIME
  public static final String COLUMN_DEFINITION =
      "ENUM('WEIGHT', 'VOLUME', 'AREA', 'LENGTH', 'NUMBER_OF_PIECES')";
}
