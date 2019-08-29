<%@ page import="java.time.LocalTime"%> 
<!DOCTYPE html> 
<html>
<head>
<meta charset="utf-8">
<title>Hello JSP</title>
</head>
<body>
    <h1>
        <%
            out.print(LocalTime.now()); // importo la libreria java.time <% tag di sola apertura dove dentro c e il codice java. out è esattamente la pag stessa. il risultato mi viene messo in un elemento h1
        %>
    </h1>
</body>
</html>