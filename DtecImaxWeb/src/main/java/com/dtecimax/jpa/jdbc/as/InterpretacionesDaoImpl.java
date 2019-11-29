package com.dtecimax.jpa.jdbc.as;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dtecimax.jpa.dao.as.InterpretacionesDao;
import com.dtecimax.jpa.dto.as.InterpretacionesDto;

@Stateless 
public class InterpretacionesDaoImpl implements InterpretacionesDao {

	@PersistenceContext(unitName = "DTECIMAXPU") 
	EntityManager em;
	
	@Override
	public void insertInterpretaciones(InterpretacionesDto pInterpretacionesDto) {
		Query q = em.createNativeQuery("SELECT NEXT VALUE FOR dbo.INTERPRETACIONES_S");
		BigInteger lInterpretacionesS = (BigInteger)q.getSingleResult();
		pInterpretacionesDto.setNumeroInterpretacion(lInterpretacionesS.longValue());
        em.persist(pInterpretacionesDto);
	}

	@Override
	public List<InterpretacionesDto> findSelectItems() {
		return em.createNamedQuery("InterpretacionesDto.findAll").getResultList();
	}

}
