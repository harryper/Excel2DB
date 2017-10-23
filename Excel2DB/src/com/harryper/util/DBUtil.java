package com.harryper.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBUtil {
	private static Connection conn;
	private static PreparedStatement ps;
	/**
	 * 获得数据库连接
	 * @return 数据库连接
	 */
	public static Connection getConn() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/excel","root","root");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}
	/**
	 * executeUpdate用来实现增加，删除，更改功能
	 * @param sql
	 * @param parameters
	 * @return 返回影响的行数
	 */
	public static int executeUpdate(String sql, Object[] parameters){
		int res=0;
		try {
			conn=getConn();
			ps=conn.prepareStatement(sql);
			//给？赋值
			if ( parameters != null && parameters.length > 0){
				for(int i = 0; i < parameters.length; i++){
					ps.setObject(i + 1, parameters[i]);
				}
			}
			//执行语句
			res=ps.executeUpdate();
			System.out.println("影响的结果是 ：" + res);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return res;
	}
}
