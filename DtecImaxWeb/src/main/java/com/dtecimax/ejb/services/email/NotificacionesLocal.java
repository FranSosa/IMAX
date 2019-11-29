package com.dtecimax.ejb.services.email;

import javax.ejb.Local;

import com.dtecimax.jpa.dto.email.NotificacionesDto;

@Local
public interface NotificacionesLocal {

	public void insert(NotificacionesDto pNotificacionesDto); 
	
}
