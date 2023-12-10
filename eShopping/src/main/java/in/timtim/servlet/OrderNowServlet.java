package in.timtim.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.*;

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

@WebServlet("/order-now")
public class OrderNowServlet extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		try (PrintWriter out = resp.getWriter()) {

			/* out.print("this buy now servlet"); */

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			Date date = new Date(0000, 00, 00);

			User auth = (User) req.getSession().getAttribute("auth");

			if (auth != null) {

				String productId = req.getParameter("id");
				int productQuantity = Integer.parseInt(req.getParameter("quantity"));

				if (productQuantity <= 0) {
					productQuantity = 1;
				}

				Order orderModel = new Order();

				orderModel.setId(Integer.parseInt(productId));
				orderModel.setUid(auth.getId());
				orderModel.setQuantity(productQuantity);
				orderModel.setDate(formatter.format(date));

				OrderDao orderDao = new OrderDao(DBConnect.getcon());
				boolean result = orderDao.insertOrder(orderModel);

				if (result) {
					ArrayList<Cart> cart_list = (ArrayList<Cart>) req.getSession().getAttribute("cart-list");

					if (cart_list != null) {
						for (Cart c : cart_list) {
							if (c.getId() == Integer.parseInt(productId)) {
								cart_list.remove(cart_list.indexOf(c));
								break;
							}
						}

					}
//					RequestDispatcher rd = req.getRequestDispatcher("orders.jsp");
//					rd.include(req, resp);
					resp.sendRedirect("orders.jsp");
				} else {
					out.print("order failed");
				}

			} else {
//				RequestDispatcher rd = req.getRequestDispatcher("login.jsp");
//				rd.include(req, resp);
				resp.sendRedirect("login.jsp");
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
