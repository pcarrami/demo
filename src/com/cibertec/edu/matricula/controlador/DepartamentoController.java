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
import com.cibertec.edu.matricula.servicios.DepartamentoService;

/**
 * Servlet implementation class DepartamentoController
 */
@WebServlet(name="departamentoController", urlPatterns= {"/departamentos"})
public class DepartamentoController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	String url_listar="./vistas/departamentos/list.jsp";
	String url_add = "./vistas/departamentos/add.jsp";
	String url_edit = "./vistas/departamentos/edit.jsp";
	Departamento obj = null;
	DepartamentoService servicios =  null;
	String valor="";
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String acceso = "";
		String action = request.getParameter("accion");
		try {
			if(action.equalsIgnoreCase("listar")){
				acceso=url_listar;
				servicios = new DepartamentoService();
				List<Departamento> lista = servicios.listar();
				request.setAttribute("lista", lista);
			}else if(action.equalsIgnoreCase("add")) {
				acceso=url_add;
			}else if(action.equalsIgnoreCase("Agregar")) {
				Integer id_depa;
				String nombre;
				id_depa = Integer.parseInt(request.getParameter("id_depa"));
				nombre = request.getParameter("nombre");
				obj = new Departamento(id_depa,nombre);
				servicios = new DepartamentoService();
				servicios.agregar(obj);
				List<Departamento> lista = servicios.listar();
				request.setAttribute("lista", lista);
				acceso = url_listar;
			}
			else if(action.equalsIgnoreCase("editar")) {
				Integer id_depa = Integer.parseInt(request.getParameter("id_depa"));
				servicios = new DepartamentoService();
				obj = servicios.getEntity(id_depa);
				request.setAttribute("ip_depa", id_depa);
				request.setAttribute("obj", obj);
				acceso = url_edit;
			}else if(action.equalsIgnoreCase("Actualizar")) {
				Integer id_depa;
				String nombre;
				id_depa = Integer.parseInt(request.getParameter("id_depa"));
				nombre = request.getParameter("nombre");
				obj = new Departamento(id_depa,nombre);
				servicios = new DepartamentoService();
				servicios.modificar(obj);
				List<Departamento> lista = servicios.listar();
				request.setAttribute("lista", lista);
				acceso = url_listar;
			}else if(action.equalsIgnoreCase("eliminar")) {
				Integer id_depa;
				id_depa = Integer.parseInt(request.getParameter("id_depa"));
				servicios = new DepartamentoService();
				servicios.eliminar(id_depa);
				List<Departamento> lista = servicios.listar();
				request.setAttribute("lista", lista);
				acceso = url_listar;
			}else if(action.equalsIgnoreCase("buscar")){
				valor = request.getParameter("txtBuscar");
				acceso=url_listar;
				servicios = new DepartamentoService();
				List<Departamento> lista = servicios.buscar(valor);
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
