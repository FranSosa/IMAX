package com.dtecimax.ejb.services.admin;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dtecimax.jpa.dao.admin.UsuariosDao;
import com.dtecimax.jpa.dto.admin.UsuariosDto;

@Stateless 
public class UsuariosLocalImpl implements UsuariosLocal {

	@Inject
	UsuariosDao usuariosDao;
	
	@Override
	public void insertUsuarios(UsuariosDto pUsuariosDto) {
		usuariosDao.insertUsuarios(pUsuariosDto);
	}
	
	@Override
	public List<UsuariosDto> findSelectItems() {
		return usuariosDao.findSelectItems();
	}

	@Override
	public UsuariosDto findUbicacionByNumUser(long pNumeroUsuario) {
		return usuariosDao.findByNumeroUsuario(pNumeroUsuario);
	}

	@Override
	public void deleteUsuarios(long pNumeroUsuario) {
		usuariosDao.deleteUsuarios(pNumeroUsuario);
	}

	@Override
	public void updateUsuarios(long pNumeroUsuario, UsuariosDto pUsuariosDto) {
		usuariosDao.updateUsuarios(pNumeroUsuario, pUsuariosDto);
	}

	@Override
	public UsuariosDto findByNombrePassword(String pNombreUsuario, String pPasswordUsuario) {
		return  usuariosDao.findByNombrePassword(pNombreUsuario, pPasswordUsuario);
	}

	@Override
	public List<UsuariosDto> findBySearch(String pSearchNomUsua
			                            , String pSearchApellPatUsua
			                            , String pSearchApellMatUsua) {
	
		return usuariosDao.findBySearch(pSearchNomUsua
				                       ,pSearchApellPatUsua
				                       ,pSearchApellMatUsua
				                       );
	}

}
