package com.icss.dkgy.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * jdbc的封装
 * 
 * @author rgw
 */
public class BaseDao {
	protected Connection conn;

	// 打开连接
	public void openConnection() throws Exception {
		try {

			if (conn == null || conn.isClosed()) {
				// 1、加载JDBC驱动程序
				Class.forName("com.mysql.jdbc.Driver");
				// 2、建立数据库连接Connection
//				String url = "jdbc:mysql://localhost:3306/dankegongyu?useUnicode=true&characterEncoding=utf8";
//				String userName = "root";
//				String pwd = "12345";
//				
				//任广伟数据库 
				String url = "jdbc:mysql://localhost:3307/dankegongyu?useUnicode=true&characterEncoding=utf8";
				String userName = "root";
				String pwd = "888888";
				//更新dao层注释此部分
				conn = DriverManager.getConnection(url, userName, pwd);
			}
		} catch (Exception e) {
			throw e;
		}
	}

	// 关闭连接
	public void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 开启事务
	public void beginTransaction() throws Exception {
		openConnection();
		conn.setAutoCommit(false); // 手动提交事务
	}

	// 提交事务
	public void commit() throws SQLException {
		if (conn != null) {
			conn.commit(); // 手动提交事务
		}
	}

	// 回滚事务
	public void rollback() throws SQLException {
		if (conn != null) {
			conn.rollback(); // 手动提交事务
		}
	}
}
