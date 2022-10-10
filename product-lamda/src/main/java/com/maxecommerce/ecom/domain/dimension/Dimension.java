package com.maxecommerce.ecom.domain.dimension;

import com.maxecommerce.ecom.domain.uom.UnitOfMeasure;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
  @ManyToOne
  @JoinColumn(name = "weight_unit_id", nullable = false)
  private UnitOfMeasure weightUnit;

  @ManyToOne
  @JoinColumn(name = "length_unit_id", nullable = false)
  private UnitOfMeasure lengthUnit;

  @ManyToOne
  @JoinColumn(name = "width_unit_id", nullable = false)
  private UnitOfMeasure widthUnit;

  @ManyToOne
  @JoinColumn(name = "height_unit_id", nullable = false)
  private UnitOfMeasure heightUnit;
}
