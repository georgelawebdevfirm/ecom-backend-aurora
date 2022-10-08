package com.maxecommerce.ecom.domain.attribute;

import com.maxecommerce.ecom.domain.BaseEntity;
import com.maxecommerce.ecom.domain.seo.SeoAttributes;
import com.sun.xml.bind.v2.schemagen.xmlschema.AttributeType;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.lang.management.LockInfo;
import java.util.List;
import java.util.UUID;

import static com.maxecommerce.ecom.domain.attribute.Attribute.AdditionalAttributeType.COLUMN_DEFINITION;

@Setter
@Getter
@Entity @Table(name = "attribute")
public class Attribute extends BaseEntity<Long> {

  private String name;

  @Column(name = "type", columnDefinition = COLUMN_DEFINITION)
  AdditionalAttributeType parameterType;

  @Embedded
  private SeoAttributes seoAttributes;

  /**
   * Enumeration representing the type of {@link Attribute}.
   */
  public enum AdditionalAttributeType {
    /**
     * Enumerator parameters
     */
    ENUMERATOR,
    /**
     * String parameter type.
     */
    STRING,
    /**
     * Date parameter type.
     */
    DATE,
    /**
     * Long parameter type.
     */
    LONG,
    /**
     * Double parameter type.
     */
    DOUBLE;
    public static final String COLUMN_DEFINITION = "ENUM('STRING', 'DATE', 'LONG', 'DOUBLE')";
  }
}
