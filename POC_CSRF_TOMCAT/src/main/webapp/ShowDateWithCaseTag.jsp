<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "ex" uri = "WEB-INF/showdatewithcasetag.tld"%>
<!DOCTYPE html>
<html lang="fr">
<head>
<meta charset="UTF-8">
<title>ShowDateWithCaseTag</title>
</head>
<body>

	<ex:ShowDateWithCase showInUpperCase="false">
	Il est
	</ex:ShowDateWithCase>
	<br/>
	
	<ex:ShowDateWithCase showInUpperCase="true">
	Il est
	</ex:ShowDateWithCase>
	<br/>
	
</body>