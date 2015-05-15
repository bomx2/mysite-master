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
		Connection conn = getConnection();
		String sql = "insert into board values(BOARD_NO_SEQ.nextval,?,?,?,?,sysdate,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);

		pstmt.setString(1, vo.getTitle());
		pstmt.setString(2, vo.getContent());
		pstmt.setString(3, vo.getMember_no());
		pstmt.setString(4, vo.getMember_name());
		pstmt.setString(5, vo.getPassword());

		pstmt.executeUpdate();

		if (pstmt != null) {
			pstmt.close();
		}

		if (conn != null) {
			conn.close();
		}
	}
	
	public void delete() throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = "delete from board";
		stmt.executeUpdate(sql);
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	public void delete(int no, String password) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = "delete from board where no=? and password=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		pstmt.setString(2, password);
		pstmt.executeUpdate();
		if (stmt != null) {
			stmt.close();
		}
		if (conn != null) {
			conn.close();
		}
	}

	public List<BoardVo> fetchList() throws ClassNotFoundException,
			SQLException {
		List<BoardVo> list = new ArrayList<BoardVo>();
		Connection conn = getConnection();
		Statement stmt = conn.createStatement();
		String sql = "select no, title, content, member_no,	member_name, to_char(sysdate,'yyyy-mm-dd'), password from board";
		ResultSet rs = stmt.executeQuery(sql);
		while (rs.next()) {
			int no = rs.getInt(1);
			String title = rs.getString(2);
			String content = rs.getString(3);
			String member_no = rs.getString(4);
			String member_name = rs.getString(5);
			String date = rs.getString(6);
			String password = rs.getString(7);
			
			BoardVo vo = new BoardVo();
			vo.setNo(no);
			vo.setTitle(title);
			vo.setContent(content);
			vo.setMember_no(member_no);
			vo.setMember_name(member_name);
			vo.setDate(date);
			vo.setPassword(password);
			list.add(vo);
		}
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
		Connection conn = getConnection();
		String sql = "select no, title, content, member_no,	member_name, to_char(sysdate,'yyyy-mm-dd'), password from board where no=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			String title = rs.getString(2);
			String content = rs.getString(3);
			String member_no = rs.getString(4);
			String member_name = rs.getString(5);
			String date = rs.getString(6);
			String password = rs.getString(7);
			
			b = new BoardVo(no, title, content, member_no,	member_name, password, date);
		}
		if (rs != null) {
			rs.close();
		}
		if (pstmt != null) {
			pstmt.close();
		}
		if (conn != null) {
			conn.close();
		}
		return b;
	}
	
	public void update(BoardVo b) throws ClassNotFoundException, SQLException {
		Connection conn = getConnection();
		PreparedStatement pstmt = null;
		String sql = "update board set title=?, content=?, date=sysdate from board where no=?";
		pstmt.setString(1, b.getTitle());
		pstmt.setString(2, b.getContent());
		pstmt.setInt(3, b.getNo());
		pstmt.executeUpdate();
		
		if (pstmt != null) {
			pstmt.close();
		}

		if (conn != null) {
			conn.close();
		}
	}

}
