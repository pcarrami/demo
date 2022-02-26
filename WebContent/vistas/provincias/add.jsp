<%@page import="com.cibertec.edu.matricula.entidades.Departamento"%>
<%@page import="java.util.List"%>
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

<link rel="stylesheet" href= "libs/css/bootstrap-datepicker.standalone.css">

</head>
<body>
	<div class="container">
		<div class="col-lg-6">
			<h1>AGREGAR PROVINCIA</h1>

			<form action="./provincias" method="post">
				ID:<br>
				<input class="form-control" type="text" name="id_prov"><br>
				NOMBRE: <br>
				<input class="form-control" type="text" name="nombre"><br>
				DEPARTAMENTOS:
				<select class="form-control" name="id_depa">
					<% List<Departamento> lstDepartamentos = (List<Departamento>) request.getAttribute("lstDepartamentos"); %>
					<% if (lstDepartamentos != null){
							for(Departamento items: lstDepartamentos){ %>
							<option value="<%=items.getId_depa() %>"> <%=items.getNombre() %></option>
					<%
							}
					}
					%>
				</select>
				<input size="16" type="text" class="form-control" id="checkin" readonly>
				<input class = "btn btn-primary" type="submit" name="accion" value="Agregar"><br>
			</form>
		</div>
		
	</div>
	<script src="libs/js/bootstrap-datepicker.min.js"></script>
	<script src="libs/locales/bootstrap-datepicker.es.min.js"></script>
<script type="text/javascript" >
	$("#checkin").datepicker({
	    language: "es",
	    todayBtn: "linked",
	    clearBtn: true,
	    format: "dd/mm/yyyy",
	    multidate: false,
	    todayHighlight: true
	});
	
	$("#checkout").datepicker({
	    language: "es",
	    todayBtn: "linked",
	    clearBtn: true,
	    format: "dd/mm/yyyy",
	    multidate: false,
	    todayHighlight: true
	});
</script>

</body>
</html>