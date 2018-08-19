package com.qaprosoft.stockproject.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.stockproject.dao.IStockHasItemDAO;
import com.qaprosoft.stockproject.dao.JDBCAbstractDAO;
import com.qaprosoft.stockproject.entity.Item;
//import com.qaprosoft.stockproject.entity.Stock;
import com.qaprosoft.stockproject.entity.StockHasItem;

public class StockHasItemDAO extends JDBCAbstractDAO implements IStockHasItemDAO {

    private static final Logger logger = LogManager.getLogger();

    public static final String SQL_GET_ITEM_AND_QUANTITY_BY_STOCK_ID = "SELECT * FROM sat.stocks_has_items WHERE stocks_id = ?";
    public static final String SQL_INSERT_NEW_ITEM_IN_STOCK = "INSERT sat.stocks_has_items (`stocks_id`, `items_id`, `quantity`) VALUES (?, ?, ?)";
    public static final String SQL_UPDATE_QUANTITY = "UPDATE sat.stocks_has_items SET quantity = ? WHERE stocks_id = ? AND items_id = ? ";
    public static final String SQL_DELETE = "DELETE FROM sat.stocks_has_items WHERE id = ?";
    public static final String SQL_GET_QUANTITY_BY_STOCK_AND_ITEM = "SELECT quantity FROM sat.stocks_has_items WHERE stocks_id = ? AND items_id = ?";
    public static final String SQL_DELETE_BY_STOCK_AND_ITEM = "DELETE FROM sat.stocks_has_items WHERE stocks_id = ? AND items_id = ? ";

    @Override
    public ArrayList<StockHasItem> getItemAndQuantityByStockId(Long id) {
	ArrayList<StockHasItem> stockHasItem = new ArrayList<>();
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
	    conn = getConnection();
	    ps = conn.prepareStatement(SQL_GET_ITEM_AND_QUANTITY_BY_STOCK_ID);
	    ps.setLong(1, id);
	    rs = ps.executeQuery();
	    while (rs.next()) {
		stockHasItem.add(createObject(rs));
	    }
	} catch (SQLException e) {
	    logger.log(Level.ERROR, "SQLException. Can not getItemAndQuantityByStockId: " + e);
	} finally {
	    endOperation(ps, conn, rs);
	}
	return stockHasItem;
    }

    private StockHasItem createObject(ResultSet rs) {
	StockHasItem shi = new StockHasItem();
	try {
	    shi.setId(rs.getLong("id"));
	    shi.setQuantity(rs.getInt("quantity"));
	    Item item = new Item();
	    item.setId(rs.getLong("items_id"));
	    shi.setItem(item);
	    // Stock stock = new Stock();
	    // stock.setId(rs.getLong("stocks_id"));
	    // shi.setStock(stock);
	} catch (SQLException e) {
	    logger.log(Level.ERROR, "SQLException. Can not createObject: " + e);
	}
	return shi;
    }

    @Override
    public StockHasItem insertNewItemInStock(Long stockID, StockHasItem shi) {
	Connection conn = getConnection();
	PreparedStatement ps = null;
	try {
	    ps = conn.prepareStatement(SQL_INSERT_NEW_ITEM_IN_STOCK);
	    // ps.setLong(1, shi.getStock().getId());
	    ps.setLong(1, stockID);
	    ps.setLong(2, shi.getItem().getId());
	    ps.setLong(3, shi.getQuantity());
	    ps.execute();
	    shi.setId(ps.getGeneratedKeys().getLong("id"));
	} catch (SQLException e) {
	    logger.log(Level.ERROR, "SQLException. Can not write from field: " + e);
	} finally {
	    endOperation(ps, conn);
	}
	return shi;
    }

    @Override
    public void insertNewItemInStockByStockItemAndNumber(Long stockID, Long itemId, Integer quantity) {
	Connection conn = getConnection();
	PreparedStatement ps = null;
	try {
	    ps = conn.prepareStatement(SQL_INSERT_NEW_ITEM_IN_STOCK);
	    // ps.setLong(1, shi.getStock().getId());
	    ps.setLong(1, stockID);
	    ps.setLong(2, itemId);
	    ps.setLong(3, quantity);
	    ps.execute();

	} catch (SQLException e) {
	    logger.log(Level.ERROR, "SQLException. Can not write from field: " + e);
	} finally {
	    endOperation(ps, conn);
	}
    }

    @Override
    public void updateItemInStock(Long stockId, Long itemId, Integer newCount) {
	Connection conn = getConnection();
	PreparedStatement ps = null;
	try {
	    ps = conn.prepareStatement(SQL_UPDATE_QUANTITY);
	    // ps.setLong(2, shi.getStock().getId());
	    ps.setLong(2, stockId);
	    ps.setLong(3, itemId);
	    ps.setLong(1, newCount);
	    ps.execute();
	} catch (SQLException e) {
	    logger.log(Level.ERROR, "SQLException. Can not write from field: " + e);
	} finally {
	    endOperation(ps, conn);
	}
    }

    @Override
    public void deleteItemInStock(StockHasItem shi) {
	Connection conn = getConnection();
	PreparedStatement ps = null;
	try {
	    ps = conn.prepareStatement(SQL_DELETE);
	    ps.setLong(1, shi.getId());
	    ps.execute();
	} catch (SQLException e) {
	    logger.log(Level.ERROR, "SQLException. Can not write from field: " + e);
	} finally {
	    endOperation(ps, conn);
	}
    }
    
    @Override
    public void deleteItemByStockIdAndItemId(Long stockId, Long itemId) {
	Connection conn = getConnection();
	PreparedStatement ps = null;
	try {
	    ps = conn.prepareStatement(SQL_DELETE_BY_STOCK_AND_ITEM);
	    ps.setLong(1, stockId);
	    ps.setLong(2, itemId);
	    ps.execute();
	} catch (SQLException e) {
	    logger.log(Level.ERROR, "SQLException. Can not write from field: " + e);
	} finally {
	    endOperation(ps, conn);
	}
    }

    @Override
    public Integer getQuantityByStockAndItem(Long itemId, Long stockId) {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
	    conn = getConnection();
	    ps = conn.prepareStatement(SQL_GET_QUANTITY_BY_STOCK_AND_ITEM);
	    ps.setLong(1, stockId);
	    ps.setLong(2, itemId);
	    rs = ps.executeQuery();
	    return rs.getInt(0);
	} catch (SQLException e) {
	    logger.log(Level.ERROR, "SQLException. Can not getItemAndQuantityByStockId: " + e);
	} finally {
	    endOperation(ps, conn, rs);
	}
	return null;
    }

}
