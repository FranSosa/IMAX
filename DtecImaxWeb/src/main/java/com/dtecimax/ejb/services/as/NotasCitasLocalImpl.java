package com.dtecimax.ejb.services.as;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dtecimax.jpa.dao.as.NotasCitasDao;
import com.dtecimax.jpa.dto.as.NotasCitasDto;

@Stateless
public class NotasCitasLocalImpl implements NotasCitasLocal {

	@Inject 
	NotasCitasDao notasCitasDao;
	
	@Override
	public void insertNotasCitas(NotasCitasDto pNotasCitasDto) {
		notasCitasDao.insertNotasCitas(pNotasCitasDto);
	}

	@Override
	public List<NotasCitasDto> findAll() {
		return notasCitasDao.findAll();
	}

	@Override
	public void deleteNotasCitas(long pNumeroNota) {
		notasCitasDao.deleteNotasCitas(pNumeroNota);
	}

}
