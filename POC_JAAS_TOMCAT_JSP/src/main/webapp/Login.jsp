<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>

<!-- JAAS (Java Authentication and Authorization Service) -->
<!-- Le serveur reconnaît les requêtes d'authentification de formulaire que lorsque les URI se terminent par /j_security_check et que les paramètres j_username et j_password existent. --> 
<!-- HTTP 408 – Timeout de la requête car login.jsp n'est pas une Landing Page -->

<form method="POST" action="j_security_check">
	<table>
	<caption>Identification</caption>
	<tr>
	<th></th>
	</tr>
	<tr>
		<td>Login :</td>
		<td><input type="text" name="j_username"></td>
	</tr>
	<tr>
		<td>Mot de passe :</td>
		<td><input type="password" name="j_password"></td>
	</tr>
	<tr>
	<td><input type="submit" value="Login"></td>
	<td><input type="reset" value="Cancel"></td>
</tr>
	</table>
</form>

</body>
</html>