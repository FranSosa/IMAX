package com.dtecimax.ejb.services.email;

import java.util.List;

import javax.ejb.Local;

import com.dtecimax.jpa.dto.email.NotificacionesVDto;

@Local
public interface NotificacionesVLocal {

	public List<NotificacionesVDto> findByCurrentSysdate(java.sql.Date pCurrentDate);
	
	public List<NotificacionesVDto> findByDates(java.sql.Date pFechaDesde
                                               ,java.sql.Date pFechaHasta
                                               );
	
}
