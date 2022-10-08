package com.maxecommerce.ecom.domain.option;

import com.maxecommerce.ecom.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "option_group")
public class OptionGroup extends BaseEntity<UUID> {
  private String name;
  private String label;
  private Boolean required;
  private Integer sort;
  private String defaultOption;
  private String storeId;
}
