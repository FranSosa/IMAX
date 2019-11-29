package com.dtecimax.ejb.services.admin;

import java.util.List;

import javax.ejb.Local;

import com.dtecimax.jpa.dto.admin.PermisosDto;

@Local
public interface PermisosLocal {

	public void insertPermisos(PermisosDto pPermisosDto);
	
	public void updatePermisos(long pNumeroPermiso, PermisosDto pPermisosDto);
	
	public List<PermisosDto> findAll();
	
	public void deletePermisos(long pNumeroPermiso); 
	
}
