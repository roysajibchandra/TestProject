package in.timtim.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

import in.timtim.model.Cart;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/remove-cart")

public class RemoveFromCartServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=UTF-8");
		try(PrintWriter out = resp.getWriter()) {
			
			String id = req.getParameter("id");
			
			if(id!=null) {
				ArrayList<Cart> cart_list = (ArrayList<Cart>) req.getSession().getAttribute("cart-list");
				
				if(cart_list != null) {
					for(Cart c:cart_list) {
						if(c.getId() == Integer.parseInt(id)) {
							cart_list.remove(cart_list.indexOf(c));
							break;
						}
					}
					RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
					rd.include(req, resp);
				}
			}
			else {
				RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
				rd.include(req, resp);
			}
			/* out.print("id "+id); */
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
