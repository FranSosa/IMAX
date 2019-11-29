package com.dtecimax.jpa.dao.admin;

import java.util.List;

import com.dtecimax.jpa.dto.admin.PermisosDto;

public interface PermisosDao {

	public void insertPermisos(PermisosDto pPermisosDto);
	
	public List<PermisosDto> findAll();
	
	public void updatePermisos(long pNumeroPermiso
			                  ,PermisosDto pPermisosDto
			                  );
	
	public void deletePermisos(long pNumeroPermiso);

}
