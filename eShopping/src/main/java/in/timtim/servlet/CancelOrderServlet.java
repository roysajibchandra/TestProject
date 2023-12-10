package in.timtim.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import in.timtim.DAO.OrderDao;
import in.timtim.DB.DBConnect;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cancel-order")
public class CancelOrderServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=UTF-8");
		
		try(PrintWriter out = resp.getWriter()) {
			
			out.print("Cancel the Order from Servlet!");
			
			String id = req.getParameter("id");
			
			if( id != null) {
				OrderDao orderDao = new OrderDao(DBConnect.getcon());
				orderDao.cancelOrder(Integer.parseInt(id));
				
				
			}
			RequestDispatcher rd = req.getRequestDispatcher("orders.jsp");
			rd.include(req, resp);
//			resp.sendRedirect("orders.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
