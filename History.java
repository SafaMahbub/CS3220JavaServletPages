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


@WebServlet("/History")
public class History extends HttpServlet {
	private static final long serialVersionUID = 1L;


	public History() {
		super();
		// TODO Auto-generated constructor stub
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
		List<HistoryBean> History = new ArrayList<HistoryBean>();

		Connection c = null;
		try{
			String url = "jdbc:mysql://cs3.calstatela.edu/cs3220stu15";
			String username = "cs3220stu15";
			String password = "x2QE26#w";

			c = DriverManager.getConnection( url, username, password );
			Statement stmt = c.createStatement();

			ResultSet rs = stmt.executeQuery( "select * from total_costs" );
			List<Integer> orderNumber = new ArrayList<Integer>();
			while( rs.next() ){
				int number = rs.getInt( "order_id" );
				orderNumber.add(number); 
				HistoryBean adding = new HistoryBean();
				adding.setTotal(rs.getString( "total" ));
				adding.setOrderID(number);
				History.add(adding);
			}


			
			for(int i = 0; i < orderNumber.size(); i++) {
				String order = "";
				rs = stmt.executeQuery( "select * from order_histories where order_id = "+ orderNumber.get(i )+"" );
				while( rs.next() ){
					order += rs.getString("product_name") + "( " + rs.getInt("quantity") + " ) \n";
				}

				History.get(i).setOrder(order);
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


		request.getSession().setAttribute( "History", History );
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/History.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
