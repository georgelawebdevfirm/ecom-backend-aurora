package com.maxecommerce.ecom.domain;

import com.maxecommerce.ecom.domain.audit.AuditAttributes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity<I extends Serializable> {

  @Id @GeneratedValue protected I id;
  @GeneratedValue protected UUID uuid;
  protected String storeId;
  protected Boolean deleted;
  protected Boolean active = true;
  @Embedded protected AuditAttributes auditAttributes;

  public boolean hasId(){
    return id != null;
  }

}
