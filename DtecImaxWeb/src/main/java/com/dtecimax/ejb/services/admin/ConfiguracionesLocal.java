package com.dtecimax.ejb.services.admin;

import javax.ejb.Local;

import com.dtecimax.jpa.dto.admin.ConfiguracionesDto;

@Local
public interface ConfiguracionesLocal {

	
	public void insertConfiguraciones(ConfiguracionesDto pConfiguracionesDto); 
	
}
