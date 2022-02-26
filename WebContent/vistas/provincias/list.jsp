<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.cibertec.edu.matricula.entidades.Provincia"%>
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
				<label>PROVINCIAS</label>
			</header>
			<div class="container">
				<div class="navbar">
		
					<a href="./provincias?accion=add" class="btn btn-outline-success">+ Nuevo</a>
					<form class="form-inline" action="./provincias" method="post">
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
					ArrayList<Provincia> lista = (ArrayList<Provincia>) request.getAttribute("lista");
					Iterator<Provincia> iter = lista.iterator();
					Provincia obj =  null;
					while(iter.hasNext()){
						obj = iter.next();
	
				%>
				<tbody>
					<tr>
						<td class="text-center"><%= obj.getId_prov() %></td>
						<td class="text-center"><%= obj.getNombre() %></td>
						<td class="text-center">
							<a class="btn btn-warning" href="./provincias?accion=editar&id_prov=<%=obj.getId_prov()%>">Editar</a>
							<a class="btn btn-danger" href="./provincias?accion=eliminar&id_prov=<%=obj.getId_prov()%>">Eliminar</a>
						
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