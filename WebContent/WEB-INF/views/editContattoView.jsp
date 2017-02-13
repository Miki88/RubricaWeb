<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<link rel="stylesheet"	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
	<script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="styleSheet.css" />
	<title>Modifica Contatto</title>
</head>
<body>
	<jsp:include page="_header.jsp"></jsp:include>
	
	<div class="container">
		<h4>
			Modifica: <font style="color: #4169E1;"> ${persona.nome} ${persona.cognome} </font>
		</h4>
		<p style="color: red;">${errorString}</p>
	</div>

	<c:if test="${not empty persona}">
		<form method="POST" action="doEditContatto">

			<div class="row">

				<div class="col-sm-4">
					<img src="images/imgEditor.png">
				</div>
				
				<div class="col-sm-6">
					<input type="hidden" name="id" value="${persona.id}" />

					<table class="table table-striped" style="margin-top:25px;">
						<tr>
							<td>Nome</td>
							<td><input type="text" name="nome" value="${persona.nome}" /></td>
						</tr>
						<tr>
							<td>Cognome</td>
							<td><input type="text" name="cognome"
								value="${persona.cognome}" /></td>
						</tr>
						<tr>
							<td>Indirizzo</td>
							<td><input type="text" name="indirizzo"
								value="${persona.indirizzo}" /></td>
						</tr>
						<tr>
							<td>Telefono</td>
							<td><input type="text" name="telefono"
								value="${persona.telefono}" /></td>
						</tr>
						<tr>
							<td>Età</td>
							<td><input type="text" name="eta" value="${persona.eta}" /></td>
						</tr>
					</table>
				</div>
			</div>
			<br>
			<div class="bottoniEditing" >
					<button type="submit" value="" style="border:none; background:none;">
							<img src="images/imgSave.png" alt="save"><font size="4" style="vertical-align: middle;"></font>
							</button>
							<a	href="${pageContext.request.contextPath}/home">			
							<img src="images/imgCancel.png"><!--<font size="4" style="vertical-align: middle;">CANCEL</font>  -->
							</a>		
			</div>
		</form>
	</c:if>
<br><br>
	<jsp:include page="_footer.jsp"></jsp:include>
</body>
</html>