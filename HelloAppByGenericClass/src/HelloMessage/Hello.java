package HelloMessage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


/**
 * Servlet implementation class Hello
 */
@WebServlet("/Hello")
public class Hello extends GenericServlet {

	static PrintWriter pw;
	
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		
		res.setContentType("text/html");
		pw=res.getWriter();
		
		pw.print("<h1>hello</h1>");
		
		
	}
	
	

}
