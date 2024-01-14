<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "ex" uri = "WEB-INF/logincsrftag.tld"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>LoginTag</title>
</head>
<body>

	<H1>Login with CSRF Form</H1>
	
    <ex:LoginCSRFForm action="traitement">
    	<label for="name">Nom&nbsp;:</label>
		<input type="text" id="name" name="username" />
    	<button type="submit">Envoyer par JSP + CSRF Form</button>
	</ex:LoginCSRFForm>
 
</body>
</html>