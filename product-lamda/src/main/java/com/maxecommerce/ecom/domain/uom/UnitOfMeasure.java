package com.maxecommerce.ecom.domain.uom;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.maxecommerce.ecom.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Index;
import javax.persistence.Table;

@Setter
@Getter
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(
    name = "unit_of_measure",
    indexes = {
      @Index(name = "idx_unit_of_measure_uuid", columnList = "uuid"),
      @Index(name = "idx_unit_of_measure_store_id", columnList = "storeId")
    })
public class UnitOfMeasure extends BaseEntity<Long> {

  private String name;
  private String internationalAbbreviation;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = MeasurableValueType.COLUMN_DEFINITION)
  private MeasurableValueType measurableValueType;
}
