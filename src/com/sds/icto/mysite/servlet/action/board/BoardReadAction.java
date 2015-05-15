package com.sds.icto.mysite.servlet.action.board;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.BoardDao;
import com.sds.icto.mysite.vo.BoardVo;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class BoardReadAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) 
		throws SQLException, ClassNotFoundException, ServletException, IOException {
		BoardDao dao = new BoardDao();
		BoardVo vo = new BoardVo();
		
		int no = Integer.parseInt(request.getParameter("no"));
		vo.setNo(no);
		BoardVo view = dao.read(no);
		request.setAttribute("reading", view);
		WebUtil.forward( "/views/board/readform.jsp", request, response);
	}

}
