package com.maxecommerce.ecom.domain.option;

import com.maxecommerce.ecom.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Setter
@Getter
@Entity
@Table(
    name = "option_group",
    indexes = {
      @Index(name = "idx_option_group_uuid", columnList = "uuid"),
      @Index(name = "idx_option_group_store_id", columnList = "storeId")
    })
public class OptionGroup extends BaseEntity<Long> {
  private String name;
  private String label;
  private Boolean required;
  private Integer sort;

  @ManyToOne
  @JoinColumn(name = "default_option_id")
  private Option defaultOption;
}
