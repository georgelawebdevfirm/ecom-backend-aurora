package com.maxecommerce.ecom.domain.audit;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
@Embeddable
public class AuditAttributes {
  @Column(name = "created_at")
  private LocalDateTime createdAt;

  @Column(name = "created_by", length = 1024)
  private String createdBy;

  @Column(name = "updated_at")
  private LocalDateTime updatedAt;

  @Column(name = "updated_by", length = 1024)
  private String updatedBy;
}
