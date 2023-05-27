package code.hlb.dao;

import code.hlb.dao.IDao;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ScoresDao implements IDao {

    @Override
    public boolean connect() throws SQLException {
        return false;
    }

    @Override
    public ResultSet executeQuery(String query) throws SQLException {
        return null;
    }

    @Override
    public int executeUpdate(String update) throws SQLException {
        return 0;
    }

    @Override
    public boolean disconnect() {

        return false;
    }
}
