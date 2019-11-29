package com.dtecimax.ejb.services.as;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import javax.ejb.Local;

import com.dtecimax.jpa.dto.as.CitasAgendadasDto;
import com.dtecimax.jpa.dto.as.ResumenCitasVDto;

@Local
public interface ResumenCitasLocal {

	public List<String> findHorasIniciales(Timestamp pFechaCita); 
	
	public List<ResumenCitasVDto> findByHoraIni(String horaIni); 
	
	public  List<ResumenCitasVDto> findEstuUltr(Timestamp pFechaCita
	                                           ,String pHoraIni
	                                           ); 
	public  List<ResumenCitasVDto> findMamDens(Timestamp pFechaCita
	                                           ,String pHoraIni
	                                           ); 
	public  List<ResumenCitasVDto> findResTac(Timestamp pFechaCita
	                                           ,String pHoraIni
	                                           ); 
   
	public List<CitasAgendadasDto> findCitasAgendadas(Date pFechaCita);
	
}
