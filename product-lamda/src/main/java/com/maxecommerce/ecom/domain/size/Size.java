package com.maxecommerce.ecom.domain.size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Embeddable;
import javax.persistence.Id;

@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
@Accessors(chain = true)
@Embeddable
public class Size {
  @Id
  private Integer id;
  private String label;
}
