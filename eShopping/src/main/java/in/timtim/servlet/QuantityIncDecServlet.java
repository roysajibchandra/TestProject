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

@WebServlet("/inc-dec")
public class QuantityIncDecServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		/* out.println("inc and dec"); */
		
		resp.setContentType("text/html; charset=UTF-8");		
		
		try(PrintWriter out = resp.getWriter();) {
			
			String action = req.getParameter("action");
			int id = Integer.parseInt(req.getParameter("id"));
			
			ArrayList<Cart> cart_list = (ArrayList<Cart>) req.getSession().getAttribute("cart-list");
			
			if(action != null && id>=1) {
				if(action.equals("inc")) {
					for(Cart c:cart_list) {
						if(c.getId() == id) {
							int quantitiy = c.getQuantity();
							quantitiy++;
							c.setQuantity(quantitiy);
							RequestDispatcher rd = req.getRequestDispatcher("cart.jsp");
							rd.include(req, resp);
						}
					}
				}
				if(action.equals("dec")) {
					for(Cart c:cart_list) {
						if(c.getId() == id && c.getQuantity()>1) {
							int quantitiy = c.getQuantity();
							quantitiy--;
							c.setQuantity(quantitiy);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
