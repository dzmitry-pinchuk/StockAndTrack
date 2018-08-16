CREATE DEFINER=`root`@`localhost` PROCEDURE `autoset`()
BEGIN
	SET @a=1;
    WHILE @a<=10 DO
		SET @b=1;
		WHILE @b<=30 DO
			INSERT stocks_has_items (`stocks_id`, `items_id`) VALUE (@a, @b);
			SET @b=@b +1;
		END WHILE;
	SET @a=@a+1;
    END WHILE;
END