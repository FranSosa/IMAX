package com.dtecimax.ejb.services.admin;

import java.util.List;

import javax.ejb.Local;

import com.dtecimax.jpa.dto.admin.PermisosUsuariosDto;


@Local
public interface PermisosUsuariosLocal {

	public void insertPermisosUsuarios(PermisosUsuariosDto pPermisosUsuario);
	
	public void deletePermisosUsuarios(long pNumeroPermisoUsuario);
	
	public void updatePermisosUsuarios(long pNumeroPermisoUsuario, PermisosUsuariosDto pPermisosUsuarios);
	
	public List<PermisosUsuariosDto> findAll(); 
	
	public List<PermisosUsuariosDto> findSelectItems();
	

	public PermisosUsuariosDto findByNumeroPermisoUsuario(long pNumeroPermisoUsuario);
	
}
