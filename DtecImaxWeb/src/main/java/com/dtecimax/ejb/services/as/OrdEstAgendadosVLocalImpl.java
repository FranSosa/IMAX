package com.dtecimax.ejb.services.as;

import java.sql.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dtecimax.jpa.dao.as.OrdEstAgendadosVDao;
import com.dtecimax.jpa.dto.as.OrdEstAgendadosDtoV1;
import com.dtecimax.jpa.dto.as.OrdEstAgendadosDtoV2;

@Stateless 
public class OrdEstAgendadosVLocalImpl implements OrdEstAgendadosVLocal {

	@Inject 
	OrdEstAgendadosVDao ordEstAgendadosVDao; 
	
	@Override
	public List<OrdEstAgendadosDtoV1> findByTipoOrdenV1(String pTipoOrden) {
		return ordEstAgendadosVDao.findByTipoOrdenV1(pTipoOrden);
	}

	@Override
	public List<OrdEstAgendadosDtoV2> findByTipoOrdenV2(String pTipoOrden) {
		return ordEstAgendadosVDao.findByTipoOrdenV2(pTipoOrden);
	}

	@Override
	public long countV1(String pTipoOrden, Date pFecha) {
		return ordEstAgendadosVDao.countV1(pTipoOrden, pFecha);
	}

	@Override
	public long countV2(String pTipoOrden, Date pFecha) {
		return ordEstAgendadosVDao.countV2(pTipoOrden, pFecha);
	}

}
