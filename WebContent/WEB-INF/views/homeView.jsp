<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link rel="stylesheet" type="text/css" href="styleSheet.css" />
<title>Rubrica Telefonica Web</title>
</head>

<body>

	<jsp:include page="_header.jsp"></jsp:include>

	<div class="container">
		<h4>Aggiungi, modifica o elimina contatti dalla rubrica.</h4>
		<br>
		<p style="color: red;">${errorString}</p>
	</div>

	<div class="row">
	
		<div class="col-sm-4">
			<img src="images/imgRubrica.png">
		</div>
		
		<div class="col-sm-8">
			<table class="table  table-striped">
				<thead>
					<tr>
						<th>Nome</th>
						<th>Cognome</th>
						<th>Telefono</th>
						<th>Modifica</th>
						<th>Elimina</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${listaPersone}" var="persona">

						<tr>
							<!-- 		<td>${persona.id}</td>-->
							<td>${persona.nome}</td>
							<td>${persona.cognome}</td>
							<td>${persona.telefono}</td>
							<td style="padding-left: 10px;">
								<a href="editContatto?id=${persona.id}">
								<img src="images/imgEdit.png"></a>
							</td>
							<td style="padding-left: 10px;">
								<a href="deleteContatto?id=${persona.id}">
								<img src="images/imgDelete.png"></a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</div>
	
	<div class="bottoniHome">
		<div class="nav-bar">
			<ul class="nav nav-pills">
				<li><a href="createContatto"> <img src="images/imgNew.png"
						alt="new"> <font size="4" style="vertical-align: middle;">
							NUOVO CONTATTO</font>
				</a></li>
			</ul>
		</div>
	</div>
	
	<br>
	<br>
	<jsp:include page="_footer.jsp"></jsp:include>

</body>
</html>