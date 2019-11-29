package com.dtecimax.jpa.jdbc.as;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dtecimax.jpa.dao.as.ResumenCitasVDao;
import com.dtecimax.jpa.dto.as.CitasAgendadasDto;
import com.dtecimax.jpa.dto.as.ResumenCitasVDto;

@Stateless 
public class ResumenCitasVDaoImpl implements ResumenCitasVDao {

	@PersistenceContext(unitName = "DTECIMAXPU") 
	EntityManager em;
	
	@Override
	public List<String> findHorasIniciales(Timestamp pFechaCita) {
		String strSysTimestamp = pFechaCita.toString().substring(0,10);
		String strQuery = "Select distinct r.horaInicialCita FROM ResumenCitasVDto r WHERE r.fechaCita = '"+strSysTimestamp+"' ";
		Query query = em.createQuery(strQuery);
		List<String> results = query.getResultList(); 
		return results;
	}

	@Override
	public List<ResumenCitasVDto> findByHoraIni(String horaIni) {
		String strQuery = "Select r FROM ResumenCitasVDto r WHERE r.fechaCita = '2019-09-10' ";
		Query query = em.createQuery(strQuery);
		List<ResumenCitasVDto> results = query.getResultList(); 
		return results;
	}

	@Override
	public List<ResumenCitasVDto> findEstuUltr(Timestamp pFechaCita, String pHoraIni) {
		String strSysTimestamp = pFechaCita.toString().substring(0,10);
		String strQuery = "Select r FROM ResumenCitasVDto r WHERE r.fechaCita = '"+strSysTimestamp+"' ";
	    strQuery = strQuery+" and r.horaInicialCita ='"+pHoraIni+"'"; 
	    strQuery = strQuery+" and r.tipoEstudio in ('Estudios Contrastados','Ultrasonidos') "; 
	    Query query = em.createQuery(strQuery);
	    List<ResumenCitasVDto> results = query.getResultList(); 
		return results;
	}

	@Override
	public List<ResumenCitasVDto> findMamDens(Timestamp pFechaCita, String pHoraIni) {
		String strSysTimestamp = pFechaCita.toString().substring(0,10);
		String strQuery = "Select r FROM ResumenCitasVDto r WHERE r.fechaCita = '"+strSysTimestamp+"' ";
	    strQuery = strQuery+" and r.horaInicialCita ='"+pHoraIni+"'"; 
	    strQuery = strQuery+" and r.tipoEstudio in ('Mamografia','Densitometria') "; 
	    Query query = em.createQuery(strQuery);
	    List<ResumenCitasVDto> results = query.getResultList(); 
		return results;
	}

	@Override
	public List<ResumenCitasVDto> findResTac(Timestamp pFechaCita, String pHoraIni) {
		String strSysTimestamp = pFechaCita.toString().substring(0,10);
		String strQuery = "Select r FROM ResumenCitasVDto r WHERE r.fechaCita = '"+strSysTimestamp+"' ";
	    strQuery = strQuery+" and r.horaInicialCita ='"+pHoraIni+"'"; 
	    strQuery = strQuery+" and r.tipoEstudio in ('Resonancia magnética','Estudios especiales de TAC') "; 
	    Query query = em.createQuery(strQuery);
	    List<ResumenCitasVDto> results = query.getResultList(); 
		return results;
	}

	@Override
	public List<CitasAgendadasDto> findCitasAgendadas(Date pFechaCita) {
		List<CitasAgendadasDto> retval = new ArrayList<CitasAgendadasDto>(); 
		String strQuery = "SELECT count(1),r.fechaCita FROM ResumenCitasVDto r";
		strQuery = strQuery+" WHERE r.fechaCita='"+pFechaCita+"'";
		strQuery = strQuery+" GROUP BY r.fechaCita";
		Query query = em.createQuery(strQuery); 
		List<Object> listResults = query.getResultList();
		if(null!=listResults) {
		Iterator<Object> iterResults= listResults.iterator(); 
		while(iterResults.hasNext()) {
			Object result = iterResults.next(); 
			if(result instanceof Object[]) {
				Object[] row = (Object[]) result;
				CitasAgendadasDto citasAgendadasDto = new CitasAgendadasDto(); 
				if(row[0] instanceof Long) {
					Long lNumeroCitas = (Long)row[0];
					citasAgendadasDto.setNumeroCitas(lNumeroCitas.longValue());
				}
				if(row[1] instanceof Date) {
					Date sqlFechaCita = (Date)row[1]; 
					citasAgendadasDto.setFechaCita(sqlFechaCita);
				}
				retval.add(citasAgendadasDto); 
			}
		}
		}
		return retval;
	}

}
