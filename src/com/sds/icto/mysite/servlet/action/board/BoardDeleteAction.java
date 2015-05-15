package com.sds.icto.mysite.servlet.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.BoardDao;
import com.sds.icto.mysite.vo.BoardVo;
import com.sds.icto.web.Action;

public class BoardDeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		BoardVo vo = new BoardVo();
		BoardDao dao = new BoardDao();

		int no = Integer.parseInt(request.getParameter("no"));
		String password = request.getParameter("password");
		vo.setNo(no);
		vo.setPassword(password);
		
		if(password.equals(vo.getPassword())){
			dao.delete(no,password);
		}

		response.sendRedirect("/mysite/board");
	}

}
