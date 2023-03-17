<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Connexion</title>
</head>
<body>

<form method="POST" action="j_security_check">
	<table>
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