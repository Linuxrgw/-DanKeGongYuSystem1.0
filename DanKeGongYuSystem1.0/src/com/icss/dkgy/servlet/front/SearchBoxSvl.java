package com.icss.dkgy.servlet.front;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.dkgy.biz.RoomBiz;
import com.icss.dkgy.entity.RoomEntity;

/**
 * Servlet implementation class SearchBoxSvl
 * 
 * ��������
 */
public class SearchBoxSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchBoxSvl() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter("text");
		
		System.out.println(text+"text����");
		RoomBiz biz = new RoomBiz();
		ArrayList<RoomEntity> rooms = biz.searchText(text);//����biz�㣬�õ������ϼ�ͼ�����Ϣ
		request.setAttribute("rooms", rooms);
		request.getRequestDispatcher("bj.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
