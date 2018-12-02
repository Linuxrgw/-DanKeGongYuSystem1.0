package com.icss.dkgy.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class CharacterFilter
 */
public class CharacterFilter implements Filter {

    public CharacterFilter() {
        
    }
    //�÷������������ٹ���������ǰ������
	public void destroy() {
	
	}
    
	//���������ص�ҵ������
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		 ((HttpServletRequest)request).setCharacterEncoding("utf-8");  //�����������ת��
		 ((HttpServletResponse)response).setContentType("text/html;charset=utf-8");  //��Ӧ�����ı���ת��
		
		//�÷������Խ���ǰ���������Ӧ���ݵ��������ϵ���һ����Դ����������һ����������Ҳ������Ŀ����Դ��
		chain.doFilter(request, response);
	}
     
	//��ʼ���������ڷ���������ʱ��ִ��
	public void init(FilterConfig fConfig) throws ServletException {
	}

}
