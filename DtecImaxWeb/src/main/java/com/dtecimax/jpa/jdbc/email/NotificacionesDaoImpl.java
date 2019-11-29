package com.dtecimax.jpa.jdbc.email;

import java.math.BigInteger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dtecimax.jpa.dao.email.NotificacionesDao;
import com.dtecimax.jpa.dto.email.NotificacionesDto;

@Stateless 
public class NotificacionesDaoImpl implements NotificacionesDao {

	@PersistenceContext(unitName = "DTECIMAXPU") 
	EntityManager em;
	
	@Override
	public void insert(NotificacionesDto pNotificacionesDto) {
		
		Query q = em.createNativeQuery("SELECT NEXT VALUE FOR dbo.NOTIFICACIONES_S");
		BigInteger lCitasS = (BigInteger)q.getSingleResult();
		pNotificacionesDto.setNumeroNtf(lCitasS.longValue());
        em.persist(pNotificacionesDto);
		
	}

}
