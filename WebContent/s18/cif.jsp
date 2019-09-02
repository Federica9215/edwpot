<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> <!-- sto usando una tag library. voglio utilizzare un core e utilizzo il prefisso c e se voglio utilizzare l'if, metto "c:if". uri:attributo di un elemento. capisco che si tratta di attributi xkè sono tra i tag di apertura e chiusura-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL core if</title>
</head>
<body>
    <h1>This JSP expects x or y as parameter</h1> verific il test. se è true, allora mi dai il parametro
    <c:if test="${param.x != null}">
        <p>Parameter x is ${param.x}</p>
    </c:if>
    <c:if test="${param.y != null}">
        <p>Parameter y is ${param.y}</p>
    </c:if>
</body>
</html>