package aFinal;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
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

@WebServlet("/Store")
public class StoreController extends HttpServlet {
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
		List<OnlineStoreBean> Inventory = new ArrayList<OnlineStoreBean>();

		List<ShoppingCartBean> ShoppingCart = (ArrayList<ShoppingCartBean>) (request.getSession().getAttribute("ShoppingCart") ) == null ? new ArrayList<ShoppingCartBean>() : (ArrayList<ShoppingCartBean>) (request.getSession().getAttribute("ShoppingCart") );

		String id = request.getParameter("id") == null ? "" : request.getParameter("id");
		int addId = -1;

		if(!id.equals(""))
			addId = Integer.parseInt(id);


		Connection c = null;
		try{
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu15";
			String username = "cs3220stu15";
			String password = "x2QE26#w";

			c = DriverManager.getConnection( url, username, password );
			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "select * from online_store_items" );

			while( rs.next() ){
				OnlineStoreBean entry = new OnlineStoreBean( rs.getInt( "id" ), rs.getString( "name" ), rs.getString("detail"), rs.getInt( "price" ), rs.getInt( "quantity" ) );
				if(entry.getQuantity() >= 1){
					Inventory.add( entry );
				} 
			}
		}catch( SQLException e )
		{ throw new ServletException( e );}
		finally{
			try{
				if( c != null ) c.close();
			}catch( SQLException e ){
				throw new ServletException( e );
			}
		}

		//Add Item
		if(!id.equals("") && addId > 0){

			OnlineStoreBean item = new OnlineStoreBean();

			for(OnlineStoreBean check: Inventory){
				if(check.id == addId)
					item = check;
			}

			ShoppingCartBean updateItem = null;
			boolean exists = false;
			for(ShoppingCartBean check: ShoppingCart){
				if(check.item.id == addId){
					exists = true;
					updateItem = check;
					if( updateItem.userQuantity < item.quantity)
						check.setUserQuantity(check.getUserQuantity()+ 1);
				}
			}
			if(!exists){
				ShoppingCart.add(new ShoppingCartBean(item));
			}
		}
		
		//Shopping Cart Items Count
		int numberOfItemsInShoppingCart = 0;
		for(ShoppingCartBean check: ShoppingCart){
			numberOfItemsInShoppingCart += check.getUserQuantity();
		}
		
		
		
		request.setAttribute( "numberOfItemsInShoppingCart", numberOfItemsInShoppingCart );
		request.getSession().setAttribute( "Inventory", Inventory );
		request.getSession().setAttribute( "ShoppingCart", ShoppingCart );

		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Store.jsp");
		dispatcher.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}


}
