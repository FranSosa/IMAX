package com.dtecimax.jpa.jdbc.hr;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dtecimax.jpa.dao.hr.DoctoresDao;
import com.dtecimax.jpa.dto.hr.DoctoresDto;

@Stateless 
public class DoctoresDaoImpl implements DoctoresDao {

	@PersistenceContext(unitName = "DTECIMAXPU") 
	EntityManager em;
	
	@Override
	public void insertDoctores(DoctoresDto pDoctoresDto) {
		Query q = em.createNativeQuery("SELECT NEXT VALUE FOR dbo.DOCTORES_S");
		BigInteger lDoctoresS = (BigInteger)q.getSingleResult();
		pDoctoresDto.setNumeroDoctor(lDoctoresS.longValue());
        em.persist(pDoctoresDto);
	}

	@Override
	public List<DoctoresDto> findSelectItems() {
		return em.createNamedQuery("DoctoresDto.findAll").getResultList();
	}

	@Override
	public List<DoctoresDto> findAll() {
		return em.createNamedQuery("DoctoresDto.findAll").getResultList();
	}

	@Override
	public void deleteDoctores(long pNumeroDoctor) {
		DoctoresDto doctoresDto = em.find(DoctoresDto.class, pNumeroDoctor);
		em.remove(doctoresDto);
	}

	@Override
	public void updateDoctores(long pNumeroDoctor, DoctoresDto pDoctoresDto) {
		DoctoresDto doctoresDto = em.find(DoctoresDto.class, pNumeroDoctor);
		
		doctoresDto.setNombreDoctor(pDoctoresDto.getNombreDoctor());
		doctoresDto.setNumeroUbicacion(pDoctoresDto.getNumeroUbicacion());
		doctoresDto.setApellidoMaternoDoctor(pDoctoresDto.getApellidoMaternoDoctor());
		doctoresDto.setApellidoPaternoDoctor(pDoctoresDto.getApellidoPaternoDoctor());
		doctoresDto.setFechaNacimientoDoctor(pDoctoresDto.getFechaNacimientoDoctor());
		doctoresDto.setCedulaDoctor(pDoctoresDto.getCedulaDoctor());
		doctoresDto.setCelularDoctor(pDoctoresDto.getCelularDoctor());
		doctoresDto.setCurpDoctor(pDoctoresDto.getCurpDoctor());
		doctoresDto.setDomicilioDoctor(pDoctoresDto.getDomicilioDoctor());
		doctoresDto.setTipoDoctor(pDoctoresDto.getTipoDoctor());
		doctoresDto.setCorreoDoctor(pDoctoresDto.getCorreoDoctor());
		doctoresDto.setEstatus(pDoctoresDto.getEstatus());
		doctoresDto.setFechaUltimaActualizacion(pDoctoresDto.getFechaUltimaActualizacion());
		doctoresDto.setComentarios(pDoctoresDto.getComentarios());
		
	}

	@Override
	public DoctoresDto findByNumeroDoctor(long pNumeroDoctor) {
		return em.find(DoctoresDto.class, pNumeroDoctor);
	}

	@Override
	public List<DoctoresDto> findBySearch(String pSearchNomDoct
			                             ,String pSearchApellPatDoc
			                             ,String pSearchApellMatDoc
			                             ) {
		String query = " SELECT d FROM DoctoresDto d where 1=1"; 
		if(null!=pSearchNomDoct&&!"".equals(pSearchNomDoct)) {
			query = query+" AND d.nombreDoctor like '%"+pSearchNomDoct+"%' ";
		}
		if(null!=pSearchApellPatDoc&&!"".equals(pSearchApellPatDoc)) {
			query = query+" AND d.apellidoPaternoDoctor like '%"+pSearchApellPatDoc+"%' ";
		}
		if(null!=pSearchApellMatDoc&&!"".equals(pSearchApellMatDoc)) {
			query = query+" AND d.apellidoMaternoDoctor like '%"+pSearchApellMatDoc+"%' ";
		}
		return em.createQuery(query).getResultList();
	}

}
