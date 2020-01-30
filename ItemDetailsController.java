package aFinal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import todo.ToDoEntry;

@WebServlet("/Details")
public class ItemDetailsController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init( ServletConfig config ) throws ServletException
	{
		super.init( config );

		try
		{
			Class.forName( "com.mysql.jdbc.Driver" );
		}
		catch( ClassNotFoundException e )
		{
			throw new ServletException( e );
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id") == null ? "" : request.getParameter("id");
		int detailId = -1;

		if(!id.equals(""))
			detailId = Integer.parseInt(id);

		List<OnlineStoreBean> Inventory = (ArrayList<OnlineStoreBean>) request.getSession().getAttribute("Inventory");
		List<ShoppingCartBean> ShoppingCart = (ArrayList<ShoppingCartBean>) request.getSession().getAttribute("ShoppingCart");


		String add = request.getParameter("add") == null ? "" : request.getParameter("add");

		OnlineStoreBean item = new OnlineStoreBean();

		for(OnlineStoreBean check: Inventory){
			if(check.id == detailId)
				item = check;
		}


		//If user wants to add the item
		if(!add.equals("")){
			ShoppingCartBean updateItem = null;
			boolean exists = false;
			for(ShoppingCartBean check: ShoppingCart){
				if(check.item.id == detailId){
					exists = true;
					updateItem = check;
					if( updateItem.userQuantity < item.quantity)
						check.setUserQuantity(check.getUserQuantity()+ 1);
				}
			}
			if(!exists){
				ShoppingCart.add(new ShoppingCartBean(item));
			}
			request.getSession().setAttribute( "ShoppingCart", ShoppingCart );
		}
		
		//Shopping Cart Items Count
		int numberOfItemsInShoppingCart = 0;
		for(ShoppingCartBean check: ShoppingCart){
			numberOfItemsInShoppingCart += check.getUserQuantity();
		}


		//Directing to the Details Page
		request.setAttribute( "item", item );
		request.setAttribute( "numberOfItemsInShoppingCart", numberOfItemsInShoppingCart );
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Details.jsp");
		dispatcher.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
