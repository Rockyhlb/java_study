package com.hlb.dao;

import com.hlb.biz.JdbcFactory;

import java.sql.SQLException;

public interface IDao {

    void add(JdbcFactory jdbcFactory) throws SQLException;
    void delete(JdbcFactory jdbcFactory) throws SQLException;
    void select(JdbcFactory jdbcFactory, String select_sql) throws SQLException;
    void update(JdbcFactory jdbcFactory) throws SQLException;
}
