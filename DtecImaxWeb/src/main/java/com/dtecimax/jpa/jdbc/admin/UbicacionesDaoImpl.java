package com.dtecimax.jpa.jdbc.admin;

import java.math.BigInteger;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dtecimax.jpa.dao.admin.UbicacionesDao;
import com.dtecimax.jpa.dto.admin.UbicacionesDto;

@Stateless 
public class UbicacionesDaoImpl implements UbicacionesDao {

	@PersistenceContext(unitName = "DTECIMAXPU") 
	EntityManager em;

	
	public void insertUbicaciones(UbicacionesDto pUbicaciones) {
		Query q = em.createNativeQuery("SELECT NEXT VALUE FOR dbo.UBICACIONES_S");
		BigInteger lUbicacionesS = (BigInteger)q.getSingleResult();
		pUbicaciones.setNumeroUbicacion(lUbicacionesS.longValue());
        em.persist(pUbicaciones);
	}

	
	@Override
	public void deleteUbicaciones(long pNumeroUbicacion) {
		UbicacionesDto UbicacionesDto = em.find(UbicacionesDto.class, pNumeroUbicacion);
		em.remove(UbicacionesDto);
	}

	@Override
	public void updateUbicaciones(long pNumeroUbicacion, UbicacionesDto pUbicaciones) {
		UbicacionesDto ubicacionesDto = em.find(UbicacionesDto.class, pNumeroUbicacion);
		
		ubicacionesDto.setNombreUbicacion(pUbicaciones.getNombreUbicacion());
		ubicacionesDto.setDomicilioUbicacion(pUbicaciones.getDomicilioUbicacion());
		ubicacionesDto.setCorreoUbicacion(pUbicaciones.getCorreoUbicacion());
		ubicacionesDto.setHorarioUbicacion(pUbicaciones.getHorarioUbicacion());
		ubicacionesDto.setTelefonoUbicacion(pUbicaciones.getTelefonoUbicacion());
		ubicacionesDto.setComentarios(pUbicaciones.getComentarios());
		ubicacionesDto.setEstatus(pUbicaciones.getEstatus());
	}

	
	@Override
	public List<UbicacionesDto> findAll() {
		return  em.createNamedQuery("UbicacionesDto.findAll").getResultList();
	}

	
	@Override
	public List<UbicacionesDto> findSelectItems() {
		return  em.createNamedQuery("UbicacionesDto.findAll").getResultList();
	}


	@Override
	public UbicacionesDto findByNumeroUbicacion(long pNumeroUbicacion) {
		UbicacionesDto ubicacionesDto = new UbicacionesDto();
		ubicacionesDto = em.find(UbicacionesDto.class, pNumeroUbicacion);
		return ubicacionesDto;
	}

}
