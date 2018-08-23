SELECT * FROM stocks_has_items;
INSERT stocks_has_items (`stocks_id`, `items_id`) VALUE (1, 1);

CALL `sat`.`autoset`();
DELETE FROM stocks_has_items;

SELECT * FROM sat.types_of_transports_has_stocks;

SELECT * FROM tracks t LEFT JOIN transport tr ON t.transport_id=tr.id;
SELECT * FROM trains t LEFT JOIN transport tr ON t.transport_id=tr.id;

SELECT * FROM sat.stocks_has_items WHERE stocks_id =1;
UPDATE stocks_has_items SET quantity = 133 WHERE stocks_id = 1 AND items_id = 2;
INSERT stocks_has_items (`stocks_id`, `items_id`, `quantity`) VALUES (1, 1, 1 );

SHOW COLUMNS FROM items;
SELECT * FROM sat.types_of_transports_has_stocks;
SELECT * FROM stocks;

SELECT * FROM sat.trains t LEFT JOIN sat.transport tr ON t.transport_id=tr.id;

SELECT * FROM sat.stocks_has_items;
SELECT * FROM sat.stocks_has_items LIMIT 0, 1000;

SELECT * FROM sat.tracks t LEFT JOIN sat.transport tr ON t.transport_id=tr.id;
SELECT * FROM sat.tracks t LEFT JOIN sat.transport tr ON t.transport_id=tr.id WHERE t.id = 1;