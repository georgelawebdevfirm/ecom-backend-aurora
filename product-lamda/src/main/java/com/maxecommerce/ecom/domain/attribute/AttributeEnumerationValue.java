package com.maxecommerce.ecom.domain.attribute;

import com.maxecommerce.ecom.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@Getter
@lombok.NoArgsConstructor
@Embeddable
public class AttributeEnumerationValue extends BaseEntity<Long> {
  @ManyToOne
  @JoinColumn(name = "attribute_id", nullable = false)
  private Attribute attribute;

  private String name;
}
