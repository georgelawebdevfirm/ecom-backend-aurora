package com.maxecommerce.ecom.domain.attribute;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

@Setter
@Getter
@lombok.NoArgsConstructor
@Embeddable
public class AttributeItem {

  @Id
  private Integer id;

  @Column(name = "attribute_label")
  private String label;
}
