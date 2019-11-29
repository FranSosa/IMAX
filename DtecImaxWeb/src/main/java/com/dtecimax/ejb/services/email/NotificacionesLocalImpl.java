package com.dtecimax.ejb.services.email;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dtecimax.jpa.dao.email.NotificacionesDao;
import com.dtecimax.jpa.dto.email.NotificacionesDto;

@Stateless 
public class NotificacionesLocalImpl implements NotificacionesLocal {

	@Inject 
	NotificacionesDao  notificacionesDao; 
	
	@Override
	public void insert(NotificacionesDto pNotificacionesDto) {
		notificacionesDao.insert(pNotificacionesDto);
	}

}
