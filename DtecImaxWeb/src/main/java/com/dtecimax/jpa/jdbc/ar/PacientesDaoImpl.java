package com.dtecimax.jpa.jdbc.ar;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dtecimax.jpa.dao.ar.PacientesDao;
import com.dtecimax.jpa.dto.ar.PacientesDto;

@Stateless 
public class PacientesDaoImpl implements PacientesDao{

	@PersistenceContext(unitName = "DTECIMAXPU") 
	EntityManager em;
	
	@Override
	public void insertPacientes(PacientesDto pPacientesDto) {
		Query q = em.createNativeQuery("SELECT NEXT VALUE FOR dbo.PACIENTES_S");
		BigInteger lPacienteS = (BigInteger)q.getSingleResult();
		pPacientesDto.setNumeroPaciente(lPacienteS.longValue()); 
        em.persist(pPacientesDto);
	}

	@Override
	public List<PacientesDto> findSelectItems() {
		return em.createNamedQuery("PacientesDto.findAll").getResultList();
	}

	@Override
	public void deletePacientes(long pNumeroPaciente) {
		PacientesDto pacientesDto = em.find(PacientesDto.class, pNumeroPaciente);
		em.remove(pacientesDto);
	}

	@Override
	public void updatePacientes(long pNumeroPaciente, PacientesDto pPacientesDto) {
		PacientesDto pacientesDto = em.find(PacientesDto.class, pNumeroPaciente);
		
		  pacientesDto.setNombrePaciente(pPacientesDto.getNombrePaciente());
	      pacientesDto.setApellidoPaternoPaciente(pPacientesDto.getApellidoPaternoPaciente());
	      pacientesDto.setApellidoMaternoPaciente(pPacientesDto.getApellidoMaternoPaciente());
	      pacientesDto.setCelularPaciente(pPacientesDto.getCelularPaciente());
	      pacientesDto.setCorreoPaciente(pPacientesDto.getCorreoPaciente());
	      pacientesDto.setCurpPaciente(pPacientesDto.getCurpPaciente());
	      pacientesDto.setDomicilioPaciente(pPacientesDto.getDomicilioPaciente());
	      pacientesDto.setFechaNacimientoPaciente(pPacientesDto.getFechaNacimientoPaciente());
	      System.out.println("**"+pPacientesDto.getEstatus());
	      pacientesDto.setEstatus(pPacientesDto.getEstatus());
	      pacientesDto.setFechaUltimaActualizacion(pPacientesDto.getFechaUltimaActualizacion());
	      pacientesDto.setComentarios(pPacientesDto.getComentarios());
		
	}

	@Override
	public PacientesDto findByNumeroPaciente(long pNumeroPaciente) {
		PacientesDto pacientesDto = em.find(PacientesDto.class, pNumeroPaciente);
		return pacientesDto;
	}

	@Override
	public List<PacientesDto> findBySearch(String pSearchNomPaci
			                             , String pSearchApellPatPaci
		 	                             , String pSearchApellMatPaci) {
		String query = " SELECT d FROM PacientesDto d where 1=1"; 
		if(null!=pSearchNomPaci&&!"".equals(pSearchNomPaci)) {
			query = query+" AND d.nombrePaciente like '%"+pSearchNomPaci+"%' ";
		}
		if(null!=pSearchApellPatPaci&&!"".equals(pSearchApellPatPaci)) {
			query = query+" AND d.apellidoPaternoPaciente like '%"+pSearchApellPatPaci+"%' ";
		}
		if(null!=pSearchApellMatPaci&&!"".equals(pSearchApellMatPaci)) {
			query = query+" AND d.apellidoMaternoPaciente like '%"+pSearchApellMatPaci+"%' ";
		}
		return em.createQuery(query).getResultList();
	}

}
