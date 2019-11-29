package com.dtecimax.ejb.services.admin;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dtecimax.jpa.dao.admin.PermisosDao;
import com.dtecimax.jpa.dto.admin.PermisosDto;

@Stateless 
public class PermisosLocalImpl implements PermisosLocal {

	@Inject 
	PermisosDao permisosDao;
	
	@Override
	public void insertPermisos(PermisosDto pPermisosDto) {
		permisosDao.insertPermisos(pPermisosDto);
	}

	@Override
	public List<PermisosDto> findAll() {
		return permisosDao.findAll();
	}

	@Override
	public void updatePermisos(long pNumeroPermiso, PermisosDto pPermisosDto) {
		permisosDao.updatePermisos(pNumeroPermiso, pPermisosDto);
	}

	@Override
	public void deletePermisos(long pNumeroPermiso) {
		permisosDao.deletePermisos(pNumeroPermiso);
	}

	
}
