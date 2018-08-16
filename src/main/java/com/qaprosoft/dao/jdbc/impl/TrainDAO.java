package com.qaprosoft.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.dao.ITrainDAO;
import com.qaprosoft.dao.JDBCAbstractDAO;
import com.qaprosoft.entity.TypeOfTransport;
import com.qaprosoft.entity.transport.Train;

public class TrainDAO extends JDBCAbstractDAO implements ITrainDAO{
	
	private static Logger logger = LogManager.getLogger();

	public static final String SQL_SELECT_ALL_TRACK = "SELECT * FROM sat.train t LEFT JOIN sat.transport tr ON t.transport_id=tr.id";
	public static final String SQL_SELECT_BY_ID = "SELECT * FROM sat.tracks t LEFT JOIN sat.transport tr ON t.transport_id=tr.id WHERE id=?";
	public static final String SQL_DELETE_BY_ID = "DELETE FROM sat.tracks WHERE id = ?";

	@Override
	public ArrayList<Train> getAll() {
		ArrayList<Train> allTrains = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(SQL_SELECT_ALL_TRACK);
			rs = ps.executeQuery();
			while (rs.next()) {
				allTrains.add(createObject(rs));
			}
		} catch (SQLException e) {
			logger.log(Level.ERROR, "SQLException. Can not read from field: " + e);
		} finally {
			endOperation(ps, conn, rs);
		}
		return allTrains;
	}

	private Train createObject(ResultSet rs) {
		Train train = new Train();
		try {
			train.setId(rs.getLong(1));
			train.setNumberOfWagons(rs.getInt("number_of_wagons"));
			train.setMaxCarryingCapacity(rs.getInt("max_�arrying_�apacity"));
			train.setName(rs.getString("name"));
			switch (rs.getInt("types_of_transports_id")) {
			case 1:
				train.setType(TypeOfTransport.FOR_TRACK);
				break;
			case 2:
				train.setType(TypeOfTransport.FOR_TRAIN);
				break;
			default:
				logger.log(Level.ERROR, "Can not read type");
				break;
			}
		} catch (SQLException e) {
			logger.log(Level.ERROR, "SQLException. Can not read from field: " + e);
		}
		return train;
	}

	@Override
	public Train getById(Long id) {
		Train train = new Train();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(SQL_SELECT_BY_ID);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			rs.next();
			train = createObject(rs);
		} catch (SQLException e) {
			logger.log(Level.ERROR, "SQLException. Can not read from field: " + e);
		} finally {
			endOperation(ps, conn, rs);
		}
		return train;
	}

	@Override
	public void deleteById(Long id) {
		throw new UnsupportedOperationException("method not create");
	}

	@Override
	public void createNewTrack(Train train) {
		throw new UnsupportedOperationException("method not create");
	}
	
	

}