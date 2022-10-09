package com.maxecommerce.ecom.domain.dimension;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Setter
@Getter
@lombok.NoArgsConstructor
@Embeddable
public class Dimension {

  public static final BigDecimal DEFAULT_WEIGHT_VALUE = BigDecimal.valueOf(100);

  @Column(name = "dimension_length", precision = 15, scale = 6)
  private BigDecimal length;

  @Column(name = "dimension_width", precision = 15, scale = 6)
  private BigDecimal width;

  @Column(name = "dimension_height", precision = 15, scale = 6)
  private BigDecimal height;

  @Column(name = "dimension_weight", precision = 15, scale = 6)
  private BigDecimal weight = DEFAULT_WEIGHT_VALUE;

  // Unit
  @Enumerated(EnumType.STRING)
  @Column(name = "dimension_weight_unit", columnDefinition = WeightUnitType.COLUMN_DEFINITION)
  private WeightUnitType weightUnit;

  @Enumerated(EnumType.STRING)
  @Column(name = "dimension_length_unit", columnDefinition = DimensionUnitType.COLUMN_DEFINITION)
  private DimensionUnitType lengthUnit;

  @Enumerated(EnumType.STRING)
  @Column(name = "dimension_width_unit", columnDefinition = DimensionUnitType.COLUMN_DEFINITION)
  private DimensionUnitType widthUnit;

  @Enumerated(EnumType.STRING)
  @Column(name = "dimension_height_unit", columnDefinition = DimensionUnitType.COLUMN_DEFINITION)
  private DimensionUnitType heightUnit;
}
