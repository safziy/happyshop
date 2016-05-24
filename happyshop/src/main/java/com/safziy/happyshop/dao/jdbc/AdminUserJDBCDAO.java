package com.safziy.happyshop.dao.jdbc;

import com.safziy.happyshop.entity.AdminUser;

public class AdminUserJDBCDAO extends AbstractJDBCDAO<AdminUser> {
	private static final String BASE_SELECT_SQL = "select * from admin_user";

	public AdminUser findById(Long id) {
		String sql = BASE_SELECT_SQL + " where id=?";
		return query(sql, new Object[]{id});
	}
}
