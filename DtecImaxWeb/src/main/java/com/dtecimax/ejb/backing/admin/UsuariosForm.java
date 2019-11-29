package com.dtecimax.ejb.backing.admin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.PrimeFaces;

import com.dtecimax.ejb.model.admin.Usuarios;
import com.dtecimax.ejb.services.admin.UsuariosLocal;
import com.dtecimax.jpa.dto.admin.UsuariosDto;

@ManagedBean  
@ViewScoped
public class UsuariosForm {

	@ManagedProperty(value="#{usuarios}") 
	private Usuarios usuarios;

	private Usuarios usuariosSelected = new Usuarios();
	
	private List<Usuarios> listUsuarios = new ArrayList<Usuarios>(); 
	
	private String searchNomUsua; 
	private String searchApellPatUsua; 
	private String searchApellMatUsua; 
	
	
	@Inject
	UsuariosLocal usuariosLocal;
	
	 @PostConstruct
	 public void init() {
		 refreshEntity();
	 }
	 
	 public void refreshEntity() {
	
		 List<UsuariosDto> listUsuariosDto = usuariosLocal.findSelectItems();
		 Iterator<UsuariosDto> iterUsuariosDto =  listUsuariosDto.iterator();
		 
		 if(listUsuarios.size()>0) {
			 listUsuarios.removeAll(listUsuarios);
		 }
		 
		 while(iterUsuariosDto.hasNext()) {
			 UsuariosDto usuariosDto = iterUsuariosDto.next();
			 Usuarios usuarios = new Usuarios();
			
			 usuarios.setNumeroUsuario(usuariosDto.getNumeroUsuario());
			 usuarios.setNumeroUbicacion(usuariosDto.getNumeroUbicacion());
			 usuarios.setClaveUsuario(usuariosDto.getClaveUsuario());
			 usuarios.setNombreUsuario(usuariosDto.getNombreUsuario());
			 usuarios.setApellidoPaternoUsuario(usuariosDto.getApellidoPaternoUsuario());
			 usuarios.setApellidoMaternoUsuario(usuariosDto.getApellidoMaternoUsuario());
			 usuarios.setContrasenaUsuario(usuariosDto.getContrasenaUsuario());
			 usuarios.setEstatus(usuariosDto.getEstatus());
			 usuarios.setFechaCreacion(usuariosDto.getFechaCreacion());
			 usuarios.setFechaUltimaActualizacion(usuariosDto.getFechaUltimaActualizacion());
			 usuarios.setComentarios(usuariosDto.getComentarios());
		     
			 listUsuarios.add(usuarios);
			 
		 }
		 
	 }
	 
	public void insertUsuarios() {
		boolean loggedIn = false;
		
		UsuariosDto usuariosDto = new UsuariosDto();
		
		usuariosDto.setNumeroUbicacion(usuarios.getNumeroUbicacion());
		usuariosDto.setClaveUsuario(usuarios.getClaveUsuario());
		usuariosDto.setNombreUsuario(usuarios.getNombreUsuario());
		usuariosDto.setApellidoPaternoUsuario(usuarios.getApellidoPaternoUsuario());
		usuariosDto.setApellidoMaternoUsuario(usuarios.getApellidoMaternoUsuario());
		usuariosDto.setContrasenaUsuario(usuarios.getContrasenaUsuario());
		usuariosDto.setEstatus(usuarios.getEstatus());
		usuariosDto.setFechaCreacion(usuarios.getFechaCreacion());
		usuariosDto.setFechaUltimaActualizacion(usuarios.getFechaUltimaActualizacion());
		usuariosDto.setComentarios(usuarios.getComentarios());
		
		usuariosLocal.insertUsuarios(usuariosDto);
		refreshEntity();
		loggedIn = true;
		PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
	}
	
	public void selectForUpdate(Usuarios pUsuarios) {
		
		usuariosSelected.setNumeroUsuario(pUsuarios.getNumeroUsuario());
		usuariosSelected.setNumeroUbicacion(pUsuarios.getNumeroUbicacion());
		usuariosSelected.setClaveUsuario(pUsuarios.getClaveUsuario());
		usuariosSelected.setNombreUsuario(pUsuarios.getNombreUsuario());
		usuariosSelected.setApellidoPaternoUsuario(pUsuarios.getApellidoPaternoUsuario());
		usuariosSelected.setApellidoMaternoUsuario(pUsuarios.getApellidoMaternoUsuario());
		usuariosSelected.setContrasenaUsuario(pUsuarios.getContrasenaUsuario());
		usuariosSelected.setEstatus(pUsuarios.getEstatus());
		usuariosSelected.setFechaCreacion(pUsuarios.getFechaCreacion());
		usuariosSelected.setFechaUltimaActualizacion(pUsuarios.getFechaUltimaActualizacion());
		usuariosSelected.setComentarios(pUsuarios.getComentarios());
		
	}
	
