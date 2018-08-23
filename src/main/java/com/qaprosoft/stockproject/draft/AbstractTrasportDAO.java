package com.qaprosoft.stockproject.draft;
/*package com.qaprosoft.stockproject.dao.jdbc.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qaprosoft.stockproject.dao.IAbstractTransportDAO;
import com.qaprosoft.stockproject.dao.JDBCAbstractDAO;
import com.qaprosoft.stockproject.entity.TypeOfTransport;
import com.qaprosoft.stockproject.entity.transport.AbstractTransport;
import com.qaprosoft.stockproject.entity.transport.Track;

public class AbstractTrasportDAO extends JDBCAbstractDAO implements IAbstractTransportDAO{
    
    private static Logger logger = LogManager.getLogger();

	public static final String SQL_SELECT_ALL_TRACK = "SELECT * FROM sat.tracks t LEFT JOIN sat.transport tr ON t.transport_id=tr.id";
	public static final String SQL_SELECT_BY_ID = "SELECT * FROM sat.tracks t LEFT JOIN sat.transport tr ON t.transport_id=tr.id WHERE id=?";
	public static final String SQL_DELETE_BY_ID = "DELETE FROM sat.tracks WHERE id = ?";
//	public static final String SQL_CREATE_NEW_TRACK = "INSERT INTO sat.stocks (`name`, `types_of_transports_id`) VALUES (?,?)";

	@Override
	public ArrayList<AbstractTransport> getAll() {
		ArrayList<AbstractTransport> transports = new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(SQL_SELECT_ALL_TRACK);
			rs = ps.executeQuery();
			while (rs.next()) {
			    transports.add(createObject(rs));
			}
		} catch (SQLException e) {
			logger.log(Level.ERROR, "SQLException. Can not read from field: " + e);
		} finally {
			endOperation(ps, conn, rs);
		}
		return transports;
	}

	private Track createObject(ResultSet rs) {
		Track track = new Track();
		try {
			track.setId(rs.getLong(1));
			track.setColor(rs.getString("color"));
			track.setMaxCarryingCapacity(rs.getInt("max_ñarrying_ñapacity"));
			track.setName(rs.getString("name"));
			switch (rs.getInt("types_of_transports_id")) {
			case 1:
				track.setType(TypeOfTransport.FOR_TRACK);
				break;
			case 2:
				track.setType(TypeOfTransport.FOR_TRAIN);
				break;
				
				
			default:
				logger.log(Level.ERROR, "Can not read type");
				break;
				
				if(account.getType() ==  AccountType.SAVINGACCOUNT) {
				    ((SavingAccount)Account).setRate(result.getDouble("rate"));
				    }
				
				
			}
		} catch (SQLException e) {
			logger.log(Level.ERROR, "SQLException. Can not read from field: " + e);
		}
		return track;
	}

	@Override
	public AbstractTransport getById(Long id) {
	      AbstractTransport transport;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			ps = conn.prepareStatement(SQL_SELECT_BY_ID);
			ps.setLong(1, id);
			rs = ps.executeQuery();
			rs.next();
			transport = createObject(rs);
		} catch (SQLException e) {
			logger.log(Level.ERROR, "SQLException. Can not read from field: " + e);
		} finally {
			endOperation(ps, conn, rs);
		}
		return transport;
	}

	@Override
	public void deleteById(Long id) {
		Connection conn = getConnection();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(SQL_DELETE_BY_ID);
			ps.setLong(1, id);
			ps.execute();
		} catch (SQLException e) {
			logger.log(Level.ERROR, "SQLException. Can not write from field: " + e);
		} finally {
			endOperation(ps, conn);
		}
	}

	@Override
	public void createNewTrack(Track track) {
		throw new UnsupportedOperationException("method not create");
	}

    

}
*/