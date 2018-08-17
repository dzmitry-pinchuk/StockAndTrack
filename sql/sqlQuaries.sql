SELECT * FROM stocks_has_items;
INSERT stocks_has_items (`stocks_id`, `items_id`) VALUE (1, 1);

CALL `sat`.`autoset`();
DELETE FROM stocks_has_items;

SELECT * FROM sat.types_of_transports_has_stocks;

SELECT * FROM tracks t LEFT JOIN transport tr ON t.transport_id=tr.id;
SELECT * FROM trains t LEFT JOIN transport tr ON t.transport_id=tr.id;

SELECT * FROM sat.stocks_has_items;
SELECT * FROM stocks;

SELECT * FROM sat.types_of_transports_has_stocks where stocks_id = 1;