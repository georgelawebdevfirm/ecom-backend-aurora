package com.maxecommerce.ecom.domain.dimension;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Setter
@Getter
@lombok.NoArgsConstructor
@Embeddable
public class Dimension {

  @Column(name = "dimension_length")
  private Float length;

  @Column(name = "dimension_width")
  private Float width;

  @Column(name = "dimension_height")
  private Float height;

  @Column(name = "dimension_weight")
  private Float weight = 100F; // Default value

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
