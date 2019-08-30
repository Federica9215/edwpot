package s09;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet ("/s09/Vinil")
public class Vinil extends HttpServlet{ 
	private static final long serialVersionUID = 1L;
	
   protected void doGet(HttpServletRequest request,HttpServletResponse response) 
   throws ServletException,IOException 
   {  
     response.setContentType("text/html"); 
     PrintWriter writer=response.getWriter(); 

     String quantità = request.getParameter("quantità");
     
     writer.println(); 
     writer.println(); 
     writer.close(); 
  }
}