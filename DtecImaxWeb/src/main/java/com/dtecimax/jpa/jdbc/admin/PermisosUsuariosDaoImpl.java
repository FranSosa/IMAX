package com.dtecimax.jpa.jdbc.admin;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dtecimax.jpa.dao.admin.PermisosUsuariosDao;
import com.dtecimax.jpa.dto.admin.PermisosUsuariosDto;


@Stateless 
public class PermisosUsuariosDaoImpl implements PermisosUsuariosDao {

	@PersistenceContext(unitName = "DTECIMAXPU") 
	EntityManager em;
	
	@Override
	public void insertPermisosUsuario(PermisosUsuariosDto pPermisosUsuariosDto) {
		Query q = em.createNativeQuery("SELECT NEXT VALUE FOR dbo.PERMISOS_USUARIOS_S");
		BigInteger lPermisosUsuarioS = (BigInteger)q.getSingleResult();
		/** David no confundir la llave primaria com la llave foranea
		pPermisosUsuariosDto.setNumeroPermiso(lPermisosUsuarioS.longValue());
		**/
		pPermisosUsuariosDto.setNumeroPermisoUsuario(lPermisosUsuarioS.longValue());
        em.persist(pPermisosUsuariosDto);
	}
	
	@Override
	public List<PermisosUsuariosDto> findAll() {
		return  em.createNamedQuery("PermisosUsuariosDto.findAll").getResultList();
	}

	
	@Override
	public List<PermisosUsuariosDto> findSelectItems() {
		return  em.createNamedQuery("PermisosUsuariosDto.findAll").getResultList();
	}


	@Override
	public PermisosUsuariosDto findByNumeroPermisoUsuario(long pNumeroPermisoUsuario) {
		PermisosUsuariosDto permisosUsuariosDto = new PermisosUsuariosDto();
		permisosUsuariosDto = em.find(PermisosUsuariosDto.class, pNumeroPermisoUsuario);
		return permisosUsuariosDto;
	}

	@Override
	public void deletePermisosUsuario(long pNumeroPermisoUsuario) {
		PermisosUsuariosDto PermisosUsuariosDto = em.find(PermisosUsuariosDto.class, pNumeroPermisoUsuario);
		em.remove(PermisosUsuariosDto);
		
	}

	@Override
	public void updatePermisosUsuario(long pNumeroPermisoUsuario, PermisosUsuariosDto pPermisosUsuarios) {
		PermisosUsuariosDto permisosUsuariosDto = em.find(PermisosUsuariosDto.class, pNumeroPermisoUsuario);
		
		permisosUsuariosDto.setComentarios(pPermisosUsuarios.getComentarios());
		permisosUsuariosDto.setEstatus(pPermisosUsuarios.getEstatus());
	}
		
	}


