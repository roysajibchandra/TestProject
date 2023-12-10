package in.timtim.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import in.timtim.DAO.userDao;
import in.timtim.DB.DBConnect;
import in.timtim.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/user-login")
public class Login extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=UTF-8");
		
		try (PrintWriter out = resp.getWriter()) {

			String email = req.getParameter("email");
			String password = req.getParameter("password");
//			out.print(email+password);
			
			userDao udao = new userDao(DBConnect.getcon());
			User user = udao.userLogin(email, password);
			
			if(user != null) {
				/* out.print("success"); */
				req.getSession().setAttribute("auth", user);
				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				rd.include(req, resp);
			}
			else {
				out.print("failed");
				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
				rd.include(req, resp);
			}

		}
				catch (Exception e) {
					e.printStackTrace();
			}
				// TODO: handle exception
			}

		

}
