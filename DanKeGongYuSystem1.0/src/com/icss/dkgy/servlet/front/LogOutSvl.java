package com.icss.dkgy.servlet.front;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * �˳���¼ �����ص�¼����
 * Servlet implementation class LogOutSvl
 */
public class LogOutSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public LogOutSvl() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  int flag =0; 
		  HttpSession session = request.getSession(); //��ȡsession����
		  session.invalidate(); //�ỰʧЧ����
		  flag =1;
//		  request.setAttribute("msg", "�Ѿ��˳������µ���");
		  
		  response.getWriter().print(flag);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
