<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script type="text/javascript" src="/resources/js/jquery-2.0.3.js"></script>
</head>

<script type="text/javascript">
	var error = $('#error').val();
	alert(error);
</script>

<body>
	<input type="hidden" id="error" value="${error}">
</body>
</html>