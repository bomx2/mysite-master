package com.sds.icto.mysite.servlet.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.BoardDao;
import com.sds.icto.mysite.vo.BoardVo;
import com.sds.icto.web.Action;

public class BoardInsertAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
	
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String member_no = request.getParameter("member_no");
		String member_name = request.getParameter("member_name");
		String password = request.getParameter("password");
		
		BoardVo vo = new BoardVo();
		vo.setTitle(title);
		vo.setContent(content);
		vo.setMember_no(member_no);
		vo.setMember_name(member_name);
		vo.setPassword(password);

		BoardDao dao = new BoardDao();
		dao.insert(vo);

		response.sendRedirect("/mysite/board");
	}

}
