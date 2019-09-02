package s09;

import java.io.IOException;
//import java.io.PrintWriter;
//import java.util.Set;
//import java.util.TreeSet;
//
//import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

@WebServlet ("/s09/Vinil")
public class Vinil<Int> extends HttpServlet{ 
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) //l utente lavora su parametri
            throws ServletException, IOException {
        String Ligabue=request.getParameter("Ligabue");
        String Brasil =request.getParameter("Jazz");
        String Bruce = request.getParameter("Bruce Springsteen");
        String Battisti = request.getParameter("Battisti");
        String Gaber = request.getParameter("Gaber");
        
        response.getWriter().println("<html>");
        response.getWriter().println("<head>");
        response.getWriter().println("<title>Vinili</title>");
        response.getWriter().println("</head>");
        response.getWriter().println("<body>");
        response.getWriter().println("<br>");
        response.getWriter().println("Quantità Mondovisione: " + Ligabue);
        response.getWriter().println("<br>");
        response.getWriter().println("Quantità Brasil: " + Brasil);
        response.getWriter().println("<br>");
        response.getWriter().println("Quantità Born in the USA: " + Bruce);
        response.getWriter().println("<br>");
        response.getWriter().println("Quantità Images: " + Battisti);
        response.getWriter().println("<br>");
        response.getWriter().println("Quantità Un'ora con loro: " + Gaber);
        response.getWriter().println("<br>");
        response.getWriter().println("</body>");
        
        
//        RequestDispatcher rd = request.getRequestDispatcher("/s08/checker.jsp");
//        rd.forward(request, response);//passo request, response il lavoro ad una jsp
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}