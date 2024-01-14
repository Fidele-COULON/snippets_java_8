<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "ex" uri = "WEB-INF/hellotag.tld"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>HelloTag</title>
</head>
<body>

	<ex:Hello>
   		Ceci est un message depuis le body du tag
	</ex:Hello>

	<br/>
	<ex:Hello message = "Ceci est un message depuis l'attribut du tag"/>

</body>
</html>