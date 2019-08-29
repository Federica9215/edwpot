package s08;

import java.io.IOException;

//qlkn mi manda il suo nome e io voglio leggere le lette in ordine e nn duplicate
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet("/s08/checker") //a che risorsa risponde la mia server; è indirizzo che mi dev
//public class Checker extends HttpServlet {
//    private static final long serialVersionUID = 1L;
//
//    @Override //sn overrude xkè sn stati dichiarati all interno del servlet
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) //l utente lavora su parametri
//            throws ServletException, IOException {
//        String user = request.getParameter("user"); //leggo il parametro, leggo un set 
//        Set<Character> set = new TreeSet<>(); //char nn viene accettato
//        if (user != null) {
//            for (char c : user.toCharArray()) { //ho convertito user in un array e su qst array ho fatto il for each
//                set.add(Character.toLowerCase(c));//carattere corrente trasformato senza duplicazioni
//            }
//        }
//        request.setAttribute("set", set); //quello che utilizzo è un attributo. mi metto un attributo sulla request e come valore ci metto il set 
//
//        RequestDispatcher rd = request.getRequestDispatcher("/s08/checker.jsp");
//        rd.forward(request, response);//passo request, response il lavoro ad una jsp
//    }
//
//    @Override
//    protected void doPost(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        doGet(request, response);
//    }
//}

@WebServlet("/s08/checker") //a che risorsa risponde la mia server; è indirizzo che mi dev
public class Checker extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override //sn overrude xkè sn stati dichiarati all interno del servlet
    protected void doGet(HttpServletRequest request, HttpServletResponse response) //l utente lavora su parametri
            throws ServletException, IOException {
        String user = request.getParameter("user"); //leggo il parametro, leggo un set 
        Set<Character> set = new TreeSet<>(); //char nn viene accettato
        if (user != null) {
            for (char c : user.toCharArray()) { //ho convertito user in un array e su qst array ho fatto il for each
                set.add(Character.toLowerCase(c));//carattere corrente trasformato senza duplicazioni
            }
        }
        request.setAttribute("set", set); //quello che utilizzo è un attributo. mi metto un attributo sulla request e come valore ci metto il set 

        RequestDispatcher rd = request.getRequestDispatcher("/s08/checker.jsp");
        rd.forward(request, response);//passo request, response il lavoro ad una jsp
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
