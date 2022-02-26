<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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

<link rel="stylesheet" href="./css/style.css" type="text/css">

</head>
<body>
	<% String valor = String.valueOf(request.getAttribute("valor")); %>

			<header>
				<label>DEPARTAMENTOS</label>
			</header>
			<div class="container">
				<div class="navbar">
		
					<a href="./departamentos?accion=add" class="btn btn-outline-success">+ Nuevo</a>
					<form class="form-inline" action="./departamentos" method="post">
						<input class="form-control" type="search" name="txtBuscar" value="<%=valor%>">
						<input class="btn btn-outline-success" type="submit" name="accion" value="Buscar">
					</form>
				</div>

			<table class="table table-bordered">
				<thead>
					<tr>
						<th class="text-center">ID</th>
						<th class="text-center">NOMBRE</th>
						<th class="text-center">ACCIONES</th>
					</tr>
				</thead>
				<%
					ArrayList<Departamento> lista = (ArrayList<Departamento>) request.getAttribute("lista");
					Iterator<Departamento> iter = lista.iterator();
					Departamento obj =  null;
					while(iter.hasNext()){
						obj = iter.next();
	
				%>
				<tbody>
					<tr>
						<td class="text-center"><%= obj.getId_depa() %></td>
						<td class="text-center"><%= obj.getNombre() %></td>
						<td class="text-center">
							<a class="btn btn-warning" href="./departamentos?accion=editar&id_depa=<%=obj.getId_depa()%>">Editar</a>
							<a class="btn btn-danger" href="./departamentos?accion=eliminar&id_depa=<%=obj.getId_depa()%>">Eliminar</a>
						
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			
			</table>
		</div>
</body>
</html>