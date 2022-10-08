package com.maxecommerce.ecom.domain.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.maxecommerce.ecom.domain.attribute.ProductAttributeValue;
import com.maxecommerce.ecom.domain.BaseEntity;
import com.maxecommerce.ecom.domain.category.Category;
import com.maxecommerce.ecom.domain.dimension.Dimension;
import com.maxecommerce.ecom.domain.option.OptionGroup;
import com.maxecommerce.ecom.domain.seo.SeoAttributes;
import com.maxecommerce.ecom.domain.size.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.maxecommerce.ecom.domain.JpaTypeConstants.MAX_URL_LENGTH;

@Setter
@Getter
@Accessors(chain = true)
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity @Table(name = "product", indexes = @Index(columnList = "storeId"))
public class Product extends BaseEntity<Long> {

  private String name;

  private String sku;

  private Boolean showSku;

  private String manufacturerId;

  @Enumerated(EnumType.STRING)
  @Column(columnDefinition = ProductIdType.COLUMN_DEFINITION)
  private ProductIdType manufacturerIdType;

  @ManyToMany(mappedBy = "products")
  private List<Category> categories;

  private Integer sortIndex;

  @Embedded
  private Dimension dimension;

  @Transient
  private Size size;

  @Column(precision=12, scale=2)
  private BigDecimal cost;

  @Column(precision=12, scale=2)
  private BigDecimal retailPrice;

  @Column(precision=12, scale=2)
  private BigDecimal salePrice;

  private Boolean showRetailPrice;

  private Boolean showSalePrice;

  private Boolean newProduct;

  private Integer newProductSortIndex;

  private Boolean bestSeller;

  private Integer bestSellerSortIndex;

  private Boolean featured;

  private Boolean inStock;

  private Integer inventory;

  private Integer specialSortIndex;

  private Boolean preOrder;

  private LocalDateTime availabilityDate;

  private Boolean clearance;

  @Column(columnDefinition = "text")
  private String description;

  @Column(columnDefinition = "text")
  private String shortDescription;

  @Column(columnDefinition = "text")
  private String descriptionSpanish;

  @Column(length = 160)
  private String inventoryDescription;

  @Column(length = 160)
  private String inventoryLocation;

  @Column(length = MAX_URL_LENGTH)
  private String productVideo;

  @Column(length = MAX_URL_LENGTH)
  private String largeImage;

  @Column(length = MAX_URL_LENGTH)
  private String smallImage;

  @Column(length = MAX_URL_LENGTH)
  private String thumbnail;

  @ElementCollection
  @Column(length = MAX_URL_LENGTH)
  @CollectionTable(name = "product_image_url", joinColumns = @JoinColumn(name = "product_id"))
  private List<String> productsImagesUrl;

  private Boolean taxClass;

  // SEO
  @Embedded
  private SeoAttributes seoAttributes;

  private Boolean status;

  private String storeId;

  private Boolean isComplexVariant;

  private String parentId;

  @OneToMany(mappedBy = "product")
  private List<ProductAttributeValue> attributes;

  @ManyToMany
  @JoinTable(name="product_option_group",
          joinColumns=
          @JoinColumn(name="product_id", referencedColumnName="id"),
          inverseJoinColumns=
          @JoinColumn(name="option_group_id", referencedColumnName="id")
  )
  private Set<OptionGroup> optionGroups = new HashSet<>();

  private Integer qty;

  private Boolean isImported;

  @Override
  public boolean equals(Object obj) {
    if (obj == null || (obj.getClass() != this.getClass())) {
      return false;
    }

    Product ad = (Product) obj;
    return ad.getId().equals(this.getId());
  }

  @Override
  public int hashCode() {
    return getId().hashCode();
  }
}
