package com.xxxxx.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	static Connection conn = null;
	static PreparedStatement pst = null;
	static ResultSet set = null;

	public static Connection getConnection() {
		final String url = "jdbc:mysql://localhost:3306/s_c";
		final String user = "root";
		final String password = "root";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}

	// 获取信息总数
	public static int getTotalCount(String sql) {
		int n = 0;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql);
			set = pst.executeQuery();
			if (set.next()) {
				n = set.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			close();
		}
		return n;
	}

	// 增删改
	public static boolean executeUpdate(String sql, Object[] objects) {
		int i = 0;
		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql);
			for (int j = 0; j < objects.length; j++) {
				pst.setObject(j + 1, objects[j]);
			}
			i = pst.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i == 1;
	}

	// 查
	public static ResultSet executeQuery(String sql, Object[] objects) {

		try {
			conn = getConnection();
			pst = conn.prepareStatement(sql);
			for (int j = 0; j < objects.length; j++) {
				pst.setObject(j + 1, objects[j]);
			}
			set = pst.executeQuery();// ResultSet 集合中从下标为 1 的开始存储信息
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return set;
	}

	// 关闭资源
	public static void close() {
		try {
			if (set != null)
				set.close();
			if (pst != null)
				pst.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
