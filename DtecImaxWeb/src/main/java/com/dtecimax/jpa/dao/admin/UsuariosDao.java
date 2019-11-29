package com.dtecimax.jpa.dao.admin;

import java.util.List;

import com.dtecimax.jpa.dto.admin.UsuariosDto;

public interface UsuariosDao {

	public void insertUsuarios(UsuariosDto pUsuariosDto);
	
	public void deleteUsuarios(long pNumeroUsuario);
	
	public void updateUsuarios(long pNumeroUsuario,UsuariosDto pUsuariosDto);
	
	public List<UsuariosDto> findSelectItems();
	
	public UsuariosDto findByNumeroUsuario(long pNumeroUsuario);
	
	public UsuariosDto findByNombrePassword(String pNombreUsuario,String pPasswordUsuario);
	
	public List<UsuariosDto> findBySearch(
										  String pSearchNomUsua
							             ,String pSearchApellPatUsua
							             ,String pSearchApellMatUsua
							             );
	
}