	public void selectForDelete(Usuarios pUsuarios) {
		usuariosSelected.setNumeroUsuario(pUsuarios.getNumeroUsuario());
		usuariosSelected.setNumeroUbicacion(pUsuarios.getNumeroUbicacion());
		usuariosSelected.setClaveUsuario(pUsuarios.getClaveUsuario());
		usuariosSelected.setNombreUsuario(pUsuarios.getNombreUsuario());
		usuariosSelected.setApellidoPaternoUsuario(pUsuarios.getApellidoPaternoUsuario());
		usuariosSelected.setApellidoMaternoUsuario(pUsuarios.getApellidoMaternoUsuario());
		usuariosSelected.setContrasenaUsuario(pUsuarios.getContrasenaUsuario());
		usuariosSelected.setEstatus(pUsuarios.getEstatus());
		usuariosSelected.setFechaCreacion(pUsuarios.getFechaCreacion());
		usuariosSelected.setFechaUltimaActualizacion(pUsuarios.getFechaUltimaActualizacion());
		usuariosSelected.setComentarios(pUsuarios.getComentarios());
		
	}
	
	public void delete() {
		if(null!=usuariosSelected) {
			usuariosLocal.deleteUsuarios(usuariosSelected.getNumeroUsuario());
		}
		refreshEntity();
	}
	
	public void actualizaUsuario() {
		boolean updatedIn = false;
		UsuariosDto usuariosDto = new UsuariosDto();
		
		usuariosDto.setNumeroUbicacion(usuariosSelected.getNumeroUbicacion());
		usuariosDto.setClaveUsuario(usuariosSelected.getClaveUsuario());
		usuariosDto.setNombreUsuario(usuariosSelected.getNombreUsuario());
		usuariosDto.setApellidoPaternoUsuario(usuariosSelected.getApellidoPaternoUsuario());
		usuariosDto.setApellidoMaternoUsuario(usuariosSelected.getApellidoMaternoUsuario());
		usuariosDto.setContrasenaUsuario(usuariosSelected.getContrasenaUsuario());
		usuariosDto.setEstatus(usuariosSelected.getEstatus());
		usuariosDto.setFechaUltimaActualizacion(usuariosSelected.getFechaUltimaActualizacion());
		usuariosDto.setComentarios(usuariosSelected.getComentarios());
		
		usuariosLocal.updateUsuarios(usuariosSelected.getNumeroUsuario(), usuariosDto);
		refreshEntity();
		updatedIn = true;
		PrimeFaces.current().ajax().addCallbackParam("updatedIn", updatedIn);
	}
	
	public void search() {
		if((null!=this.searchNomUsua||!"".equals(this.searchNomUsua))
		 ||(null!=this.searchApellMatUsua||!"".equals(this.searchApellMatUsua)) 
		 ||(null!=this.searchApellPatUsua||!"".equals(this.searchApellPatUsua)) 
		  ){
			
			 List<UsuariosDto> listUsuariosDto = usuariosLocal.findBySearch(this.searchNomUsua
					                                                      , this.searchApellMatUsua
					                                                      , this.searchApellPatUsua
					                                                      ); 
			 
			 Iterator<UsuariosDto> iterUsuariosDto =  listUsuariosDto.iterator();
			 
			 if(listUsuarios.size()>0) {
				 listUsuarios.removeAll(listUsuarios);
			 }
			 
			 while(iterUsuariosDto.hasNext()) {
				 UsuariosDto usuariosDto = iterUsuariosDto.next();
				 Usuarios usuarios = new Usuarios();
				
				 usuarios.setNumeroUsuario(usuariosDto.getNumeroUsuario());
				 usuarios.setNumeroUbicacion(usuariosDto.getNumeroUbicacion());
				 usuarios.setClaveUsuario(usuariosDto.getClaveUsuario());
				 usuarios.setNombreUsuario(usuariosDto.getNombreUsuario());
				 usuarios.setApellidoPaternoUsuario(usuariosDto.getApellidoPaternoUsuario());
				 usuarios.setApellidoMaternoUsuario(usuariosDto.getApellidoMaternoUsuario());
				 usuarios.setContrasenaUsuario(usuariosDto.getContrasenaUsuario());
				 usuarios.setEstatus(usuariosDto.getEstatus());
				 usuarios.setFechaCreacion(usuariosDto.getFechaCreacion());
				 usuarios.setFechaUltimaActualizacion(usuariosDto.getFechaUltimaActualizacion());
				 usuarios.setComentarios(usuariosDto.getComentarios());
			     
				 listUsuarios.add(usuarios);
				 
			 }
			
		}
	}
	
	public Usuarios getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public Usuarios getUsuariosSelected() {
		return usuariosSelected;
	}

	public void setUsuariosSelected(Usuarios usuariosSelected) {
		this.usuariosSelected = usuariosSelected;
	}

	public List<Usuarios> getListUsuarios() {
		return listUsuarios;
	}

	public void setListUsuarios(List<Usuarios> listUsuarios) {
		this.listUsuarios = listUsuarios;
	}

	public String getSearchNomUsua() {
		return searchNomUsua;
	}

	public void setSearchNomUsua(String searchNomUsua) {
		this.searchNomUsua = searchNomUsua;
	}

	public String getSearchApellPatUsua() {
		return searchApellPatUsua;
	}

	public void setSearchApellPatUsua(String searchApellPatUsua) {
		this.searchApellPatUsua = searchApellPatUsua;
	}

	public String getSearchApellMatUsua() {
		return searchApellMatUsua;
	}

	public void setSearchApellMatUsua(String searchApellMatUsua) {
		this.searchApellMatUsua = searchApellMatUsua;
	}
	
	
}
