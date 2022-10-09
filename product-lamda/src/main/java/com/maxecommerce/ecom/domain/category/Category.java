package com.maxecommerce.ecom.domain.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.maxecommerce.ecom.domain.BaseEntity;
import com.maxecommerce.ecom.domain.product.Product;
import com.maxecommerce.ecom.domain.seo.SeoAttributes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(
    name = "category",
    indexes = {
      @Index(name = "idx_category_uuid", columnList = "uuid"),
      @Index(name = "idx_category_store_id", columnList = "storeId")
    })
public class Category extends BaseEntity<Long> {

  private String label;
  private String content;

  @ManyToOne
  @JoinColumn(name = "parent_id")
  private Category parent;

  @Embedded private SeoAttributes seo;

  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(
      name = "category_product",
      joinColumns = @JoinColumn(name = "category_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id"))
  private List<Product> products;
}
