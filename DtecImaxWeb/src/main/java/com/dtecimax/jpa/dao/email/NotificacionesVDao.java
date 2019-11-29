package com.dtecimax.jpa.dao.email;

import java.util.List;

import com.dtecimax.jpa.dto.email.NotificacionesVDto; 

public interface NotificacionesVDao {

	public List<NotificacionesVDto> findByCurrentSysdate(java.sql.Date pCurrentDate);
	
	public List<NotificacionesVDto> findByDates(java.sql.Date pFechaDesde
			                                   ,java.sql.Date pFechaHasta);
	
}
