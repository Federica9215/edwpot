<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<sql:query dataSource="jdbc/hr" var="countries">select c.country_id, c.country_name from regions r join countries c on(r.region_id=c.region_id) where r.region_id=1</sql:query>
<title>European regions</title>
</head>
<body>
<table>
        <tr>
            <th>id</th>
            <th>name</th>
        </tr>
        <c:forEach var="cur" items="${countries.rows}"> <!-- rows:collezione di tt le righe -->
            <tr>
                <td>${cur.COUNTRY_ID}</td> <!-- variabili di oracle, quelle che leggiamo nel database -->
                <td>${cur.COUNTRY_NAME}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>