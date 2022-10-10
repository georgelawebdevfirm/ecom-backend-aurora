package com.maxecommerce.ecom.domain.attribute;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.maxecommerce.ecom.domain.product.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "product_attribute_value")
public class ProductAttributeValue {

  @Id @GeneratedValue private Long id;

  @ManyToOne
  @JoinColumn(name = "product_id", nullable = false)
  private Product product;

  @ManyToOne
  @JoinColumn(name = "attribute_id", nullable = false)
  private Attribute attribute;

  @Column(name = "string_val", length = 2048)
  private String stringVal;

  @Column(name = "date_val")
  private LocalDateTime dateVal;

  @Column(name = "long_val")
  private Long longVal;

  @Column(name = "double_val")
  private Double doubleVal;

  @Column(name = "enumeration_value")
  private AttributeEnumerationValue enumerationValue;
}
