package com.dtecimax.jpa.jdbc.as;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dtecimax.jpa.dao.as.EstudiosDao;
import com.dtecimax.jpa.dto.as.EstudiosDto;

@Stateless 
public class EstudiosDaoImpl implements EstudiosDao {

	@PersistenceContext(unitName = "DTECIMAXPU") 
	EntityManager em;
	
	@Override
	public void insertEstudios(EstudiosDto pEstudiosDto) {
		Query q = em.createNativeQuery("SELECT NEXT VALUE FOR dbo.ESTUDIOS_S");
		BigInteger lEstudiosS = (BigInteger)q.getSingleResult();
		pEstudiosDto.setNumeroEstudio(lEstudiosS.longValue());
        em.persist(pEstudiosDto);
	}

	@Override
	public List<EstudiosDto> findSelectItems() {
		return em.createNamedQuery("EstudiosDto.findAll").getResultList();
	}
	
	@Override
	public void updateEstudios(long pNumeroEstudio, EstudiosDto pEstudiosDto) {
		
		System.out.println("Entra EstudiosDaoImpl updateEstudios pNumeroEstudio:"+pNumeroEstudio);
		
		EstudiosDto estudiosDto = em.find(EstudiosDto.class, pNumeroEstudio);
		if(null!=estudiosDto) {
		
		estudiosDto.setNombreEstudio(pEstudiosDto.getNombreEstudio());
		estudiosDto.setTipoEstudio(pEstudiosDto.getTipoEstudio());
		estudiosDto.setCostoEstudio(pEstudiosDto.getCostoEstudio());
		estudiosDto.setRealizaEstudio(pEstudiosDto.getRealizaEstudio());
		estudiosDto.setNumeroUbicacion(pEstudiosDto.getNumeroUbicacion());
		estudiosDto.setComentarios(pEstudiosDto.getComentarios());
		estudiosDto.setEstatus(pEstudiosDto.getEstatus());
		estudiosDto.setFechaUltimaActualizacion(pEstudiosDto.getFechaUltimaActualizacion());
		estudiosDto.setUsuarioUltimaActualizacion(pEstudiosDto.getUsuarioUltimaActualizacion());
		estudiosDto.setColorEstudio(pEstudiosDto.getColorEstudio());
		
		
		}
		
	}

	@Override
	public void deleteEstudios(long pNumeroEstudio) {
		EstudiosDto estudiosDto = em.find(EstudiosDto.class, pNumeroEstudio);
		if(null!=estudiosDto) {
			em.remove(estudiosDto);
		}
		
	}

	@Override
	public List<EstudiosDto> findAll() {
		return  em.createNamedQuery("EstudiosDto.findAll").getResultList();
	}

	@Override
	public String findEstudioByNumero(long pNumeroEstudio) {
		Query q = em.createNativeQuery("SELECT NOMBRE_ESTUDIO FROM dbo.ESTUDIOS where NUMERO_ESTUDIO = "+pNumeroEstudio);
		String strNombreEstudio =  (String)q.getSingleResult();
		return strNombreEstudio; 
	}

	@Override
	public EstudiosDto findByNumeroEstudio(long pNumeroEstudio) {
		return em.find(EstudiosDto.class, pNumeroEstudio);
	}

	@Override
	public List<EstudiosDto> findBySearch(String pSearchNomEstu) {
		String strQuery = "SELECT e FROM EstudiosDto e where 1=1"; 
		if(null!=pSearchNomEstu&&!"".equals(pSearchNomEstu)) {
			strQuery = strQuery+" AND e.nombreEstudio like '%"+pSearchNomEstu+"%'"; 
		}
		return em.createQuery(strQuery).getResultList();
	}

	@Override
	public List<String> findColorsEstudio() {
		String strQuery = "SELECT distinct e.colorEstudio FROM EstudiosDto e"; 
		Query query = em.createQuery(strQuery); 
		List<String> listColorEstudio = query.getResultList(); 
		return listColorEstudio;
	}

}
