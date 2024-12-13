package com.mavenir.vmp.core.jpa;

import org.hibernate.dialect.Dialect;
import org.hibernate.dialect.pagination.LimitHandler;
import org.hibernate.query.spi.Limit;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Custom Limit Handler for SQLite to handle limit/offset pagination.
 */
public class SQLiteLimitHandler implements LimitHandler {

    private final Dialect dialect;

    public SQLiteLimitHandler(Dialect dialect) {
        this.dialect = dialect;
    }


    @Override
    public boolean supportsLimit() {
        return false;
    }

    @Override
    public boolean supportsOffset() {
        return false;
    }

    @Override
    public boolean supportsLimitOffset() {
        return false;
    }

    @Override
    public String processSql(String s, Limit limit) {
        return "";
    }

    @Override
    public int bindLimitParametersAtStartOfQuery(Limit limit, PreparedStatement preparedStatement, int i) throws SQLException {
        return 0;
    }

    @Override
    public int bindLimitParametersAtEndOfQuery(Limit limit, PreparedStatement preparedStatement, int i) throws SQLException {
        return 0;
    }

    @Override
    public void setMaxRows(Limit limit, PreparedStatement preparedStatement) throws SQLException {

    }
}
