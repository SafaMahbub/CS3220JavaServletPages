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


@WebServlet("/Inventory")
public class InventoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public InventoryController() {
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
		List<OnlineStoreBean> Inventory = new ArrayList<OnlineStoreBean>();
		Connection c = null;

		String deleteID = (String) request.getParameter( "deleteID" );

		try
		{
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu15";
			String username = "cs3220stu15";
			String password = "x2QE26#w";
			c = DriverManager.getConnection( url, username, password );

			PreparedStatement pstmt;
			if (deleteID != null ) {
				String sqlDelete = "delete from online_store_items where id = ?";
				pstmt = c.prepareStatement( sqlDelete );
				pstmt.setInt(1, Integer.parseInt(deleteID));
				pstmt.executeUpdate();
			}

			Statement stmt = c.createStatement();
			ResultSet rs = stmt.executeQuery( "select * from online_store_items;" );
			while( rs.next() )
			{

				OnlineStoreBean addItem = new OnlineStoreBean(rs.getString( "id" ), rs.getString( "name" ), rs.getString( "detail" ), rs.getString( "price" ),rs.getString( "quantity" ));
				Inventory.add(addItem);
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
		request.setAttribute("Inventory", Inventory);
		request.getRequestDispatcher( "/WEB-INF/Inventory.jsp" ).forward(
				request, response );
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String addName = (String) request.getParameter( "addName" ) == null ? "" : (String) request.getParameter( "addName" );
		String addPrice = (String) request.getParameter( "addPrice" ) == null ? "" : (String) request.getParameter( "addPrice" );
		String addDetail = (String) request.getParameter( "addDetail" ) == null ? "" : (String) request.getParameter( "addDetail" );
		String addQuantity = (String) request.getParameter( "addQuantity" ) == null ? "" : (String) request.getParameter( "addQuantity" );

		String deleteID = (String) request.getParameter( "deleteID" );

		String error= "";
		if (addName == "") {
			error = "No Name";
			request.setAttribute("errorName", error);
		}
		if (addPrice == "") {
			error = "No Price";
			request.setAttribute("errorPrice", error);
		}
		if (addDetail == "") {
			error = "No Detail";
			request.setAttribute("errorDetail", error);
		}
		if (addQuantity == "") {
			error = "No Quantity";
			request.setAttribute("errorQuantity", error);
		}
		if (error != "") {
			doGet( request, response );
			return;
		}
		Connection c = null;
		try
		{
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu15";
			String username = "cs3220stu15";
			String password = "x2QE26#w";

			c = DriverManager.getConnection( url, username, password );
			Statement stmt = c.createStatement();

			PreparedStatement pstmt;

			if (addName != null || addName != "") {
				String sqlAdd = "insert into online_store_items (name, price, detail, quantity) values (?, ?, ?, ?)";
				pstmt = c.prepareStatement( sqlAdd );
				pstmt.setString( 1, addName );
				pstmt.setString( 2, addPrice );
				pstmt.setString( 3, addDetail );
				pstmt.setString( 4, addQuantity );
				pstmt.executeUpdate();
			}

			if (deleteID != null ) {
				String sqlDelete = "delete from online_store_items where id = ?";
				pstmt = c.prepareStatement( sqlDelete );
				pstmt.setInt(1, (int)(Integer.parseInt(deleteID) ) );
				pstmt.executeUpdate();
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
		doGet( request, response );
	}

}
