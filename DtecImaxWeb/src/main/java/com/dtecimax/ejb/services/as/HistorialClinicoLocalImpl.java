package com.dtecimax.ejb.services.as;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dtecimax.jpa.dao.as.HistorialClinicoDao;
import com.dtecimax.jpa.dto.as.HistorialClinicoDto;

@Stateless
public class HistorialClinicoLocalImpl implements HistorialClinicoLocal {

	@Inject 
	HistorialClinicoDao historialClinicoDao;
	
	@Override
	public void insertHistorialClinico(HistorialClinicoDto pHistorialClinicoDto) {
		historialClinicoDao.insertHistorialClinico(pHistorialClinicoDto);
	}

}
