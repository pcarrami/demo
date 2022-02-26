package com.cibertec.edu.matricula.modelo;

import java.sql.Connection;

import com.cibertec.edu.matricula.cnx.MySQLConexion;

public class DaoManager implements IDaoManager{

	private static final DaoManager instancia = new DaoManager();
	private Connection cn;
	
	private DaoManager() {
		cn = new MySQLConexion().getConn();
	}
	
	public static DaoManager getInstancia() {
		return instancia;
	}
	
	//Factory
	private IDepartamentoDao departamentoDao = null;
	private IProvinciaDao provinciaDao = null;
	
	@Override
	public IDepartamentoDao getDepartamentoDao() {
		if(departamentoDao==null) {
			departamentoDao = new DepartamentoDao(cn);
		}
		return departamentoDao;
	}
	
	@Override
	public IProvinciaDao getProvinciaDao() {
		if(provinciaDao==null) {
			provinciaDao = new ProvinciaDao(cn);
		}
		return provinciaDao;
	}

}
