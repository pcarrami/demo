package com.cibertec.edu.matricula.modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cibertec.edu.matricula.entidades.Provincia;

public class ProvinciaDao implements IProvinciaDao{
	
	private Connection cn;
	private PreparedStatement ps;
	private CallableStatement cs;
	private ResultSet rs;
	private Provincia obj;
	private ArrayList<Provincia> lista;
	
	final String GETALL = "{call pa_listar_provincias()}";
	final String GETBYID = "{call pa_get_provincia(?)}";
	final String INSERT = "{call pa_insertar_provincias(?,?)}";
	final String UPDATE = "{call pa_modificar_provincia(?,?,?)}";
	final String DELETE = "{call pa_eliminar_provincia(?)}";
	final String SEARCH = "{call pa_buscar_provincias(?)}";
	
	public ProvinciaDao(Connection cn) {
		this.cn = cn;
	}

	@Override
	public List<Provincia> listar() throws Exception{
		lista = new ArrayList<Provincia>();
		try {
			cs = cn.prepareCall(GETALL);
			rs = cs.executeQuery();
			while(rs.next()){
				obj = new Provincia(
						rs.getInt("id_prov"),
						rs.getString("nombre"),
						rs.getInt("id_depa")
						);
				lista.add(obj);
			}
		}catch (Exception e) {
			throw new Exception("Error de SQL: " + e.getMessage());
		}finally {
			try {
				if(ps!=null) ps.close();
				//if(cn!=null) cn.close();
			} catch (Exception e) {
				throw new Exception("Error de SQL: " + e.getMessage());
			}
		}
		return lista;
	}

	@Override
	public Provincia getEntity(Integer id) throws Exception{

		try {
			cs = cn.prepareCall(GETBYID);
			int i=1;
			cs.setInt(i++, id);
			rs = cs.executeQuery();
			if(rs.next()){
				obj = new Provincia(
						rs.getInt("id_prov"),
						rs.getString("nombre"),
						rs.getInt("id_depa")
						);
			}
		}catch (Exception e) {
			throw new Exception("Error de SQL: " + e.getMessage());
		}finally {
			try {
				if(ps!=null) ps.close();
				//if(cn!=null) cn.close();
			} catch (Exception e) {
				throw new Exception("Error de SQL: " + e.getMessage());
			}
		}
		return obj;
	}

	@Override
	public boolean agregar(Provincia o) throws Exception{
		int c = -1;
		try {
			cs =cn.prepareCall(INSERT);
			int i=1;
			cs.setString(i++, o.getNombre());
			cs.setInt(i++, o.getId_depa());
			c = cs.executeUpdate();
		}catch (Exception e) {
			throw new Exception("Error de SQL: " + e.getMessage());
		}finally {
			try {
				if(ps!=null) ps.close();
				//if(cn!=null) cn.close();
			} catch (Exception e) {
				throw new Exception("Error de SQL: " + e.getMessage());
			}
		}
		return c>0;

	}

	@Override
	public boolean modificar(Provincia o) throws Exception{
		int c = -1;
		try {
			cs =cn.prepareCall(UPDATE);
			int i=1;
			cs.setString(i++, o.getNombre());
			cs.setInt(i++, o.getId_depa());
			cs.setInt(i++, o.getId_prov());
			c = cs.executeUpdate();
		}catch (Exception e) {
			throw new Exception("Error de SQL: " + e.getMessage());
		}finally {
			try {
				if(ps!=null) ps.close();
				//if(cn!=null) cn.close();
			} catch (Exception e) {
				throw new Exception("Error de SQL: " + e.getMessage());
			}
		}
		return c>0;

	}

	@Override
	public boolean eliminar(Integer o) throws Exception{
		int c = -1;
		try {
			cs =cn.prepareCall(DELETE);
			int i=1;
			cs.setInt(i++, o);
			c = cs.executeUpdate();
		}catch (Exception e) {
			throw new Exception("Error de SQL: " + e.getMessage());
		}finally {
			try {
				if(ps!=null) ps.close();
				//if(cn!=null) cn.close();
			} catch (Exception e) {
				throw new Exception("Error de SQL: " + e.getMessage());
			}
		}
		return c>0;
	}

	@Override
	public List<Provincia> buscar(String valor) throws Exception {
		lista = new ArrayList<Provincia>();
		try {
			cs = cn.prepareCall(SEARCH);
			int i=1;
			cs.setString(i++, valor);
			rs = cs.executeQuery();
			while(rs.next()){
				obj = new Provincia(
						rs.getInt("id_prov"),
						rs.getString("nombre"),
						rs.getInt("id_depa")
						);
				lista.add(obj);
			}
		}catch (Exception e) {
			throw new Exception("Error de SQL: " + e.getMessage());
		}finally {
			try {
				if(ps!=null) ps.close();
				//if(cn!=null) cn.close();
			} catch (Exception e) {
				throw new Exception("Error de SQL: " + e.getMessage());
			}
		}
		return lista;
	}

}
