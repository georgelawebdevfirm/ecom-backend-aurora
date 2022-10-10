package com.maxecommerce.ecom.domain.attribute;

import com.maxecommerce.ecom.domain.BaseEntity;
import com.maxecommerce.ecom.domain.seo.SeoAttributes;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Index;
import javax.persistence.Table;

import static com.maxecommerce.ecom.domain.attribute.Attribute.AdditionalAttributeType.COLUMN_DEFINITION;

@Setter
@Getter
@Entity
@Table(
    name = "attribute",
    indexes = {
      @Index(name = "idx_attribute_uuid", columnList = "uuid"),
      @Index(name = "idx_attribute_store_id", columnList = "storeId")
    })
public class Attribute extends BaseEntity<Long> {

  private String name;

  @Column(name = "type", columnDefinition = COLUMN_DEFINITION)
  AdditionalAttributeType parameterType;

  @Embedded private SeoAttributes seoAttributes;

  /** Enumeration representing the type of {@link Attribute}. */
  public enum AdditionalAttributeType {
    /** Enumerator parameters */
    ENUMERATOR,
    /** String parameter type. */
    STRING,
    /** Date parameter type. */
    DATE,
    /** Long parameter type. */
    LONG,
    /** Double parameter type. */
    DOUBLE;
    public static final String COLUMN_DEFINITION =
        "ENUM('ENUMERATOR', 'STRING', 'DATE', 'LONG', 'DOUBLE')";
  }
}
