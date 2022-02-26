	package com.cibertec.edu.matricula.modelo;

import java.util.List;

import com.cibertec.edu.matricula.entidades.Departamento;

public interface GenericDao<T, K> {
	public List<T> listar() throws Exception;
	public T getEntity(K id) throws Exception;
	public boolean agregar(T o) throws Exception;
	public boolean modificar(T o)throws Exception;
	public boolean eliminar(K o) throws Exception;
	
}
