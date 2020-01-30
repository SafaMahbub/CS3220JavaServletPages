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

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Checkout")
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CheckoutController() {
		super();
	}

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


		request.getRequestDispatcher( "/WEB-INF/Checkout.jsp" ).forward(
				request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<ShoppingCartBean> ShoppingCart = (ArrayList<ShoppingCartBean>) request.getSession().getAttribute("ShoppingCart");

		String name = (String) request.getParameter( "name" ) == null ? "" : (String) request.getParameter( "name" );
		String email = (String) request.getParameter( "email" ) == null ? "" : (String) request.getParameter( "email" );

		String orderNumber;

		String emailError= "";
		String nameError = "";
		if(!(email.contains("@") && email.contains(".com")) || email == null || email == "") {
			emailError = "Invalid email";
			request.setAttribute("erroremailcheckout", emailError);
		}
		else{
			request.setAttribute("email", email);
		}
		if (name == null || name == "") {
			nameError = "No Name";
			request.setAttribute("errornamecheckout", nameError);
		}
		else {
			request.setAttribute("name", name);
		}
		if (emailError != "" || nameError != "") {
			doGet( request, response );
			return;
		}

		//No Errors
		int wholePrice = 0;

		for(ShoppingCartBean entry : ShoppingCart){
			wholePrice += (entry.userQuantity * entry.item.price);
		}

		Connection c = null;
		try
		{
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu15";
			String username = "cs3220stu15";
			String password = "x2QE26#w";

			c = DriverManager.getConnection( url, username, password );

			//////Add To Total Cost
			Statement stmt = c.createStatement();
			String sql = "insert into total_costs (total) values (?)";
			PreparedStatement pstmt = c.prepareStatement( sql );
			pstmt.setInt( 1, wholePrice );
			pstmt.executeUpdate();

			//////Find Last Order
			ResultSet rs = stmt.executeQuery( "select * from total_costs;" );
			String lastID= "";
			while( rs.next() )
			{
				lastID = rs.getString( "order_id" );
			}
			int addOrderNumber = -1;
			orderNumber = lastID;
			
			try{addOrderNumber = Integer.parseInt(orderNumber);}catch(Exception e){}

			/////////Update online_store_items
			rs = stmt.executeQuery( "select * from online_store_items;" );
			while( rs.next() )
			{
				OnlineStoreBean addItem = new OnlineStoreBean(rs.getString( "id" ), rs.getString( "name" ), rs.getString( "detail" ), rs.getString( "price" ),rs.getString( "quantity" ));
				for(ShoppingCartBean entry : ShoppingCart){
					if (addItem.getName().equals(entry.item.name)) {
						sql = "update online_store_items set quantity = ? where id = ?;";
						pstmt = c.prepareStatement( sql );
						pstmt.setInt( 1, (addItem.quantity - entry.userQuantity) );
						pstmt.setInt( 2, entry.item.id );
						pstmt.executeUpdate();	
						break;
					}

				}
			}

			///////////Insert to order_histories
			for(ShoppingCartBean entry : ShoppingCart){
				rs = stmt.executeQuery( "select * from online_store_items where id="+ entry.getItem().id +";" );
				while( rs.next() )
				{
					OnlineStoreBean addItem = new OnlineStoreBean(rs.getString( "id" ), rs.getString( "name" ), rs.getString( "detail" ), rs.getString( "price" ),rs.getString( "quantity" ));
					sql = "insert into order_histories (order_id, price, product_name, quantity) values (?,?,?,?);";
					pstmt = c.prepareStatement( sql );
					pstmt.setInt( 1, addOrderNumber );
					pstmt.setInt( 2, addItem.price);
					pstmt.setString( 3, addItem.name );
					pstmt.setInt( 4, entry.userQuantity);
					pstmt.executeUpdate();
				}
			}


		}
		catch( SQLException e )
		{
			throw new ServletException( e );
		}
		finally
		{
			try
			{
				if( c != null ) c.close();
			}
			catch( SQLException e )
			{
				throw new ServletException( e );
			}
		}


		request.setAttribute("orderNumber", orderNumber);
		request.getRequestDispatcher( "/WEB-INF/FinalOnlineStorePage.jsp" ).forward(
				request, response );	}

}
