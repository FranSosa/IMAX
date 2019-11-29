package com.dtecimax.jpa.jdbc.as;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dtecimax.jpa.dao.as.CitasDao;
import com.dtecimax.jpa.dto.as.CitasDto;

@Stateless 
public class CitasDaoImpl implements CitasDao {

	@PersistenceContext(unitName = "DTECIMAXPU") 
	EntityManager em;
	
	@Override
	public void insertCitas(CitasDto pCitasDto) {
		Query q = em.createNativeQuery("SELECT NEXT VALUE FOR dbo.CITAS_S");
		BigInteger lCitasS = (BigInteger)q.getSingleResult();
		pCitasDto.setNumeroCita(lCitasS.longValue());
        em.persist(pCitasDto);
	}

	@Override
	public List<CitasDto> findSelectItems() {
		return em.createNamedQuery("CitasDto.findAll").getResultList();
	}

	@Override
	public List<CitasDto> findAll() {
		return em.createNamedQuery("CitasDto.findAll").getResultList();
	}

	@Override
	public CitasDto findByNumeroCita(long pNumeroCita) {
		return em.find(CitasDto.class, pNumeroCita);
	}

	@Override
	public List<CitasDto> findAllByNumDoc(long pNumeroDoctor
			                             ,String pSearchTipoEstu
			                             ) {
		String strQuery = "SELECT c FROM CitasDto c where 1=1";
		if(0!=pNumeroDoctor) {
			strQuery = strQuery+" AND c.numeroDoctor = "+pNumeroDoctor;
		}
		if(null!=pSearchTipoEstu&&!"".equals(pSearchTipoEstu)) {
			strQuery = strQuery+" AND c.numeroEstudio in (SELECT e.numeroEstudio FROM EstudiosDto e where e.tipoEstudio = '"+pSearchTipoEstu+"')";
		}
		Query query = em.createQuery(strQuery);
		List<CitasDto> results = query.getResultList();
		return results;
	}

	@Override
	public void actualizaCitas(CitasDto pCitasDto, long pNumeroCita) {
		CitasDto citasDto = em.find(CitasDto.class, pNumeroCita);
		System.out.println("DaoImpl NumeroPaciente:"+citasDto.getNumeroPaciente());
		citasDto.setNumeroPaciente(pCitasDto.getNumeroPaciente());
		citasDto.setNumeroEstudio(pCitasDto.getNumeroEstudio());
		citasDto.setNumeroDoctor(pCitasDto.getNumeroDoctor());
		citasDto.setFechaCita(pCitasDto.getFechaCita());
		citasDto.setHoraInicialCita(pCitasDto.getHoraInicialCita());
		citasDto.setHoraFinalCita(pCitasDto.getHoraFinalCita());
	}

	@Override
	public void deleteCita(long pNumeroCita) {
		CitasDto citasDto = em.find(CitasDto.class, pNumeroCita); 
		em.remove(citasDto);
	}

}
