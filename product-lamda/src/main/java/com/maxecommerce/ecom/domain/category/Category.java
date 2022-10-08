package com.maxecommerce.ecom.domain.category;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.maxecommerce.ecom.domain.BaseEntity;
import com.maxecommerce.ecom.domain.product.Product;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity @Table(name = "category")
public class Category extends BaseEntity<UUID> {

  private String label;
  private String content;
  private String parentId;
  private String url;
  private String title;
  private String metaKeywords;
  private String metaDescription;
  private String canonical;

  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(
          name = "category_product",
          joinColumns = @JoinColumn(name = "category_id"),
          inverseJoinColumns = @JoinColumn(name = "product_id")
  )
  private List<Product> products;

}
