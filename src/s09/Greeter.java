package s09;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.Duration;
import java.time.LocalTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/s09/greeter")
public class Greeter extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        LocalTime start = (LocalTime) session.getAttribute("start"); //chiedo a session se ha un attributo che si chiama start e se c e l ha me lo ritorna
        
//siccome si tratta di downcast, sarebbe rischioso scrivere LocalTime start = (LocalTime) session.getAttribute("start"); sarebbe meglio scrivere così: 
//LocalTime st;        
//Object o=session.getAttribute("start");
//if (o instanceof LocalTime) {
//	st=(LocalTime)o
//}else {...}
        
        Duration duration; //dichiaro una var duration(rappresenta una durata) che fa parte di java.time
        if (start == null) { //qnd nn c 'è un attributo start nella mia sessione allora
            duration = Duration.ZERO; //è un membro di una classe pubblica, è una proprietà scritta in maiuscolo xkè rappresenta una var final. Alternativamente poteva essere un metodo ma nn c sn le parentesi
            session.setAttribute("start", LocalTime.now()); //abbiamo un attributo che si chiama start e rappresenta l ora corrente. qnd start è nullo, allora assegno a start l ora locale 
        } else {
            duration = Duration.between(start, LocalTime.now()); //altrimenti duration me la setta chiamando il metodo between tra start e localTime.now: mi trova l arco temporale tra now e start
        }

        if (request.getParameter("done") != null) { //chiamo il metodo getParameter su done x la request e vedo se mi ritorna null o meno. se il chiamante mi ha specificato il parametro done, allora entro nell if
            session.invalidate(); //
//in qst caso la risposta è così piccola che nn mi serve fare un file .jsp ma lo posso scrivere all interno della pag stessa. 
            response.setContentType("text/html");
            response.setCharacterEncoding("utf-8");
            try (PrintWriter writer = response.getWriter()) {
                writer.println("<!DOCTYPE html><html>");
                writer.println("<head><meta charset=\"utf-8\">");
                writer.println("<title>So long</title></head>");
                writer.println("<body><h1>Goodbye</h1>");
                writer.println("<p>You worked on this stuff for " + duration.getSeconds() + " seconds</p>");
                writer.println("</body></html>");
            }
            return; //return:ho finito il lavoro
        }
//se l utente nn ha fatto un done, allora fax le ultime due righe. 
        request.setAttribute("duration", duration); //prendo la var locale duration e la metto in request cm attributo. Lo fax xkè poi voglio passare alla servlet che in qst caso è "/s09/greeter.jsp"
        RequestDispatcher rd = request.getRequestDispatcher("/s09/greeter.jsp");
        rd.forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}


//pox scrivere anche così al posto di return;
//
//if (request.getParameter("done") != null) { 
//    session.invalidate(); 
//    response.setContentType("text/html");
//    response.setCharacterEncoding("utf-8");
//    try (PrintWriter writer = response.getWriter()) {
//        writer.println("<!DOCTYPE html><html>");
//        writer.println("<head><meta charset=\"utf-8\">");
//        writer.println("<title>So long</title></head>");
//        writer.println("<body><h1>Goodbye</h1>");
//        writer.println("<p>You worked on this stuff for " + duration.getSeconds() + " seconds</p>");
//        writer.println("</body></html>");
//    }
//   
//} else {
//	request.setAttribute("duration", duration); 
//	RequestDispatcher rd = request.getRequestDispatcher("/s09/greeter.jsp");
//	rd.forward(request, response); }
//
//}
