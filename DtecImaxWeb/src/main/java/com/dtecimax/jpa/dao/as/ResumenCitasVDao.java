package com.dtecimax.jpa.dao.as;

import java.util.List;

import com.dtecimax.jpa.dto.as.CitasAgendadasDto;
import com.dtecimax.jpa.dto.as.ResumenCitasVDto;

import java.sql.Date;
import java.sql.Timestamp;

public interface ResumenCitasVDao {

	public List<String> findHorasIniciales(Timestamp pFechaCita); 
	
	public List<ResumenCitasVDto> findByHoraIni(String horaIni); 
	
	public  List<ResumenCitasVDto> findEstuUltr(Timestamp pFechaCita
	              		                        ,String pHoraIni); 
	public  List<ResumenCitasVDto> findMamDens(Timestamp pFechaCita
                                               ,String pHoraIni); 
	public  List<ResumenCitasVDto> findResTac(Timestamp pFechaCita
                                               ,String pHoraIni); 
	
	public List<CitasAgendadasDto> findCitasAgendadas(Date pFechaCita);
	
}
