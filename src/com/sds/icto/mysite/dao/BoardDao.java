package com.sds.icto.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sds.icto.mysite.vo.BoardVo;

public class BoardDao {

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

	public void insert(BoardVo vo) throws ClassNotFoundException,
			SQLException {
		// Connection 생성
		Connection conn = getConnection();

		// 2. Statement(SQL) 준비
		String sql = "insert into board values(BOARD_NO_SEQ.nextval,?,?,?,?,sysdate)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		// 3.binding
		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getMember_no());
		pstmt.setString(4, vo.getMember_name());

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
		String sql = "delete from board";
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
		String sql = "delete from board where no=? and password=?";
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

	public List<BoardVo> fetchList() throws ClassNotFoundException,
			SQLException {
		System.out.println("1");
		List<BoardVo> list = new ArrayList<BoardVo>();
		// 1. Connection 생성
		Connection conn = getConnection();
		// 2. statment 생성
		Statement stmt = conn.createStatement();
		// 3. SQL문 실행
		String sql = "select no, title, content, member_no,	member_name, password, to_char(sysdate,'yyyy-mm-dd') from board";
		ResultSet rs = stmt.executeQuery(sql);
		System.out.println("2");
		// 4. 결과 처리
		while (rs.next()) {
			int no = rs.getInt(1);
			String title = rs.getString(2);
			String content = rs.getString(3);
			String member_no = rs.getString(4);
			String member_name = rs.getString(5);
			String password = rs.getString(6);
			String date = rs.getString(7);
			System.out.println("3");
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setMember_no(member_no);
			vo.setMember_name(member_name);
			vo.setPassword(password);
			vo.setDate(date);
			list.add(vo);
			System.out.println("여기까지옴"+list);
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
	
	public BoardVo read(int no) throws ClassNotFoundException, SQLException {
		BoardVo b = null;
		// 1. Connection 생성
		Connection conn = getConnection();
		// 2. statment 생성
		Statement stmt = conn.createStatement();
		// 3. query 실행
		String sql = "select no, title, content, member_no,	member_name, password, to_char(sysdate,'yyyy-mm-dd') from board where no=?";
		ResultSet rs = stmt.executeQuery(sql);
		// 4. 결과 처리
		while (rs.next()) {
			String title = rs.getString(2);
			String content = rs.getString(3);
			String member_no = rs.getString(4);
			String member_name = rs.getString(5);
			String password = rs.getString(6);
			String date = rs.getString(7);
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setMember_no(member_no);
			vo.setMember_name(member_name);
			vo.setPassword(password);
			vo.setDate(date);
			b = new BoardVo(no, title, content, member_no,	member_name, password, date);
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
		return b;
	}
	
	public void update(BoardVo b) throws ClassNotFoundException, SQLException {
		// 1. Connection 생성
		Connection conn = getConnection();
		// 2. statment 생성
		PreparedStatement st = null;
		// 3. query 실행
		String sql = "update board set title=?, content=?, date=sysdate from board where no=?";
		st.setString(1, b.getTitle());
		st.setString(2, b.getContent());
		st.setInt(3, b.getNo());
		st.executeUpdate();
	}

}
