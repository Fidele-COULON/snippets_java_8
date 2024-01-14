<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "ex" uri = "WEB-INF/logintag.tld"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>LoginTag</title>
</head>
<body>

	<H1>Login screen</H1>
	
    <ex:LoginForm action="traitement" login="${name}" password="${password}" />
 
</body>
</html>