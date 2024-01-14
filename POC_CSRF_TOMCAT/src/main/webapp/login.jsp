<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="fr.fidtec.tools.CSRF_Utils"%>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="ISO-8859-1">
<title>Login.jsp</title>
</head>
<body>

<!-- Ne fonctionne pas, le Header n'est pas transmis, car une JSP est en réalité câblée avec une servlet, il faut passer par un filtre --> 
 <%
 	response.setHeader(CSRF_Utils.CSRF_TOKEN, "TestCSRF");
 %>
 
 <%
 	String csrfToken = CSRF_Utils.generateCSRFToken();
 	session.setAttribute(CSRF_Utils.CSRF_TOKEN, csrfToken);
 %>
 
<form action="traitement" method="post">
	<input type="hidden" name=<%=CSRF_Utils.CSRF_TOKEN%> value="<%=csrfToken%>">
	<label for="name">Nom&nbsp;:</label>
	<input type="text" id="name" name="username" />
    <button type="submit">Envoyer par JSP</button>
</form>

</body>
</html>