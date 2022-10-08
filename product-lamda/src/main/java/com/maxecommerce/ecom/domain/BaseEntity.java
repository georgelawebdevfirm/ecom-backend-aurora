package com.maxecommerce.ecom.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.UUID;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity<I extends Serializable> {

    @Id
    @GeneratedValue
    protected I id;
    protected UUID uuid;
    protected String storeId;
    protected Boolean deleted;
    protected Boolean active = true;

}
