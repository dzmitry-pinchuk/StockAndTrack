package com.qaprosoft.stockproject.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.stockproject.dao.IStockDAO;
import com.qaprosoft.stockproject.dao.JDBCAbstractDAO;
import com.qaprosoft.stockproject.entity.Stock;
//import com.qaprosoft.stockproject.entity.StockHasItem;
import com.qaprosoft.stockproject.entity.TypeOfTransport;

public class StockDAO extends JDBCAbstractDAO implements IStockDAO {

	private static final Logger logger = LogManager.getLogger();

	public static final String SQL_SELECT_ALL_ITEMS = "SELECT * FROM sat.stocks";
	public static final String SQL_SELECT_BY_ID = "SELECT * FROM sat.stocks WHERE id=?";
	public static final String SQL_DELETE_BY_ID = "DELETE FROM sat.stocks WHERE id = ?";
	public static final String SQL_CREATE_NEW_ITEM = "INSERT INTO sat.stocks (`name`, `types_of_transports_id`) VALUES (?,?)";
	public static final String SQL_SELECT_TYPES_OF_TRANSPORT_BY_STOCK_ID = "SELECT * FROM sat.types_of_transports_has_stocks where stocks_id = ?";

	@Override
	public List<Stock> getAll() {
		List<Stock> allStocks = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(SQL_SELECT_ALL_ITEMS);
			rs = ps.executeQuery();
			while (rs.next()) {
				allStocks.add(createObject(rs));
			}
		} catch (SQLException e) {
			logger.log(Level.ERROR, "SQLException. Can not getAll: " + e);
		} finally {
			endOperation(ps, conn, rs);
		}
		return allStocks;
	}

	private Stock createObject(ResultSet rs) {
		Stock stock = new Stock();
		try {
			stock.setId(rs.getLong("id"));
			stock.setName(rs.getString("name"));
			stock.setTypes(getTypesByStockId(rs.getLong("id")));
		} catch (SQLException e) {
			logger.log(Level.ERROR, "SQLException. Can not createObject: " + e);
		}
		return stock;
	}

	@Override
	public Stock getById(Long id) {
		Stock stock = new Stock();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(SQL_SELECT_BY_ID);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			rs.next();
			stock = createObject(rs);
		} catch (SQLException e) {
			logger.log(Level.ERROR, "SQLException. Can not getById: " + e);
		} finally {
			endOperation(ps, conn, rs);
		}
		return stock;
	}

	@Override
	public void deleteById(Long id) {
		throw new UnsupportedOperationException("method not create");
	}

	@Override
	public void createNewEntity(Stock stock) {
		throw new UnsupportedOperationException("method not create");
	}

	private List<TypeOfTransport> getTypesByStockId(Long id) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<TypeOfTransport> types = new ArrayList<>();
		try {
			conn = getConnection();
			ps = conn.prepareStatement(SQL_SELECT_TYPES_OF_TRANSPORT_BY_STOCK_ID);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			while (rs.next()) {
				switch (rs.getInt("types_of_transports_id")) {
				case 1:
					types.add(TypeOfTransport.FOR_TRACK);
					break;
				case 2:
					types.add(TypeOfTransport.FOR_TRAIN);
					break;
				default:
					logger.log(Level.ERROR, "Can not read type");
					break;
				}
			}
		} catch (SQLException e) {
			logger.log(Level.ERROR, "SQLException. Can not getTypesByStockId: " + e);
		} finally {
			endOperation(ps, conn, rs);
		}
		return types;
	}

}
