package com.maxecommerce.ecom.domain.option;

import com.maxecommerce.ecom.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Set;

@Setter
@Getter
@Entity
@Table(
    name = "option",
    indexes = {
      @Index(name = "idx_option_uuid", columnList = "uuid"),
      @Index(name = "idx_option_store_id", columnList = "storeId")
    })
public class Option extends BaseEntity<Long> {

  private String sku;
  private String name;
  private String shortDescription;

  @Column(precision = 12, scale = 2)
  private BigDecimal price;

  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(
      name = "option_group_link",
      joinColumns = @JoinColumn(name = "option_id"),
      inverseJoinColumns = @JoinColumn(name = "option_group_id"))
  private Set<OptionGroup> optionGroups;

  private Boolean status;
}
