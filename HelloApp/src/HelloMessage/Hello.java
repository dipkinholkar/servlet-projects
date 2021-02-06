package HelloMessage;
import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.PrintWriter;
public class Hello implements Servlet {

//initialize servlet
	
	ServletConfig config =null;
	PrintWriter pw;
	public void init(ServletConfig config) {
		
		this.config=config;
		System.out.print("Config :"+config);
		}
	

	public void service(ServletRequest req , ServletResponse res) throws IOException
	{
		
		pw=res.getWriter();
		pw.println("Request:"+req+"\n");
		pw.println("Response:"+res+"\n");		
		res.setContentType("text/html");
		String v=req.getParameter("submit");
		
		pw.print("v"+v);
		
	}
	
	public void destroy() {pw.print("destroy");}
	
	public ServletConfig getServletConfig()
	{
		return config;
	}
	
	public String getServletInfo()
	{
		return "tomcat";
	}
}