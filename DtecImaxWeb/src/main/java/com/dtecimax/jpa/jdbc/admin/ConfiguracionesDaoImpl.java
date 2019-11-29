package com.dtecimax.jpa.jdbc.admin;

import java.math.BigInteger;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dtecimax.jpa.dao.admin.ConfiguracionesDao;
import com.dtecimax.jpa.dto.admin.ConfiguracionesDto;

@Stateless
public class ConfiguracionesDaoImpl implements ConfiguracionesDao {

	@PersistenceContext(unitName = "DTECIMAXPU") 
	EntityManager em;
	
	@Override
	public void insertConfiguraciones(ConfiguracionesDto pConfiguracionesDto) {
		Query q = em.createNativeQuery("SELECT NEXT VALUE FOR dbo.CONFIGURACIONES_S");
		BigInteger lConfiguracionesS = (BigInteger)q.getSingleResult();
		pConfiguracionesDto.setNumeroConfiguracion(lConfiguracionesS.longValue());
		em.persist(pConfiguracionesDto);
	}

}
