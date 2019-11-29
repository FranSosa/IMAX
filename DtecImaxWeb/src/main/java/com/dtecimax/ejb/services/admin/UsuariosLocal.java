package com.dtecimax.ejb.services.admin;

import java.util.List;

import javax.ejb.Local;

import com.dtecimax.jpa.dto.admin.UsuariosDto;

@Local
public interface UsuariosLocal {
	
	public void insertUsuarios(UsuariosDto pUsuariosDto);
	
	public List<UsuariosDto> findSelectItems();
	
	public UsuariosDto findUbicacionByNumUser(long pNumeroUsuario);
	
	public void deleteUsuarios(long pNumeroUsuario);
	
	public void updateUsuarios(long pNumeroUsuario, UsuariosDto pUsuariosDto);
	
	public UsuariosDto findByNombrePassword(String pNombreUsuario,String pPasswordUsuario);
	
	public List<UsuariosDto> findBySearch(String pSearchNomUsua
							             ,String pSearchApellPatUsua
							             ,String pSearchApellMatUsua
							             ); 
}
