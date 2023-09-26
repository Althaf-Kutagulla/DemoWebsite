

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/Login")
public class LoginServlet extends HttpServlet {
	

	
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username").toString();
		String password = request.getParameter("password").toString();
		
		DemoDao d1 = new DemoDao();
		boolean validLogin=false;
		try {
			 validLogin = d1.isValidLogin(username, password);
			 HttpSession session = request.getSession();
			 session.setAttribute("username", username);
			 if(validLogin) {
				 System.out.print(validLogin);
				 response.sendRedirect("welcome.jsp");
			 }else {
				 System.out.print(validLogin);
				 response.sendRedirect("login.jsp");
			 }
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		

		
		
	}

	

}
