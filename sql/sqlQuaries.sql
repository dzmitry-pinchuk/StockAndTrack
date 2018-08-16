SELECT * FROM stocks_has_items;
INSERT stocks_has_items (`stocks_id`, `items_id`) VALUE (1, 1);

CALL `sat`.`autoset`();
DELETE FROM stocks_has_items;

SELECT * FROM sat.transport;

SELECT * FROM tracks t LEFT JOIN transport tr ON t.transport_id=tr.id;
SELECT * FROM trains t LEFT JOIN transport tr ON t.transport_id=tr.id;
