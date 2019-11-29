package com.dtecimax.ejb.services.as;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import com.dtecimax.jpa.dao.as.ResumenCitasVDao;
import com.dtecimax.jpa.dto.as.CitasAgendadasDto;
import com.dtecimax.jpa.dto.as.ResumenCitasVDto;

@Stateless 
public class ResumenCitasLocalImpl implements ResumenCitasLocal{

	@Inject
	ResumenCitasVDao resumenCitasVDao; 
	
	@Override
	public List<String> findHorasIniciales(Timestamp pFechaCita) {
		return resumenCitasVDao.findHorasIniciales(pFechaCita); 
	}

	@Override
	public List<ResumenCitasVDto> findByHoraIni(String horaIni) {
		return resumenCitasVDao.findByHoraIni(horaIni); 
	}

	@Override
	public List<ResumenCitasVDto> findEstuUltr(Timestamp pFechaCita, String pHoraIni) {
		return resumenCitasVDao.findEstuUltr(pFechaCita, pHoraIni);
	}

	@Override
	public List<ResumenCitasVDto> findMamDens(Timestamp pFechaCita, String pHoraIni) {
		return resumenCitasVDao.findMamDens(pFechaCita, pHoraIni);
	}

	@Override
	public List<ResumenCitasVDto> findResTac(Timestamp pFechaCita, String pHoraIni) {
		return resumenCitasVDao.findResTac(pFechaCita, pHoraIni);
	}

	@Override
	public List<CitasAgendadasDto> findCitasAgendadas(Date pFechaCita) {
		return resumenCitasVDao.findCitasAgendadas(pFechaCita);
	}

}
