package com.sds.icto.mysite.servlet.action.guestbook;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.dao.GuestBookDao;
import com.sds.icto.mysite.vo.GuestBookVo;
import com.sds.icto.web.Action;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response)
			throws SQLException, ClassNotFoundException, ServletException,
			IOException {
		GuestBookVo vo = new GuestBookVo();
		GuestBookDao dao = new GuestBookDao();

		int no = Integer.parseInt(request.getParameter("no"));
		String password = request.getParameter("password");
		
		vo.setNo(no);
		vo.setPassword(password);
		
		if(password.equals(vo.getPassword())){
			dao.delete(no,password);
			response.sendRedirect("/mysite/guestbook");
		}

	}

}
