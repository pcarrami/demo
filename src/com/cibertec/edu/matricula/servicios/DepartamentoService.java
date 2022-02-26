package com.cibertec.edu.matricula.servicios;

import java.util.List;

import com.cibertec.edu.matricula.entidades.Departamento;
import com.cibertec.edu.matricula.modelo.DaoManager;
import com.cibertec.edu.matricula.modelo.IDepartamentoDao;

public class DepartamentoService {
	
	DaoManager factory = DaoManager.getInstancia();
	IDepartamentoDao dao = factory.getDepartamentoDao();
	
	public List<Departamento> listar() throws Exception{
		return dao.listar();
	}
	
	public boolean agregar(Departamento o) throws Exception{
		return dao.agregar(o);
	}
	public Departamento getEntity(Integer id) throws Exception{
		return dao.getEntity(id);
	}
	
	public boolean modificar(Departamento o) throws Exception{
		return dao.modificar(o);
	}
	
	public boolean eliminar(Integer o) throws Exception{
		return dao.eliminar(o);
	}
	
	public List<Departamento> buscar(String valor) throws Exception {
		return dao.buscar(valor);
	}
}
