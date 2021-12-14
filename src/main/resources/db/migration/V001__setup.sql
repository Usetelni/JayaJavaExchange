CREATE TABLE IF NOT EXISTS currency_transaction(
    id                      LONG                 NOT NULL,
    origin_currency         VARCHAR(3)           NOT NULL,
    destination_currency    VARCHAR(3)           NOT NULL,
    origin_amount           DOUBLE               NOT NULL,
    conversion_tax          DOUBLE               NOT NULL,
    created_at              TIMESTAMP,
    updated_at              TIMESTAMP,
    deleted_at              TIMESTAMP            DEFAULT NULL,
    PRIMARY KEY (id)
);