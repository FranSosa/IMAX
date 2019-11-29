package com.dtecimax.jpa.jdbc.admin;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dtecimax.jpa.dao.admin.PermisosDao;
import com.dtecimax.jpa.dto.admin.PermisosDto;

@Stateless 
public class PermisosDaoImpl implements PermisosDao {

	@PersistenceContext(unitName = "DTECIMAXPU") 
	EntityManager em;
	
	@Override
	public void insertPermisos(PermisosDto pPermisosDto) {
		Query q = em.createNativeQuery("SELECT NEXT VALUE FOR dbo.PERMISOS_S");
		BigInteger lPermisosUsuarioS = (BigInteger)q.getSingleResult();
		pPermisosDto.setNumeroPermiso(lPermisosUsuarioS.longValue());
        em.persist(pPermisosDto);
	}

	@Override
	public List<PermisosDto> findAll() {
		return  em.createNamedQuery("PermisosDto.findAll").getResultList();
	}

	@Override
	public void updatePermisos(long pNumeroPermiso, PermisosDto pPermisosDto) {
		
		System.out.println("Entra PermisosDaoImpl updatePermisos pNumeroPermiso:"+pNumeroPermiso);
		
		PermisosDto permisosDto = em.find(PermisosDto.class, pNumeroPermiso);
		if(null!=permisosDto) {
		permisosDto.setNumeroModulo(pPermisosDto.getNumeroModulo());
		permisosDto.setNumeroPantalla(pPermisosDto.getNumeroPantalla());
		permisosDto.setTipoPermiso(pPermisosDto.getTipoPermiso());
		permisosDto.setTipoAdministrador(pPermisosDto.getTipoAdministrador());
		permisosDto.setEstatus(pPermisosDto.getEstatus());
		permisosDto.setFechaUltimaActualizacion(pPermisosDto.getFechaUltimaActualizacion());
		permisosDto.setUsuarioUltimaActualizacion(pPermisosDto.getUsuarioUltimaActualizacion());
		permisosDto.setComentarios(pPermisosDto.getComentarios());
		}
		
	}

	@Override
	public void deletePermisos(long pNumeroPermiso) {
		PermisosDto permisosDto = em.find(PermisosDto.class, pNumeroPermiso);
		if(null!=permisosDto) {
			em.remove(permisosDto);
		}
		
	}

}
