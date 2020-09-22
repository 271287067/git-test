<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org/thymeleaf-extras-springsecurity3">
	<head>
		<meta charset="UTF-8"/>
		<title>Hello freemarker!</title>
	</head>
	<body>
		<h1 th:inline="text">Hello freemarker!</h1>
		<p>${hello}</p>
		<p><a href="/templates/helloHtml">跳转Hello页面</a></p>
	</body>
</html>
