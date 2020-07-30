package com.bit2020.mysite.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bit2020.mysite.vo.UserVo;

public class UserRepository {
	
	public boolean save(UserVo vo) {
		boolean result = false;
		Connection connection = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1. 연결하기
			connection = getConnection();

			// 2. SQL 준비
			String sql = 
				"     insert" +
				"  into user" + 
				"     values(null, ?, ?, password(?), ?, now())"; 
			pstmt = connection.prepareStatement(sql);
			
			// 3. 바인딩(binding)
			pstmt.setString(1, vo.getName());
			pstmt.setString(2, vo.getEmail());
			pstmt.setString(3, vo.getPassword());
			pstmt.setString(4, vo.getGender());
			
			// 4. sql 실행	
			int count = pstmt.executeUpdate();
			result = (count == 1);
			
		} catch (SQLException e) {
			System.out.println("에러:" + e);
		} finally {
			try {
				if(pstmt != null) {
					pstmt.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}	
	
	private Connection getConnection() throws SQLException {
		Connection connection = null;
		try {
			// 1. JDBC Driver(MariaDB Driver)
			Class.forName("org.mariadb.jdbc.Driver");
	
			// 2. 연결하기
			String url = "jdbc:mysql://127.0.0.1:3306/webdb?characterEncoding=utf8";
			connection = DriverManager.getConnection(url, "webdb", "webdb");
			
		} catch(ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		}
		
		return connection;
	}

	public UserVo findByEmailAndPassword(String email, String password) {
		UserVo result = null;
		
		
		return result;
	}
}