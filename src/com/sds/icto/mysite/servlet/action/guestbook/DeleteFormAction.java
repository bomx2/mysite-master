package com.sds.icto.mysite.servlet.action.guestbook;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.GuestBookDao;
import com.sds.icto.mysite.vo.GuestBookVo;
import com.sds.icto.web.Action;
import com.sds.icto.web.WebUtil;

public class DeleteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		GuestBookDao dao = new GuestBookDao();
		GuestBookVo vo = new GuestBookVo();
		
		int no = Integer.parseInt(request.getParameter("no"));
		vo.setNo(no);
		GuestBookVo view = dao.read(no);
		request.setAttribute("reading", view);
		WebUtil.forward( "/views/guestbook/deleteform.jsp" , request, response);
	}
}
