package com.maxecommerce.ecom.domain.seo;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDateTime;

import static com.maxecommerce.ecom.domain.JpaTypeConstants.MAX_URL_LENGTH;

@Setter
@Getter
@NoArgsConstructor
@Accessors(chain = true)
@Embeddable
public class SeoAttributes {

    // SEO
    @Column(length = MAX_URL_LENGTH)
    private String url;

    @Column(length = 60)
    private String title;

    @Column(length = 150)
    private String metaKeywords;

    @Column(length = 160)
    private String metaDescription;

    @Column(length = MAX_URL_LENGTH)
    private String canonical;

}
