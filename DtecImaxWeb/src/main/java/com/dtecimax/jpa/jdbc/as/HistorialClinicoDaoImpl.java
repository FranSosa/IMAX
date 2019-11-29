package com.dtecimax.jpa.jdbc.as;

import java.math.BigInteger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dtecimax.jpa.dao.as.HistorialClinicoDao;
import com.dtecimax.jpa.dto.as.HistorialClinicoDto;

@Stateless 
public class HistorialClinicoDaoImpl implements HistorialClinicoDao {

	@PersistenceContext(unitName = "DTECIMAXPU") 
	EntityManager em;
	
	
	@Override
	public void insertHistorialClinico(HistorialClinicoDto pHistorialClinicoDto) {
		Query q = em.createNativeQuery("SELECT NEXT VALUE FOR dbo.HISTORIAL_CLINICO_S");
		BigInteger lHistorialClinicoS = (BigInteger)q.getSingleResult();
		pHistorialClinicoDto.setNumeroHistorial(lHistorialClinicoS.longValue());
        em.persist(pHistorialClinicoDto);
	}

}
