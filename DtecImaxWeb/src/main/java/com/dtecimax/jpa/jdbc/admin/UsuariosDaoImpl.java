package com.dtecimax.jpa.jdbc.admin;

import java.math.BigInteger;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dtecimax.jpa.dao.admin.UsuariosDao;
import com.dtecimax.jpa.dto.admin.UsuariosDto;

@Stateless
public class UsuariosDaoImpl implements UsuariosDao {

	@PersistenceContext(unitName = "DTECIMAXPU") 
	EntityManager em;
	
	@Override
	public void insertUsuarios(UsuariosDto pUsuariosDto) {
		Query q = em.createNativeQuery("SELECT NEXT VALUE FOR dbo.USUARIOS_S");
		BigInteger lUsuariosS = (BigInteger)q.getSingleResult();
		pUsuariosDto.setNumeroUsuario(lUsuariosS.longValue());
        em.persist(pUsuariosDto);
	}

	@Override
	public List<UsuariosDto> findSelectItems() {
		return em.createNamedQuery("UsuariosDto.findAll").getResultList();
	}

	@Override
	public UsuariosDto findByNumeroUsuario(long pNumeroUsuario) {
		UsuariosDto usuariosDto = em.find(UsuariosDto.class, pNumeroUsuario);
		return usuariosDto; 
	}

	@Override
	public void deleteUsuarios(long pNumeroUsuario) {
		UsuariosDto usuariosDto = em.find(UsuariosDto.class, pNumeroUsuario);
	    em.remove(usuariosDto);	
	}

	@Override
	public void updateUsuarios(long pNumeroUsuario, UsuariosDto pUsuariosDto) {
		UsuariosDto usuariosDto = em.find(UsuariosDto.class, pNumeroUsuario);
		
		usuariosDto.setNumeroUbicacion(pUsuariosDto.getNumeroUbicacion());
		usuariosDto.setClaveUsuario(pUsuariosDto.getClaveUsuario());
		usuariosDto.setNombreUsuario(pUsuariosDto.getNombreUsuario());
		usuariosDto.setApellidoPaternoUsuario(pUsuariosDto.getApellidoPaternoUsuario());
		usuariosDto.setApellidoMaternoUsuario(pUsuariosDto.getApellidoMaternoUsuario());
		usuariosDto.setContrasenaUsuario(pUsuariosDto.getContrasenaUsuario());
		usuariosDto.setEstatus(pUsuariosDto.getEstatus());
		usuariosDto.setFechaUltimaActualizacion(pUsuariosDto.getFechaUltimaActualizacion());
		usuariosDto.setComentarios(pUsuariosDto.getComentarios());
		
	}

	@Override
	public UsuariosDto findByNombrePassword(String pNombreUsuario
			                              , String pPasswordUsuario) {
		UsuariosDto retval = new UsuariosDto();
		String jpql = "SELECT u FROM UsuariosDto u where u.nombreUsuario = :pNombreUsuario and u.contrasenaUsuario = :pContrasenaUsuario ";
		Query q = em.createQuery(jpql);
		q.setParameter("pNombreUsuario", pNombreUsuario);
		q.setParameter("pContrasenaUsuario", pPasswordUsuario);
		retval = (UsuariosDto)q.getSingleResult();
		return retval;
	}

	@Override
	public List<UsuariosDto> findBySearch(String pSearchNomUsua
			                             ,String pSearchApellPatUsua
			                             ,String pSearchApellMatUsua
			                             ) {
		String query = " SELECT u FROM UsuariosDto u where 1=1"; 
		if(null!=pSearchNomUsua&&!"".equals(pSearchNomUsua)) {
			query = query+" AND u.nombreUsuario like '%"+pSearchNomUsua+"%' ";
		}
		if(null!=pSearchApellPatUsua&&!"".equals(pSearchApellPatUsua)) {
			query = query+" AND u.apellidoMaternoUsuario like '%"+pSearchApellPatUsua+"%' ";
		}
		if(null!=pSearchApellMatUsua&&!"".equals(pSearchApellMatUsua)) {
			query = query+" AND u.apellidoPaternoUsuario like '%"+pSearchApellMatUsua+"%' ";
		}
		return em.createQuery(query).getResultList();
	}

}
