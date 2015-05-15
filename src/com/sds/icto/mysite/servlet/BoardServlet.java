package com.sds.icto.mysite.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sds.icto.mysite.servlet.action.board.BoardDeleteAction;
import com.sds.icto.mysite.servlet.action.board.BoardDeleteFormAction;
import com.sds.icto.mysite.servlet.action.board.BoardInsertAction;
import com.sds.icto.mysite.servlet.action.board.BoardListAction;
import com.sds.icto.mysite.servlet.action.board.BoardReadAction;
import com.sds.icto.mysite.servlet.action.board.BoardUpdateAction;
import com.sds.icto.web.Action;

@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public BoardServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding( "utf-8" );
			String a = request.getParameter( "a" );
	
			Action action = null;
			
			if( "insert".equals( a ) ) {
				action = new BoardInsertAction();
			} else if("deleteform".equals( a )) {
				action = new BoardDeleteFormAction();
			} else if("delete".equals( a )) {
				action = new BoardDeleteAction();
			} else if("list".equals( a ) ) {
				action = new BoardListAction();
			} else if("read".equals( a ) ) {
				action = new BoardReadAction();
			} else if("update".equals( a ) ) {
				action = new BoardUpdateAction();
			} else{
				action = new BoardListAction();
			}
			action.execute(request, response);
		} catch( Exception ex ) {
			ex.printStackTrace();
		}
	}

}
