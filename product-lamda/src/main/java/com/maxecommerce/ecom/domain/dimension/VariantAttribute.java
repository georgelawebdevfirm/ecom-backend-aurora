package com.maxecommerce.ecom.domain.dimension;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.maxecommerce.ecom.domain.attribute.Attribute;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Embeddable
@NoArgsConstructor
public class VariantAttribute {
  @ManyToOne
  @JoinColumn(name = "attribute_id")
  Attribute attribute;

  @Column(name = "attribute_name")
  String name;

  @Column(name = "attribute_value", columnDefinition = "text")
  String value;

  @Override
  public boolean equals(Object obj) {
    return obj instanceof VariantAttribute
        && attribute.getId().equals(((VariantAttribute) obj).getAttribute().getId());
  }
}
