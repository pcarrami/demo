<%@page import="com.cibertec.edu.matricula.entidades.Departamento"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%--configuración Font Awesome (iconos) --%>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<%--configuración boostrap (estilos) --%>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" >

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.0/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.19.0/jquery.validate.min.js"></script>
</head>
<body>
	<div class="container">
		<div class="col-lg-6">
		
			<%
				Departamento obj = (Departamento) request.getAttribute("obj");
			%>
			<h1>MODIFICAR DEPARTAMENTO</h1>
			<form action="./departamentos" method="post">
				ID:<br>
				<input class="form-control" type="text" name="id_depa" value="<%=obj.getId_depa()%>"><br>
				NOMBRE: <br>
				<input class="form-control" type="text" name="nombre" value="<%=obj.getNombre()%>"><br>
				<input class = "btn btn-primary" type="submit" name="accion" value="Actualizar"><br>
				<a href="./departamentos?accion=listar">Regresar</a>
			</form>
		</div>
	</div>
</body>
</html>