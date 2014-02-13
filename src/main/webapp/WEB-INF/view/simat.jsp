<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Sistema de alertas SIMAT</title>
	<script type="text/javascript" src="<%=request.getContextPath()%>/general/js/jquery-2.0.3.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath()%>/general/js/simatUtil.js"></script>
</head>
<body>
	<h1>Valor SIMAT actual:</h1>	
	<div>
		<table>
			<tr>
				<td><label id="simat">${imeca}</label></td>
				<td><img id="load" style="display: none;" alt="" src="<%=request.getContextPath()%>/general/images/loading.gif" width="20px" height="20px"></td>
			</tr>
		</table>
	</div>
</body>
</html>