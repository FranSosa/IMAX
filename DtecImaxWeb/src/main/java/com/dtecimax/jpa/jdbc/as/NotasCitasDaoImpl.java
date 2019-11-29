package com.dtecimax.jpa.jdbc.as;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dtecimax.jpa.dao.as.NotasCitasDao;
import com.dtecimax.jpa.dto.as.NotasCitasDto;

@Stateless 
public class NotasCitasDaoImpl implements NotasCitasDao {

	@PersistenceContext(unitName = "DTECIMAXPU") 
	EntityManager em;
	
	@Override
	public void insertNotasCitas(NotasCitasDto pNotasCitasDto) {
		Query q = em.createNativeQuery("SELECT NEXT VALUE FOR dbo.NOTAS_CITAS_S");
		BigInteger lNumeroNotaS = (BigInteger)q.getSingleResult();
		pNotasCitasDto.setNumeroNota(lNumeroNotaS.longValue());
        em.persist(pNotasCitasDto);
	}

	@Override
	public List<NotasCitasDto> findAll() {
		return em.createNamedQuery("NotasCitasDto.findAll").getResultList();
	}

	@Override
	public void deleteNotasCitas(long pNumeroNota) {
		NotasCitasDto notasCitasDto = em.find(NotasCitasDto.class, pNumeroNota); 
		em.remove(notasCitasDto);
	}

}
