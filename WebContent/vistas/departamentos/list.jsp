<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.cibertec.edu.matricula.entidades.Departamento"%>

<%@ include file="../parte_superior.jsp" %>

<!-- INICIO del contenido principal -->

<div class="container">
		<% String valor = String.valueOf(request.getAttribute("valor")); %>

			<header>
				<label>DEPARTAMENTOS</label>
			</header>
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

<!-- FIN del contenido principal -->

<%@ include file="../parte_inferior.jsp" %>