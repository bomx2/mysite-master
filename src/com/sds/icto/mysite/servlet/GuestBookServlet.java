package com.sds.icto.mysite.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.servlet.action.guestbook.DeleteAction;
import com.sds.icto.mysite.servlet.action.guestbook.DeleteFormAction;
import com.sds.icto.mysite.servlet.action.guestbook.InsertAction;
import com.sds.icto.mysite.servlet.action.guestbook.ListAction;
import com.sds.icto.web.Action;

@WebServlet("/guestbook")
public class GuestBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public GuestBookServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try{
			request.setCharacterEncoding( "utf-8" );
			String a = request.getParameter( "a" );
			
			Action action = null;
			
			if( "insert".equals( a ) ) {
				action = new InsertAction();
			} else if("deleteform".equals( a )) {
				action = new DeleteFormAction();
			} else if("delete".equals( a )) {
				action = new DeleteAction();
			} else if("list".equals( a ) ) {
				action = new ListAction();
			} else{
				action = new ListAction();
			}
			action.execute( request, response );

		} catch ( Exception ex ) {
			ex.printStackTrace();
		}
	}

}
