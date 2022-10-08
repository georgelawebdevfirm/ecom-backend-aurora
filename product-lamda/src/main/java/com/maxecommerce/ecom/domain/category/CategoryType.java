package com.maxecommerce.ecom.domain.category;

public enum CategoryType {
  BAR_SOAPS,
  MEDICATED_OINTMENT,
  RIFFI_MASSAGE_PRODUCTS,
  CUTICURA_PRODUCTS,
  PROMOTIONS,
  WOMEN_SALE,
  MEN_SALE,
  PANTS,
  TEES;
  public static final String COLUMN_DEFINITION =
      "ENUM('BAR_SOAPS', 'MEDICATED_OINTMENT', 'RIFFI_MASSAGE_PRODUCTS',"
          + "'CUTICURA_PRODUCTS','PROMOTIONS','WOMEN_SALE','MEN_SALE',"
          + "'PANTS','TEES')";
}
