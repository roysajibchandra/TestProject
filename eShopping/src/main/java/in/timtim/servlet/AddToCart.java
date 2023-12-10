package in.timtim.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import in.timtim.model.*;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/addToCart")
public class AddToCart extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html; charset=UTF-8");

		try (PrintWriter out = resp.getWriter()) {

			ArrayList<Cart> cartList = new ArrayList<>();

			int id = Integer.parseInt(req.getParameter("id"));

			Cart cm = new Cart();
			cm.setId(id);
			cm.setQuantity(1);

			HttpSession session = req.getSession();
			ArrayList<Cart> cart_list = (ArrayList<Cart>) session.getAttribute("cart-list");

			if (cart_list == null) {
				cartList.add(cm);
				session.setAttribute("cart-list", cartList);

				/* out.println("session created and added the list"); */
				RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
				rd.forward(req, resp);
			} else {
				/* out.println("Cart List Exits"); */
				cartList = cart_list;
				boolean exist = false;

				for (Cart c : cart_list) {
					if (c.getId() == id) {
						exist = true;
						/* out.println("Product exist"); */
						out.println(
								"<h3 style='color:crimson; text-align:center;'>Item already exist in Cart.<a href='cart.jsp'>Go to Cart Page</a></h3>");
					}

				}

				if (!exist) {
					cartList.add(cm);
					out.println("product added");
					RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
					rd.forward(req, resp);
				}
			}

			/*
			 * for (Cart c : cart_list) { out.println(c.getId()); }
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
