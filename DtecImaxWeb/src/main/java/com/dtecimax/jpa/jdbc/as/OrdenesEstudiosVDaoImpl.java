package com.dtecimax.jpa.jdbc.as;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dtecimax.jpa.dao.as.OrdenesEstudiosVDao;
import com.dtecimax.jpa.dto.as.OrdenesEstudiosVDto;

@Stateless 
public class OrdenesEstudiosVDaoImpl implements OrdenesEstudiosVDao {

	@PersistenceContext(unitName = "DTECIMAXPU") 
	EntityManager em;
	
	@Override
	public List<OrdenesEstudiosVDto> findOneYearOld() {
		String strQuery = "SELECT o FROM OrdenesEstudiosVDto o"; 
		Query query = em.createQuery(strQuery);
		List<OrdenesEstudiosVDto> listOrdenesEstudiosVDto = query.getResultList();
		return listOrdenesEstudiosVDto;
	}

}
