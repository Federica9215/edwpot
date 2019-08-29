package s07;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/s07/timer")//servlet che risponde all 'indirizzo "/s07/timer". @WebServlet -> classe astratta che gestisce tt le connessioni al server
public class Timer extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    //se l utente mi fa una get sulla risorsa, allora metto il codice sulla do Get, alternativamente lo metto sul doPost
    protected void doGet(HttpServletRequest request, HttpServletResponse response)//request dati dell utente; response:risposta effettiva 
            throws ServletException, IOException {
        response.setContentType("text/html"); //che tipo di risposta intendo dargli, in qst caso "text/html"
        response.setCharacterEncoding("utf-8"); //in qst modo setto il carattere di risposta
        try (PrintWriter writer = response.getWriter()) { //try fatto x gestire le risorse (qnd esco dal blocco verrà chiuso automaticamente) e sto gestendo un print writer (sto scrivendo su file)
            writer.println("<!DOCTYPE html><html>");  //tt qll che succede dopo è qll che voglio vedere nella pag di risposta di html
            writer.println("<head><meta charset=\"utf-8\">");
            writer.println("<title>Hello Servlet</title></head>");
            writer.println("<body>");
            writer.println("<h1>" + LocalTime.now() + "</h1>");
            writer.println("<a href=\"..\">" + "back home" + "</a>");
            writer.println("</body></html>");
        }
    }

    @Override//se vogliamo che il doPost nn ritorni nulla possiamo inserire un mess di errore
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
