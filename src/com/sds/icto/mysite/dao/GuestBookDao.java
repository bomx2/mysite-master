package com.sds.icto.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.mysite.vo.GuestBookVo;

public class GuestBookDao {

	private Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn = null;
		// 1.드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		// 2.connection 생성
		String dbURL = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(dbURL, "webdb", "webdb");
		return conn;
	}

	public void insert(GuestBookVo vo) throws ClassNotFoundException,
			SQLException {
		// Connection 생성
		Connection conn = getConnection();

		// 2. Statement(SQL) 준비
		String sql = "insert into guestbook values(GUESTBOOK_SEQ.nextval,?,?,?,sysdate)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		// 3.binding
		pstmt.setString(1, vo.getName());
		pstmt.setString(2, vo.getPassword());
		pstmt.setString(3, vo.getMessage());

		// 4. query 실행
		pstmt.executeUpdate();

		// 5. 자원정리
		if (pstmt != null) {
			pstmt.close();
		}

		if (conn != null) {
			conn.close();
		}
	}
	
	public void delete() throws ClassNotFoundException, SQLException {
		// 1. Connection 생성
		Connection conn = getConnection();
		// 2. statment 생성
		Statement stmt = conn.createStatement();
		// 3. query 실행
		String sql = "delete from guestbook";
		stmt.executeUpdate(sql);
		// 4. 자원 정리
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	public void delete(int no, String password) throws ClassNotFoundException, SQLException {
		// 1. Connection 생성
		Connection conn = getConnection();
		// 2. statment 생성
		Statement stmt = conn.createStatement();
		// 3. query 실행
		String sql = "delete from guestbook where no=? and password=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.setString(2, password);
		pstmt.executeUpdate();
		// 4. 자원 정리
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	public List<GuestBookVo> fetchList() throws ClassNotFoundException,
			SQLException {
		List<GuestBookVo> list = new ArrayList<GuestBookVo>();
		// 1. Connection 생성
		Connection conn = getConnection();
		// 2. statment 생성
		Statement stmt = conn.createStatement();
		// 3. SQL문 실행
		String sql = "select no,name,password,message,to_char(sysdate,'yyyy-mm-dd') from guestbook";
		ResultSet rs = stmt.executeQuery(sql);
		// 4. 결과 처리
		while (rs.next()) {
			int no = rs.getInt(1);
			String name = rs.getString(2);
			String password = rs.getString(3);
			String message = rs.getString(4);
			String date = rs.getString(5);
			GuestBookVo vo = new GuestBookVo();
			vo.setNo(no);
			vo.setName(name);
			vo.setPassword(password);
			vo.setMessage(message);
			vo.setDate(date);;
			list.add(vo);
		}
		// 5. 자원정리
		if (rs != null) {
			rs.close();
		}
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
		return list;
	}

}
