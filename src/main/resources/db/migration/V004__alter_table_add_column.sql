ALTER TABLE currency_transaction ADD COLUMN end_to_end VARCHAR(60)  AFTER id;
ALTER TABLE currency_transaction ADD COLUMN destination_amount DOUBLE AFTER origin_amount;