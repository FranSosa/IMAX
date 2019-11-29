package com.dtecimax.ejb.services.admin;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dtecimax.jpa.dao.admin.ConfiguracionesDao;
import com.dtecimax.jpa.dto.admin.ConfiguracionesDto;

@Stateless 
public class ConfiguracionesLocalImpl implements ConfiguracionesLocal {

	@Inject
	ConfiguracionesDao configuracionesDao;
	@Override
	public void insertConfiguraciones(ConfiguracionesDto pConfiguracionesDto) {
		configuracionesDao.insertConfiguraciones(pConfiguracionesDto);
	}

	}


