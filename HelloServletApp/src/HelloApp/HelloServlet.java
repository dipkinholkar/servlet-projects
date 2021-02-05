package HelloApp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class HelloServlet
 */
@WebServlet("/HelloServlet")
public class HelloServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public HelloServlet() {
        
    System.out.println("constructor");
    
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
	
		System.out.println("servlet started...");
	}

	
	public void destroy() {
	
	System.out.println("Servlet destroyed...");
	}

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		PrintWriter pw=response.getWriter();
	
		response.setContentType("text/html");
	
		String fname=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		String gen=request.getParameter("gender");

		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		String query="insert into register values('"+fname+"' ,'"+lname+"' ,'"+gen+"')";
		
		Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","dipak","DIPAK");
		
		Statement stat=con.createStatement();
		
		ResultSet rs=stat.executeQuery(query);
		
		if(rs!=null)
		{
			 response.sendRedirect("success.html"); 
		}else
		{
			 response.sendRedirect("fail.html"); 	
		}
		
		
		
		con.close();
		stat.close();
		rs.close();
		}
		catch(Exception e) {
		
			System.out.print(e);
		}
		
		

		
	}
	}