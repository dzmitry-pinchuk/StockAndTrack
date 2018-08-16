package com.qaprosoft.stockproject.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.stockproject.dao.IItemDAO;
import com.qaprosoft.stockproject.dao.JDBCAbstractDAO;
import com.qaprosoft.stockproject.entity.Item;

public class ItemDAO extends JDBCAbstractDAO implements IItemDAO {

    private static Logger logger = LogManager.getLogger();

    public static final String SQL_SELECT_ALL_ITEMS = "SELECT * FROM sat.items";
    public static final String SQL_SELECT_BY_ID = "SELECT * FROM sat.items WHERE id=?";
    public static final String SQL_DELETE_BY_ID = "DELETE FROM sat.items WHERE id = ?";
    public static final String SQL_CREATE_NEW_ITEM = "INSERT INTO sat.items (`name`, `price`, `weight`) VALUES (?,?,?)";

    @Override
    public ArrayList<Item> getAll() {
	ArrayList<Item> allItems = new ArrayList<>();
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
	    conn = getConnection();
	    ps = conn.prepareStatement(SQL_SELECT_ALL_ITEMS);
	    rs = ps.executeQuery();
	    while (rs.next()) {
		allItems.add(createObject(rs));
	    }
	} catch (SQLException e) {
	    logger.log(Level.ERROR, "SQLException. Can not read from field: " + e);
	} finally {
	    endOperation(ps, conn, rs);
	}
	return allItems;
    }

    private Item createObject(ResultSet rs) {
	Item item = new Item();
	try {
	    item.setId(rs.getLong("id"));
	    item.setName(rs.getString("name"));
	    item.setPrice(rs.getInt("price"));
	    item.setWeight(rs.getInt("weight"));
	} catch (SQLException e) {
	    logger.log(Level.ERROR, "SQLException. Can not read from field: " + e);
	}
	return item;
    }

    @Override
    public Item getById(Long id) {
	Item item = new Item();
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	try {
	    conn = getConnection();
	    ps = conn.prepareStatement(SQL_SELECT_BY_ID);
	    ps.setLong(1, id);
	    rs = ps.executeQuery();
	    rs.next();
	    item = createObject(rs);
	} catch (SQLException e) {
	    logger.log(Level.ERROR, "SQLException. Can not read from field: " + e);
	} finally {
	    endOperation(ps, conn, rs);
	}
	return item;
    }

    @Override
    public void deleteById(Long id) {
	throw new UnsupportedOperationException("method not create");
    }

    @Override
    public void createNewItem(Item item) {
	throw new UnsupportedOperationException("method not create");
    }

}
