package com.maxecommerce.ecom.domain.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.maxecommerce.ecom.domain.BaseEntity;
import com.maxecommerce.ecom.domain.product.Product;
import com.maxecommerce.ecom.domain.seo.SeoAttributes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.List;

import static com.maxecommerce.ecom.domain.JpaTypeConstants.MAX_URL_LENGTH;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
@Table(name = "category")
public class Category extends BaseEntity<Long> {

  private String label;
  private String content;

  @ManyToOne
  @JoinColumn(name = "parent_id")
  private Category parent;

  @Column(length = MAX_URL_LENGTH)
  private String url;

  @Embedded private SeoAttributes seo;

  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(
      name = "category_product",
      joinColumns = @JoinColumn(name = "category_id"),
      inverseJoinColumns = @JoinColumn(name = "product_id"))
  private List<Product> products;
}
