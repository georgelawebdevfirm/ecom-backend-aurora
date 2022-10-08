package com.maxecommerce.ecom.domain.option;

import com.maxecommerce.ecom.domain.BaseEntity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Set;
import java.util.UUID;

@Setter
@Getter
@Entity @Table(name = "option")
public class Option extends BaseEntity<UUID> {

  private String sku;
  private String name;
  private String shortDescription;
  private Double price;
  @ManyToMany(cascade = CascadeType.PERSIST)
  @JoinTable(
          name = "option_group_link",
          joinColumns = @JoinColumn(name = "option_id"),
          inverseJoinColumns = @JoinColumn(name = "option_group_id")
  )
  private Set<OptionGroup> optionGroups;
  private Boolean status;

}
