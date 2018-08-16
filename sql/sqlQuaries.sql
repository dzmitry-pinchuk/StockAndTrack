SELECT * FROM stocks_has_items;
INSERT stocks_has_items (`stocks_id`, `items_id`) VALUE (1, 1);

CALL `sat`.`autoset`();
DELETE FROM stocks_has_items;