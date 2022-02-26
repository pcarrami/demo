package com.cibertec.edu.matricula.controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cibertec.edu.matricula.entidades.Departamento;
import com.cibertec.edu.matricula.entidades.Provincia;
import com.cibertec.edu.matricula.servicios.DepartamentoService;
import com.cibertec.edu.matricula.servicios.ProvinciaService;

/**
 * Servlet implementation class ProvinciaController
 */
@WebServlet(name="provinciaController", urlPatterns= {"/provincias"})
public class ProvinciaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String url_listar="./vistas/provincias/list.jsp";
	String url_add = "./vistas/provincias/add.jsp";
	String url_edit = "./vistas/provincias/edit.jsp";
	Provincia obj = null;
	ProvinciaService servicios =  null;
	DepartamentoService servDepa = null;
	String valor="";
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String acceso = "";
		String action = request.getParameter("accion");
		try {
			if(action.equalsIgnoreCase("listar")){
				acceso=url_listar;
				servicios = new ProvinciaService();
				List<Provincia> lista = servicios.listar();
				request.setAttribute("lista", lista);
			}else if(action.equalsIgnoreCase("add")) {
				acceso=url_add;
				servDepa = new DepartamentoService();
				List<Departamento> lstDepartamentos = servDepa.listar();
				request.setAttribute("lstDepartamentos", lstDepartamentos);
				
			}else if(action.equalsIgnoreCase("Agregar")) {
				Integer id_prov, id_depa;
				String nombre;
				id_prov = Integer.parseInt(request.getParameter("id_prov"));
				nombre = request.getParameter("nombre");
				id_depa = Integer.parseInt(request.getParameter("id_depa"));
				obj = new Provincia(id_prov,nombre, id_depa);
				servicios = new ProvinciaService();
				servicios.agregar(obj);
				List<Provincia> lista = servicios.listar();
				request.setAttribute("lista", lista);
				acceso = url_listar;
			}
			else if(action.equalsIgnoreCase("editar")) {
				Integer id_prov = Integer.parseInt(request.getParameter("id_prov"));
				servicios = new ProvinciaService();
				servDepa = new DepartamentoService();
				List<Departamento> lstDepartamentos = servDepa.listar();
				request.setAttribute("lstDepartamentos", lstDepartamentos);
				obj = servicios.getEntity(id_prov);
				request.setAttribute("obj", obj);
				acceso = url_edit;
			}else if(action.equalsIgnoreCase("Actualizar")) {
				Integer id_prov, id_depa;
				String nombre;
				id_prov = Integer.parseInt(request.getParameter("id_prov"));
				nombre = request.getParameter("nombre");
				id_depa = Integer.parseInt(request.getParameter("id_depa"));
				obj = new Provincia(id_prov,nombre, id_depa);
				servicios = new ProvinciaService();
				servicios.modificar(obj);
				List<Provincia> lista = servicios.listar();
				request.setAttribute("lista", lista);
				acceso = url_listar;
			}else if(action.equalsIgnoreCase("eliminar")) {
				Integer id_prov;
				id_prov = Integer.parseInt(request.getParameter("id_prov"));
				servicios = new ProvinciaService();
				servicios.eliminar(id_prov);
				List<Provincia> lista = servicios.listar();
				request.setAttribute("lista", lista);
				acceso = url_listar;
			}else if(action.equalsIgnoreCase("buscar")){
				valor = request.getParameter("txtBuscar");
				acceso=url_listar;
				servicios = new ProvinciaService();
				List<Provincia> lista = servicios.buscar(valor);
				request.setAttribute("lista", lista);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		request.setAttribute("valor", valor);
		RequestDispatcher vista = request.getRequestDispatcher(acceso);
		vista.forward(request, response);
	}

}
