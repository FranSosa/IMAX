package com.dtecimax.jpa.dao.admin;

import java.util.List;

import com.dtecimax.jpa.dto.admin.PermisosUsuariosDto;


public interface PermisosUsuariosDao {

	public void insertPermisosUsuario(PermisosUsuariosDto pPermisosUsuarios);
	
	public void deletePermisosUsuario(long pNumeroPermisoUsuario);
	
	public void updatePermisosUsuario(long pNumeroPermisoUsuario, PermisosUsuariosDto pPermisosUsuarios);
	
	public List<PermisosUsuariosDto> findAll(); 
	
	public List<PermisosUsuariosDto> findSelectItems();
	
	public PermisosUsuariosDto findByNumeroPermisoUsuario(long pNumeroPermisoUsuario);
	
	
}
