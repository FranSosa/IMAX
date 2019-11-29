package com.dtecimax.ejb.services.email;

import java.sql.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dtecimax.jpa.dao.email.NotificacionesVDao;
import com.dtecimax.jpa.dto.email.NotificacionesVDto;

@Stateless 
public class NotificacionesVLocalImpl implements NotificacionesVLocal {

	@Inject 
	NotificacionesVDao notificacionesVDao; 
	
	@Override
	public List<NotificacionesVDto> findByCurrentSysdate(java.sql.Date pCurrentDate) {
		return notificacionesVDao.findByCurrentSysdate(pCurrentDate);
	}

	@Override
	public List<NotificacionesVDto> findByDates(Date pFechaDesde, Date pFechaHasta) {
		return notificacionesVDao.findByDates(pFechaDesde, pFechaHasta);
	}

}
