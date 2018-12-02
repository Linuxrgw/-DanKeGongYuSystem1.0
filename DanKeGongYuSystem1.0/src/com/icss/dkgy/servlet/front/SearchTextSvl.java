package com.icss.dkgy.servlet.front;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.dkgy.biz.RoomBiz;
import com.icss.dkgy.entity.RoomEntity;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * Servlet implementation class SearchTextSvl
 * �������������ݲ�ѯ��Դ��Ϣ
 */
public class SearchTextSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public SearchTextSvl() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String text = request.getParameter("text");
		
		
		RoomBiz biz = new RoomBiz();
		ArrayList<RoomEntity> rooms = biz.searchText(text);
		//�Ѽ���ת����json����--ajax��ʽ���󣬷���json��������
		JSONArray json = JSONArray.fromObject(rooms);
		PrintWriter out = response.getWriter();
		out.print(json);
		
			System.out.println("1"+json);
		
		
		
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}



}
