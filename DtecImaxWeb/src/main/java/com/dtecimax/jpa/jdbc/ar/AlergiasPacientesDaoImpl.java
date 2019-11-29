package com.dtecimax.jpa.jdbc.ar;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dtecimax.jpa.dao.ar.AlergiasPacientesDao;
import com.dtecimax.jpa.dto.ar.AlergiasPacientesDto;

@Stateless 
public class AlergiasPacientesDaoImpl implements AlergiasPacientesDao {

	@PersistenceContext(unitName = "DTECIMAXPU") 
	EntityManager em;
	
	@Override
	public void insetAlergiasPacientes(AlergiasPacientesDto pAlergiasPacientesDto) {
		Query q = em.createNativeQuery("SELECT NEXT VALUE FOR dbo.ALERGIAS_PACIENTES_S");
		BigInteger lAlergiaPacienteS = (BigInteger)q.getSingleResult();
		pAlergiasPacientesDto.setNumeroAlergia(lAlergiaPacienteS.longValue()); 
        em.persist(pAlergiasPacientesDto);
	}
	
	@Override
	public List<AlergiasPacientesDto> findSelectItems() {
		return em.createNamedQuery("AlergiasPacientesDto.findAll").getResultList();
	}

	@Override
	public List<AlergiasPacientesDto> findAll() {
		return em.createNamedQuery("AlergiasPacientesDto.findAll").getResultList();
	}

	@Override
	public void updateAlergiasPacientes(long pNumeroAlergia
			                           , AlergiasPacientesDto pAlergiasPacientesDto) {
		AlergiasPacientesDto alergiasPacientesDto = new AlergiasPacientesDto();
		alergiasPacientesDto = em.find(AlergiasPacientesDto.class, pNumeroAlergia); 
		alergiasPacientesDto.setNombreAlergia(pAlergiasPacientesDto.getNombreAlergia());
		alergiasPacientesDto.setDescripcion(pAlergiasPacientesDto.getDescripcion());
	}

	@Override
	public void deleteAlergiasPacientes(long pNumeroAlergia) {
		AlergiasPacientesDto alergiasPacientesDto = new AlergiasPacientesDto();
		alergiasPacientesDto = em.find(AlergiasPacientesDto.class, pNumeroAlergia); 
		em.remove(alergiasPacientesDto);
	}
}
