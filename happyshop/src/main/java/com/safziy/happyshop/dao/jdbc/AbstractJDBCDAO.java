package com.safziy.happyshop.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;

public class AbstractJDBCDAO<T> {

	@Autowired
	protected JdbcTemplate jdbcTemplate;

	protected T query(String sql) {
		return null;
	}

	protected T query(String sql, Object[] args) {
		return jdbcTemplate.query(sql, args, new ResultSetExtractor<T>() {

			@Override
			public T extractData(ResultSet rs) throws SQLException, DataAccessException {
				return null;
			}

		});
	}

	protected List<T> queryList(String sql) {
		return null;
	}

	protected List<T> queryList(String sql, Object[] args) {
		return null;
	}

	protected int save(String sql) {
		return 0;
	}

	protected int save(String sql, Object[] args) {
		return 0;
	}

	protected int saveOrUpdate(String sql) {
		return 0;
	}

	protected int saveOrUpdate(String sql, Object[] args) {
		return 0;
	}

	protected int delete(String sql) {
		return 0;
	}

	protected int delete(String sql, Object[] args) {
		return 0;
	}

	protected int update(String sql) {
		return 0;
	}

	protected int update(String sql, Object[] args) {
		return 0;
	}
}
