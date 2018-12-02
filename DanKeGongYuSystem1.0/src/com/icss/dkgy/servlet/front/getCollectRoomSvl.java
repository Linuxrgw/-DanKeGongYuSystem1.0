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

/**
 * Servlet implementation class getCollectRoomSvl
 * ��ȡ�û��ղصķ�Դ��Ϣ
 */
public class getCollectRoomSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public getCollectRoomSvl() {
        super();

    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = (String)request.getSession().getAttribute("phone");
		System.out.println("phone"+phone);
		RoomBiz biz = new RoomBiz();
		ArrayList<RoomEntity> rooms = biz.findCollectRoom(phone);
		//�Ѽ���ת����json����--ajax��ʽ���󣬷���json��������
		JSONArray json = JSONArray.fromObject(rooms);
		PrintWriter out = response.getWriter();
		out.print(json);
		System.out.println("123456"+json);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
