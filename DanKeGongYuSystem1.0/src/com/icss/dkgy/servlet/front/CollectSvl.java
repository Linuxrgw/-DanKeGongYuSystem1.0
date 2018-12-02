package com.icss.dkgy.servlet.front;

import java.awt.Window;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.dkgy.biz.RoomBiz;

/**
 * Servlet implementation class CollectSvl
 * ��ӵ��ղ�
 */
public class CollectSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public CollectSvl() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String roomid = request.getParameter("roomid");//����ҳ��roomid��ѯ
        String phone = (String)request.getSession().getAttribute("phone");
        int flag = 0;
		if (phone!=null&&!"".equals(phone)) {
			System.out.println(phone + "phone");
			RoomBiz biz = new RoomBiz(); //����biz����
			flag = biz.collectRoom(Integer.parseInt(roomid),phone);
		}
		response.getWriter().print(flag);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
