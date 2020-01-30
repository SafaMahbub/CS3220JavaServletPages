package aFinal;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ShoppingCart")
public class ShoppingCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ShoppingCartBean> ShoppingCart = (ArrayList<ShoppingCartBean>) request.getSession().getAttribute("ShoppingCart");

		int wholePrice = 0;
		
		for(ShoppingCartBean entry : ShoppingCart){
			wholePrice += (entry.userQuantity * entry.item.price);
		}
		
		request.setAttribute("wholePrice", wholePrice);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/ShoppingCart.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
