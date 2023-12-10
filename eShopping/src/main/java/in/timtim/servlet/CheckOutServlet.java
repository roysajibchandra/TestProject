package in.timtim.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import in.timtim.DAO.OrderDao;
import in.timtim.DB.DBConnect;
import in.timtim.model.Cart;
import in.timtim.model.Order;
import in.timtim.model.User;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/check-out")
public class CheckOutServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try(PrintWriter out = resp.getWriter()) {
//			out.print("Check out Servlet!");
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			Date date = new Date(0000, 00, 00);		
			
			ArrayList<Cart> cart_list = (ArrayList<Cart>) req.getSession().getAttribute("cart-list");
			
			User auth = (User) req.getSession().getAttribute("auth");
			
			if(cart_list != null && auth!=null) {
				for(Cart c:cart_list) {
					Order order = new Order();
					
					order.setId(c.getId());
					order.setUid(auth.getId());
					order.setQuantity(c.getQuantity());
					order.setDate(formatter.format(date));
					
					OrderDao oDao = new OrderDao(DBConnect.getcon());
					boolean result = oDao.insertOrder(order);
					if(!result) break;
				}
				cart_list.clear();
				
//				RequestDispatcher rd = req.getRequestDispatcher("orders.jsp");
//				rd.include(req, resp);
				resp.sendRedirect("orders.jsp");
				
			}
			else {
				if(auth==null)
				{
//					RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
//					rd.include(req, resp);
					resp.sendRedirect("login.jsp");
				}
				else {
//					RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
//					rd.include(req, resp);
					resp.sendRedirect("cart.jsp");
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
