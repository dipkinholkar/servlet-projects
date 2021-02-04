package HelloApp;

import java.io.IOException;
import java.io.PrintWriter;

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
	
		try {
		PrintWriter pw=response.getWriter();
	
		response.setContentType("text/html");
	
		String fname=request.getParameter("firstname");
		String lname=request.getParameter("lastname");
		String gen=request.getParameter("gender");
		
		pw.println("FirstName:"+fname);
		pw.println("LastName :"+lname);
		pw.println("Gender :"+gen);
		
	
		}
		catch(Exception e) {
		
			System.out.print(e);
		}
		}
	
	}

