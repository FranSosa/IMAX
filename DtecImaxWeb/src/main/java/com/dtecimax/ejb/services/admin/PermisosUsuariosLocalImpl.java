package com.dtecimax.ejb.services.admin;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dtecimax.jpa.dao.admin.PermisosUsuariosDao;
import com.dtecimax.jpa.dto.admin.PermisosUsuariosDto;

@Stateless 
public class PermisosUsuariosLocalImpl implements PermisosUsuariosLocal {

	@Inject 
	PermisosUsuariosDao permisosUsuariosDao;
	
	@Override
	public void insertPermisosUsuarios(PermisosUsuariosDto pPermisosUsuariosDto) {
		permisosUsuariosDao.insertPermisosUsuario(pPermisosUsuariosDto);
	}

	@Override
	public List<PermisosUsuariosDto> findAll() {
		return permisosUsuariosDao.findSelectItems();
		
	}

	@Override
	public List<PermisosUsuariosDto> findSelectItems() {
		return permisosUsuariosDao.findSelectItems();
		
	
	}
	
	@Override
	public PermisosUsuariosDto findByNumeroPermisoUsuario(long pPermisosUsuarios) {
		return permisosUsuariosDao.findByNumeroPermisoUsuario(pPermisosUsuarios);
	}
	
	
	@Override
	public void deletePermisosUsuarios(long pPermisosUsuarios) {
		permisosUsuariosDao.deletePermisosUsuario(pPermisosUsuarios);
	}
	
	@Override
	public void updatePermisosUsuarios(long pNumeroPermisoUsuario, PermisosUsuariosDto pPermisosUsuarios) {
		permisosUsuariosDao.updatePermisosUsuario(pNumeroPermisoUsuario, pPermisosUsuarios);
	}
	


}
