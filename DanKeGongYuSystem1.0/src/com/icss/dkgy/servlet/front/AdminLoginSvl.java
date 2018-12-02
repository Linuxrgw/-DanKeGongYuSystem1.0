package com.icss.dkgy.servlet.front;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.icss.dkgy.biz.UserBiz;
import com.icss.dkgy.entity.AdminEntity;

import redis.clients.jedis.Jedis;

/**
 * Servlet implementation class AdminLoginSvl
 */
public class AdminLoginSvl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Jedis jedis = new Jedis("127.0.0.1", 6379);  
	public boolean visitCount(String ip){
		String value = jedis.get(ip);
		if (value == null) {  
			//��ʼ��ʱ����IP���ʴ���Ϊ1  
			jedis.set(ip, "1");  
			//����IP������ʱ��Ϊ60�룬60����IP�ķ��ʴ����ɳ������  
			jedis.expire(ip, 60);  
		} else {  
			int parseInt = Integer.parseInt(value);  
			//���60����IP�ķ��ʴ�������2������false
			if (parseInt > 2) {  
				return false;  
			} else {
				//���û��3�Σ���������  
				jedis.incr(ip);  
			}  
		}  
		return true;  

		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String name	= request.getParameter("name");
	    String pwd = request.getParameter("pwd");
	    
	    if(visitCount(request.getRemoteHost())){
	    UserBiz biz = new UserBiz();    
	    AdminEntity admin = biz.adminLogin(name,pwd);
	    //�ж�admin�Ƿ�������  û��--���ص�¼���沢������ʾmsg
	    if(admin == null){
	    	request.setAttribute("msg", "�û������������");
	    	request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
	    }else{
	    	//�жϹ���Ա�˺�״̬�Ƿ�Ϊ'0'�ɵ�½
	    	if("0".equals(admin.getStatus())){
	    		HttpSession session = request.getSession();//����session����
				session.setAttribute("adminname", admin.getAd_name());
				session.setAttribute("adminid", admin.getAd_id());
				request.getRequestDispatcher("backIndex.jsp").forward(request, response); // ����ת����loginҳ��
	    	}else{
	    		request.setAttribute("msg", "�����˺��ѱ���");
		    	request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
	    	}
	    }
	    
	    }else{
			request.setAttribute("msg", "��������Ƶ�������Ժ�����");
			request.getRequestDispatcher("adminLogin.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
