package com.yummyproject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yummyproject.Bean.YummyBean;
import com.yummyproject.Dao.YummyDAOImpl;


@WebServlet("/logInServlet")
public class logInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//���o�ϥΪ̿�J��T
		request.setCharacterEncoding("UTF-8");
		//����D�k�n�J    �o��session
        HttpSession httpSession=request.getSession(true);
        //�ק�session���s�b�ɶ���20s
        httpSession.setMaxInactiveInterval(20);
        httpSession.setAttribute("pass","ok");
        //����ϥΪ̦W�٪��㸹�M�K�X
		String account =request.getParameter("account");
		String password =request.getParameter("password");
		System.out.println(account);
		System.out.println(password);

        //�o�촣�檺���ҽX
        String code = request.getParameter("code");
        HttpSession session = request.getSession();
        String randStr = (String) session.getAttribute("randStr");
        response.setCharacterEncoding("UTF-8");

        //��㸹��T�M���ҽX��J���T�ɤ~�i�H�X��
		//�ϥ� DAPImpl find��k�i������
        YummyDAOImpl cd = new YummyDAOImpl();
        YummyBean cus = new YummyBean();
		cus.setAccount(account);
		cus.setPassword(password);
		cus = cd.FindUser(cus);
		session.setAttribute("customer", cus);
		//�W������user��J �èϥ�JDBC select ��Account & Password���۲Ū�

		if(cus.getAccount()== null) {
			//�p�Gcus.getName()��null ��ܧ䤣��۲Ū���� �������ॢ�ѭ���
			System.out.println("���null�����ѥX�{");
			request.getRequestDispatcher("com.yproject.jsp/TryAgain.jsp").forward(request, response);

		}else {
            	if(code.equals(randStr)) {
	               // String keep = request.getParameter("keep");
	                //�Ŀ�F��g���K�n���ﶵ
//		                if (keep != null) {
//		                    //�إ�cookie
//		                    Cookie cookie1 = new Cookie("username", account);
//		                    Cookie cookie2 = new Cookie("password", password);
//		                    //�]�w���p���|
//		                    cookie1.setPath(request.getContextPath());
//		                    cookie2.setPath(request.getContextPath());
//		                    //�]�wcookie�����`�ɶ�  ��g
//		                    cookie1.setMaxAge(2 * 7 * 24 * 60 * 60);
//		                    cookie2.setMaxAge(2 * 7 * 24 * 60 * 60);
//		                    //��cookie��T�g���s����
//		                    response.addCookie(cookie1);
//		                    response.addCookie(cookie2);
//		                    
//		                }
//		                request.setAttribute("customer", yb2);
			    		//request.getRequestDispatcher("/com.yproject.jsp/PersonalPage.jsp").forward(request, response);
			    		response.sendRedirect("com.yproject.jsp/PersonalPage.jsp");

            	}else {
            		System.out.println("���ҽX���~");
            		//request.getRequestDispatcher("/com.yproject.jsp/TryAgain.jsp").forward(request, response);
            		response.sendRedirect("com.yproject.jsp/TryAgain.jsp");
            	}
            }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
