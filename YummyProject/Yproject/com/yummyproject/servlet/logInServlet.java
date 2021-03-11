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
		//取得使用者輸入資訊
		request.setCharacterEncoding("UTF-8");
		//防止非法登入    得到session
        HttpSession httpSession=request.getSession(true);
        //修改session的存在時間為20s
        httpSession.setMaxInactiveInterval(20);
        httpSession.setAttribute("pass","ok");
        //獲取使用者名稱的賬號和密碼
		String account =request.getParameter("account");
		String password =request.getParameter("password");
		System.out.println(account);
		System.out.println(password);

        //得到提交的驗證碼
        String code = request.getParameter("code");
        HttpSession session = request.getSession();
        String randStr = (String) session.getAttribute("randStr");
        response.setCharacterEncoding("UTF-8");

        //當賬號資訊和驗證碼輸入正確時才可以訪問
		//使用 DAPImpl find方法進行驗證
        YummyDAOImpl cd = new YummyDAOImpl();
        YummyBean cus = new YummyBean();
		cus.setAccount(account);
		cus.setPassword(password);
		cus = cd.FindUser(cus);
		session.setAttribute("customer", cus);
		//上面接住user輸入 並使用JDBC select 找Account & Password都相符的

		if(cus.getAccount()== null) {
			//如果cus.getName()為null 表示找不到相符的資料 直接跳轉失敗頁面
			System.out.println("資料null的失敗出現");
			request.getRequestDispatcher("com.yproject.jsp/TryAgain.jsp").forward(request, response);

		}else {
            	if(code.equals(randStr)) {
	               // String keep = request.getParameter("keep");
	                //勾選了兩週內免登陸選項
//		                if (keep != null) {
//		                    //建立cookie
//		                    Cookie cookie1 = new Cookie("username", account);
//		                    Cookie cookie2 = new Cookie("password", password);
//		                    //設定關聯路徑
//		                    cookie1.setPath(request.getContextPath());
//		                    cookie2.setPath(request.getContextPath());
//		                    //設定cookie的消亡時間  兩週
//		                    cookie1.setMaxAge(2 * 7 * 24 * 60 * 60);
//		                    cookie2.setMaxAge(2 * 7 * 24 * 60 * 60);
//		                    //把cookie資訊寫給瀏覽器
//		                    response.addCookie(cookie1);
//		                    response.addCookie(cookie2);
//		                    
//		                }
//		                request.setAttribute("customer", yb2);
			    		//request.getRequestDispatcher("/com.yproject.jsp/PersonalPage.jsp").forward(request, response);
			    		response.sendRedirect("com.yproject.jsp/PersonalPage.jsp");

            	}else {
            		System.out.println("驗證碼錯誤");
            		//request.getRequestDispatcher("/com.yproject.jsp/TryAgain.jsp").forward(request, response);
            		response.sendRedirect("com.yproject.jsp/TryAgain.jsp");
            	}
            }
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
