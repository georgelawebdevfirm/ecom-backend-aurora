CREATE TABLE attribute
(
    id               BIGINT                                    NOT NULL,
    uuid             CHAR(36)                                  NULL,
    store_id         VARCHAR(255)                              NULL,
    deleted          BIT(1)                                    NULL,
    active           BIT(1)                                    NULL,
    created_at       DATETIME                                  NULL,
    created_by       VARCHAR(255)                              NULL,
    updated_at       DATETIME                                  NULL,
    updated_by       VARCHAR(255)                              NULL,
    name             VARCHAR(255)                              NULL,
    type             ENUM ('STRING', 'DATE', 'LONG', 'DOUBLE') NULL,
    url              VARCHAR(2048)                             NULL,
    title            VARCHAR(60)                               NULL,
    meta_keywords    VARCHAR(150)                              NULL,
    meta_description VARCHAR(160)                              NULL,
    canonical        VARCHAR(2048)                             NULL,
    CONSTRAINT pk_attribute PRIMARY KEY (id)
);

CREATE TABLE category
(
    id               BIGINT        NOT NULL,
    uuid             CHAR(36)      NULL,
    store_id         VARCHAR(255)  NULL,
    deleted          BIT(1)        NULL,
    active           BIT(1)        NULL,
    created_at       DATETIME      NULL,
    created_by       VARCHAR(255)  NULL,
    updated_at       DATETIME      NULL,
    updated_by       VARCHAR(255)  NULL,
    label            VARCHAR(255)  NULL,
    content          VARCHAR(255)  NULL,
    parent_id        BIGINT        NULL,
    url              VARCHAR(2048) NULL,
    title            VARCHAR(60)   NULL,
    meta_keywords    VARCHAR(150)  NULL,
    meta_description VARCHAR(160)  NULL,
    canonical        VARCHAR(2048) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE category_product
(
    category_id BIGINT NOT NULL,
    product_id  BIGINT NOT NULL
);

CREATE TABLE `option`
(
    id                BIGINT         NOT NULL,
    uuid              CHAR(36)       NULL,
    store_id          VARCHAR(255)   NULL,
    deleted           BIT(1)         NULL,
    active            BIT(1)         NULL,
    created_at        DATETIME       NULL,
    created_by        VARCHAR(255)   NULL,
    updated_at        DATETIME       NULL,
    updated_by        VARCHAR(255)   NULL,
    sku               VARCHAR(255)   NULL,
    name              VARCHAR(255)   NULL,
    short_description VARCHAR(255)   NULL,
    price             DECIMAL(12, 2) NULL,
    status            BIT(1)         NULL,
    CONSTRAINT pk_option PRIMARY KEY (id)
);

CREATE TABLE option_group
(
    id                BIGINT       NOT NULL,
    uuid              CHAR(36)     NULL,
    store_id          VARCHAR(255) NULL,
    deleted           BIT(1)       NULL,
    active            BIT(1)       NULL,
    created_at        DATETIME     NULL,
    created_by        VARCHAR(255) NULL,
    updated_at        DATETIME     NULL,
    updated_by        VARCHAR(255) NULL,
    name              VARCHAR(255) NULL,
    label             VARCHAR(255) NULL,
    required          BIT(1)       NULL,
    sort              INT          NULL,
    default_option_id BIGINT       NULL,
    CONSTRAINT pk_option_group PRIMARY KEY (id)
);

CREATE TABLE option_group_link
(
    option_group_id BIGINT NOT NULL,
    option_id       BIGINT NOT NULL,
    CONSTRAINT pk_option_group_link PRIMARY KEY (option_group_id, option_id)
);

CREATE TABLE product
(
    id                     BIGINT                              NOT NULL,
    uuid                   CHAR(36)                            NULL,
    store_id               VARCHAR(255)                        NULL,
    deleted                BIT(1)                              NULL,
    active                 BIT(1)                              NULL,
    created_at             DATETIME                            NULL,
    created_by             VARCHAR(255)                        NULL,
    updated_at             DATETIME                            NULL,
    updated_by             VARCHAR(255)                        NULL,
    name                   VARCHAR(255)                        NULL,
    sku                    VARCHAR(255)                        NULL,
    show_sku               BIT(1)                              NULL,
    manufacturer_id        VARCHAR(255)                        NULL,
    manufacturer_id_type   ENUM ('UPC', 'GTIN', 'ISBN', 'EAN') NULL,
    sort_index             INT                                 NULL,
    cost                   DECIMAL(12, 2)                      NULL,
    retail_price           DECIMAL(12, 2)                      NULL,
    sale_price             DECIMAL(12, 2)                      NULL,
    show_retail_price      BIT(1)                              NULL,
    show_sale_price        BIT(1)                              NULL,
    new_product            BIT(1)                              NULL,
    new_product_sort_index INT                                 NULL,
    best_seller            BIT(1)                              NULL,
    best_seller_sort_index INT                                 NULL,
    featured               BIT(1)                              NULL,
    in_stock               BIT(1)                              NULL,
    inventory              INT                                 NULL,
    special_sort_index     INT                                 NULL,
    pre_order              BIT(1)                              NULL,
    availability_date      DATETIME                            NULL,
    clearance              BIT(1)                              NULL,
    `description`          TEXT                                NULL,
    short_description      TEXT                                NULL,
    description_spanish    TEXT                                NULL,
    inventory_description  VARCHAR(160)                        NULL,
    inventory_location     VARCHAR(160)                        NULL,
    product_video          VARCHAR(2048)                       NULL,
    large_image            VARCHAR(2048)                       NULL,
    small_image            VARCHAR(2048)                       NULL,
    thumbnail              VARCHAR(2048)                       NULL,
    tax_class              BIT(1)                              NULL,
    status                 BIT(1)                              NULL,
    is_complex_variant     BIT(1)                              NULL,
    parent_id              BIGINT                              NULL,
    additional_attributes  JSON                                NULL,
    dimension_length       DECIMAL(15, 6)                      NULL,
    dimension_width        DECIMAL(15, 6)                      NULL,
    dimension_height       DECIMAL(15, 6)                      NULL,
    dimension_weight       DECIMAL(15, 6)                      NULL,
    dimension_weight_unit  ENUM ('LB', 'KG', 'OZ')             NULL,
    dimension_length_unit  ENUM ('FT', 'IN')                   NULL,
    dimension_width_unit   ENUM ('FT', 'IN')                   NULL,
    dimension_height_unit  ENUM ('FT', 'IN')                   NULL,
    url                    VARCHAR(2048)                       NULL,
    title                  VARCHAR(60)                         NULL,
    meta_keywords          VARCHAR(150)                        NULL,
    meta_description       VARCHAR(160)                        NULL,
    canonical              VARCHAR(2048)                       NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE product_attribute_value
(
    id           BIGINT        NOT NULL,
    product_id   BIGINT        NULL,
    attribute_id BIGINT        NULL,
    string_val   VARCHAR(2048) NULL,
    date_val     DATETIME      NULL,
    long_val     BIGINT        NULL,
    double_val   DOUBLE        NULL,
    CONSTRAINT pk_product_attribute_value PRIMARY KEY (id)
);

CREATE TABLE product_image_url
(
    product_id          BIGINT        NOT NULL,
    products_images_url VARCHAR(2048) NULL
);

CREATE TABLE product_option_group
(
    option_group_id BIGINT NOT NULL,
    product_id      BIGINT NOT NULL,
    CONSTRAINT pk_product_option_group PRIMARY KEY (option_group_id, product_id)
);

CREATE INDEX idx_category_store_id ON category (store_id);

CREATE INDEX idx_category_uuid ON category (uuid);

CREATE INDEX idx_option_group_store_id ON option_group (store_id);

CREATE INDEX idx_option_group_uuid ON option_group (uuid);

CREATE INDEX idx_option_store_id ON `option` (store_id);

CREATE INDEX idx_option_uuid ON `option` (uuid);

CREATE INDEX idx_product_store_id ON product (store_id);

CREATE INDEX idx_product_uuid ON product (uuid);

ALTER TABLE category
    ADD CONSTRAINT FK_CATEGORY_ON_PARENT FOREIGN KEY (parent_id) REFERENCES category (id);

ALTER TABLE option_group
    ADD CONSTRAINT FK_OPTION_GROUP_ON_DEFAULT_OPTION FOREIGN KEY (default_option_id) REFERENCES `option` (id);

ALTER TABLE product_attribute_value
    ADD CONSTRAINT FK_PRODUCT_ATTRIBUTE_VALUE_ON_ATTRIBUTE FOREIGN KEY (attribute_id) REFERENCES attribute (id);

ALTER TABLE product_attribute_value
    ADD CONSTRAINT FK_PRODUCT_ATTRIBUTE_VALUE_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_PARENT FOREIGN KEY (parent_id) REFERENCES product (id);

ALTER TABLE category_product
    ADD CONSTRAINT fk_catpro_on_category FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE category_product
    ADD CONSTRAINT fk_catpro_on_product FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE option_group_link
    ADD CONSTRAINT fk_optgro_on_option FOREIGN KEY (option_id) REFERENCES `option` (id);

ALTER TABLE option_group_link
    ADD CONSTRAINT fk_optgro_on_option_group FOREIGN KEY (option_group_id) REFERENCES option_group (id);

ALTER TABLE product_image_url
    ADD CONSTRAINT fk_product_image_url_on_product FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE product_option_group
    ADD CONSTRAINT fk_prooptgro_on_option_group FOREIGN KEY (option_group_id) REFERENCES option_group (id);

ALTER TABLE product_option_group
    ADD CONSTRAINT fk_prooptgro_on_product FOREIGN KEY (product_id) REFERENCES product (id);
CREATE TABLE attribute
(
    id               BIGINT                                    NOT NULL,
    uuid             CHAR(36)                                  NULL,
    store_id         VARCHAR(255)                              NULL,
    deleted          BIT(1)                                    NULL,
    active           BIT(1)                                    NULL,
    created_at       DATETIME                                  NULL,
    created_by       VARCHAR(255)                              NULL,
    updated_at       DATETIME                                  NULL,
    updated_by       VARCHAR(255)                              NULL,
    name             VARCHAR(255)                              NULL,
    type             ENUM ('STRING', 'DATE', 'LONG', 'DOUBLE') NULL,
    url              VARCHAR(2048)                             NULL,
    title            VARCHAR(60)                               NULL,
    meta_keywords    VARCHAR(150)                              NULL,
    meta_description VARCHAR(160)                              NULL,
    canonical        VARCHAR(2048)                             NULL,
    CONSTRAINT pk_attribute PRIMARY KEY (id)
);

CREATE TABLE category
(
    id               BIGINT        NOT NULL,
    uuid             CHAR(36)      NULL,
    store_id         VARCHAR(255)  NULL,
    deleted          BIT(1)        NULL,
    active           BIT(1)        NULL,
    created_at       DATETIME      NULL,
    created_by       VARCHAR(255)  NULL,
    updated_at       DATETIME      NULL,
    updated_by       VARCHAR(255)  NULL,
    label            VARCHAR(255)  NULL,
    content          VARCHAR(255)  NULL,
    parent_id        BIGINT        NULL,
    url              VARCHAR(2048) NULL,
    title            VARCHAR(60)   NULL,
    meta_keywords    VARCHAR(150)  NULL,
    meta_description VARCHAR(160)  NULL,
    canonical        VARCHAR(2048) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE category_product
(
    category_id BIGINT NOT NULL,
    product_id  BIGINT NOT NULL
);

CREATE TABLE `option`
(
    id                BIGINT         NOT NULL,
    uuid              CHAR(36)       NULL,
    store_id          VARCHAR(255)   NULL,
    deleted           BIT(1)         NULL,
    active            BIT(1)         NULL,
    created_at        DATETIME       NULL,
    created_by        VARCHAR(255)   NULL,
    updated_at        DATETIME       NULL,
    updated_by        VARCHAR(255)   NULL,
    sku               VARCHAR(255)   NULL,
    name              VARCHAR(255)   NULL,
    short_description VARCHAR(255)   NULL,
    price             DECIMAL(12, 2) NULL,
    status            BIT(1)         NULL,
    CONSTRAINT pk_option PRIMARY KEY (id)
);

CREATE TABLE option_group
(
    id                BIGINT       NOT NULL,
    uuid              CHAR(36)     NULL,
    store_id          VARCHAR(255) NULL,
    deleted           BIT(1)       NULL,
    active            BIT(1)       NULL,
    created_at        DATETIME     NULL,
    created_by        VARCHAR(255) NULL,
    updated_at        DATETIME     NULL,
    updated_by        VARCHAR(255) NULL,
    name              VARCHAR(255) NULL,
    label             VARCHAR(255) NULL,
    required          BIT(1)       NULL,
    sort              INT          NULL,
    default_option_id BIGINT       NULL,
    CONSTRAINT pk_option_group PRIMARY KEY (id)
);

CREATE TABLE option_group_link
(
    option_group_id BIGINT NOT NULL,
    option_id       BIGINT NOT NULL,
    CONSTRAINT pk_option_group_link PRIMARY KEY (option_group_id, option_id)
);

CREATE TABLE product
(
    id                     BIGINT                              NOT NULL,
    uuid                   CHAR(36)                            NULL,
    store_id               VARCHAR(255)                        NULL,
    deleted                BIT(1)                              NULL,
    active                 BIT(1)                              NULL,
    created_at             DATETIME                            NULL,
    created_by             VARCHAR(255)                        NULL,
    updated_at             DATETIME                            NULL,
    updated_by             VARCHAR(255)                        NULL,
    name                   VARCHAR(255)                        NULL,
    sku                    VARCHAR(255)                        NULL,
    show_sku               BIT(1)                              NULL,
    manufacturer_id        VARCHAR(255)                        NULL,
    manufacturer_id_type   ENUM ('UPC', 'GTIN', 'ISBN', 'EAN') NULL,
    sort_index             INT                                 NULL,
    cost                   DECIMAL(12, 2)                      NULL,
    retail_price           DECIMAL(12, 2)                      NULL,
    sale_price             DECIMAL(12, 2)                      NULL,
    show_retail_price      BIT(1)                              NULL,
    show_sale_price        BIT(1)                              NULL,
    new_product            BIT(1)                              NULL,
    new_product_sort_index INT                                 NULL,
    best_seller            BIT(1)                              NULL,
    best_seller_sort_index INT                                 NULL,
    featured               BIT(1)                              NULL,
    in_stock               BIT(1)                              NULL,
    inventory              INT                                 NULL,
    special_sort_index     INT                                 NULL,
    pre_order              BIT(1)                              NULL,
    availability_date      DATETIME                            NULL,
    clearance              BIT(1)                              NULL,
    `description`          TEXT                                NULL,
    short_description      TEXT                                NULL,
    description_spanish    TEXT                                NULL,
    inventory_description  VARCHAR(160)                        NULL,
    inventory_location     VARCHAR(160)                        NULL,
    product_video          VARCHAR(2048)                       NULL,
    large_image            VARCHAR(2048)                       NULL,
    small_image            VARCHAR(2048)                       NULL,
    thumbnail              VARCHAR(2048)                       NULL,
    tax_class              BIT(1)                              NULL,
    status                 BIT(1)                              NULL,
    is_complex_variant     BIT(1)                              NULL,
    parent_id              BIGINT                              NULL,
    additional_attributes  JSON                                NULL,
    dimension_length       DECIMAL(15, 6)                      NULL,
    dimension_width        DECIMAL(15, 6)                      NULL,
    dimension_height       DECIMAL(15, 6)                      NULL,
    dimension_weight       DECIMAL(15, 6)                      NULL,
    dimension_weight_unit  ENUM ('LB', 'KG', 'OZ')             NULL,
    dimension_length_unit  ENUM ('FT', 'IN')                   NULL,
    dimension_width_unit   ENUM ('FT', 'IN')                   NULL,
    dimension_height_unit  ENUM ('FT', 'IN')                   NULL,
    url                    VARCHAR(2048)                       NULL,
    title                  VARCHAR(60)                         NULL,
    meta_keywords          VARCHAR(150)                        NULL,
    meta_description       VARCHAR(160)                        NULL,
    canonical              VARCHAR(2048)                       NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE product_attribute_value
(
    id           BIGINT        NOT NULL,
    product_id   BIGINT        NULL,
    attribute_id BIGINT        NULL,
    string_val   VARCHAR(2048) NULL,
    date_val     DATETIME      NULL,
    long_val     BIGINT        NULL,
    double_val   DOUBLE        NULL,
    CONSTRAINT pk_product_attribute_value PRIMARY KEY (id)
);

CREATE TABLE product_image_url
(
    product_id          BIGINT        NOT NULL,
    products_images_url VARCHAR(2048) NULL
);

CREATE TABLE product_option_group
(
    option_group_id BIGINT NOT NULL,
    product_id      BIGINT NOT NULL,
    CONSTRAINT pk_product_option_group PRIMARY KEY (option_group_id, product_id)
);

CREATE INDEX idx_category_store_id ON category (store_id);

CREATE INDEX idx_category_uuid ON category (uuid);

CREATE INDEX idx_option_group_store_id ON option_group (store_id);

CREATE INDEX idx_option_group_uuid ON option_group (uuid);

CREATE INDEX idx_option_store_id ON `option` (store_id);

CREATE INDEX idx_option_uuid ON `option` (uuid);

CREATE INDEX idx_product_store_id ON product (store_id);

CREATE INDEX idx_product_uuid ON product (uuid);

ALTER TABLE category
    ADD CONSTRAINT FK_CATEGORY_ON_PARENT FOREIGN KEY (parent_id) REFERENCES category (id);

ALTER TABLE option_group
    ADD CONSTRAINT FK_OPTION_GROUP_ON_DEFAULT_OPTION FOREIGN KEY (default_option_id) REFERENCES `option` (id);

ALTER TABLE product_attribute_value
    ADD CONSTRAINT FK_PRODUCT_ATTRIBUTE_VALUE_ON_ATTRIBUTE FOREIGN KEY (attribute_id) REFERENCES attribute (id);

ALTER TABLE product_attribute_value
    ADD CONSTRAINT FK_PRODUCT_ATTRIBUTE_VALUE_ON_PRODUCT FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE product
    ADD CONSTRAINT FK_PRODUCT_ON_PARENT FOREIGN KEY (parent_id) REFERENCES product (id);

ALTER TABLE category_product
    ADD CONSTRAINT fk_catpro_on_category FOREIGN KEY (category_id) REFERENCES category (id);

ALTER TABLE category_product
    ADD CONSTRAINT fk_catpro_on_product FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE option_group_link
    ADD CONSTRAINT fk_optgro_on_option FOREIGN KEY (option_id) REFERENCES `option` (id);

ALTER TABLE option_group_link
    ADD CONSTRAINT fk_optgro_on_option_group FOREIGN KEY (option_group_id) REFERENCES option_group (id);

ALTER TABLE product_image_url
    ADD CONSTRAINT fk_product_image_url_on_product FOREIGN KEY (product_id) REFERENCES product (id);

ALTER TABLE product_option_group
    ADD CONSTRAINT fk_prooptgro_on_option_group FOREIGN KEY (option_group_id) REFERENCES option_group (id);

ALTER TABLE product_option_group
    ADD CONSTRAINT fk_prooptgro_on_product FOREIGN KEY (product_id) REFERENCES product (id);