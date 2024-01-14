<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="ISO-8859-1">
<title>login_poc_xss.jsp</title>
</head>
<body>

<!-- Injection dans une jsp par sysout et value dans un formulaire --> 
<%
 	String xssString1 = "<script>alert('XSS #1');</script>";
 	String xssString2 = "<script>alert('XSS #2');</script>";
 	System.out.println(xssString1); // ne passe pas
%>
  
<p><%=xssString1%></p> <!-- Passe  -->
  
<form action="traitement" method="post">
	<label for="name">Nom&nbsp;:</label>
	<input type="text" id="username" name="username" value="<%=xssString2%>" /> <!-- Passe  -->
    <button type="submit">Envoyer le message via JSP</button>
</form>

</body>
</html>