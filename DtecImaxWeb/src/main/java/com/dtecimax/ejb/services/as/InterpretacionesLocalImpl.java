package com.dtecimax.ejb.services.as;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dtecimax.jpa.dao.as.InterpretacionesDao;
import com.dtecimax.jpa.dto.as.InterpretacionesDto;

@Stateless
public class InterpretacionesLocalImpl implements InterpretacionesLocal {

	@Inject
	InterpretacionesDao interpretacionesDao;
	
	@Override
	public void insertInterpretaciones(InterpretacionesDto pInterpretacionesDto) {
		interpretacionesDao.insertInterpretaciones(pInterpretacionesDto);
	}

	@Override
	public List<InterpretacionesDto> findSelectItems() {
		return interpretacionesDao.findSelectItems();
	}

}
