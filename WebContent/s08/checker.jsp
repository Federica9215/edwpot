<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="java.util.*"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>JSP &amp; request</title>
</head>
<body>
    <h1>Hello!</h1>
    <p>
        The user name
        <%
            @SuppressWarnings("unchecked")
            Set<Character> set = (Set<Character>) request.getAttribute("set");
            if (set == null || set.isEmpty()) {
                out.print("is empty");
            } else {
                out.print("contains these letters:");

                Iterator<Character> it = set.iterator();
                while (it.hasNext()) {
                    out.print(" " + it.next());
                }
            }
        %>
    </p>
</body>
</html>


<!-- <%@ page import="java.util.*"%> qst è una libreria. 
'<%@' sign che siamo in ambito jsp. le prime due righe danno informazioni sulla pag.
 @SuppressWarnings dalla request fax una get attribute x set e x evitare il warning diciamo al programma 'fidati di me'. 
 gli attributi sn visti cm mappa (K-V). devo quindi fare un cast specifico.
 
 verifico che il set nn sia null o empty
 se è empty allora scrivo out.print("is empty");
 sennò out.print("contains these letters:")
 Iterator: è un oggetto che qnd viene creato, gli dico di essere un iteratore del set, 
 fa riferimento all elemento corrente della collezione 
 hasNext è un metodo di iterator che mi fa vedere se c'è un successivo
 it.next è un metodo di iterator che mi permette di andare avanti --> 