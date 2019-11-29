package com.dtecimax.jpa.jdbc.email;

import java.sql.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dtecimax.jpa.dao.email.NotificacionesVDao;
import com.dtecimax.jpa.dto.email.NotificacionesVDto;

@Stateless 
public class NotificacionesVDaoImpl implements NotificacionesVDao {


	@PersistenceContext(unitName = "DTECIMAXPU") 
	EntityManager em;
	
	@Override
	public List<NotificacionesVDto> findByCurrentSysdate(java.sql.Date pCurrentDate) {
        String strQuery =" SELECT n FROM NotificacionesVDto n WHERE n.castFechaCreacion='"+pCurrentDate+"'"; 
       Query q = em.createQuery(strQuery);
		List<NotificacionesVDto> listNotificacionesVDto =  q.getResultList();
		return listNotificacionesVDto;
		
	}

	@Override
	public List<NotificacionesVDto> findByDates(Date pFechaDesde, Date pFechaHasta) {
        String strQuery =" SELECT n FROM NotificacionesVDto n WHERE n.castFechaCreacion between '"+pFechaDesde+"' AND '"+pFechaHasta+"'"; 
        Query q = em.createQuery(strQuery);
		List<NotificacionesVDto> listNotificacionesVDto =  q.getResultList();
		return listNotificacionesVDto;
	}

}
