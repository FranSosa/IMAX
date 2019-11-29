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

import com.dtecimax.ejb.model.admin.Permisos;
import com.dtecimax.ejb.services.admin.PermisosLocal;
import com.dtecimax.jpa.dto.admin.PermisosDto;

@ManagedBean  
@ViewScoped
public class PermisosForm {
	
	@ManagedProperty(value="#{permisos}") 
	private Permisos permisos;

	private Permisos permisosSelected = new Permisos();
	
	private List<Permisos> listPermisos;
	
	@Inject 
	PermisosLocal permisosLocal;
	
	
	@PostConstruct
	public void init() {
		System.out.println("init() PermisosForm");
		refreshEntity();	
	}
	
	public void selectForUpdate(Permisos pPermisos) {
		System.out.println("Entra selectForUpdate");
		permisosSelected = new Permisos();
		
		permisosSelected.setNumeroPermiso(pPermisos.getNumeroPermiso());
		permisosSelected.setNumeroUbicacion(pPermisos.getNumeroUbicacion());
		permisosSelected.setNumeroModulo(pPermisos.getNumeroModulo());
		permisosSelected.setNumeroPantalla(pPermisos.getNumeroPantalla());
		permisosSelected.setTipoPermiso(pPermisos.getTipoPermiso());
		permisosSelected.setFechaCreacion(pPermisos.getFechaCreacion());
		permisosSelected.setTipoAdministrador(pPermisos.getTipoAdministrador());
		permisosSelected.setEstatus(pPermisos.getEstatus());
		permisosSelected.setFechaUltimaActualizacion(pPermisos.getFechaUltimaActualizacion());
		permisosSelected.setUsuarioUltimaActualizacion(pPermisos.getUsuarioUltimaActualizacion());
		permisosSelected.setComentarios(pPermisos.getComentarios());
		System.out.println("Sale selectForUpdate");
	}
	
	public void selectForDelete(Permisos pPermisos) {
		permisosSelected = new Permisos();
		
		permisosSelected.setNumeroPermiso(pPermisos.getNumeroPermiso());
		permisosSelected.setNumeroUbicacion(pPermisos.getNumeroUbicacion());
		permisosSelected.setNumeroModulo(pPermisos.getNumeroModulo());
		permisosSelected.setNumeroPantalla(pPermisos.getNumeroPantalla());
		permisosSelected.setTipoPermiso(pPermisos.getTipoPermiso());
		permisosSelected.setFechaCreacion(pPermisos.getFechaCreacion());
		permisosSelected.setTipoAdministrador(pPermisos.getTipoAdministrador());
		permisosSelected.setEstatus(pPermisos.getEstatus());
		permisosSelected.setFechaUltimaActualizacion(pPermisos.getFechaUltimaActualizacion());
		permisosSelected.setUsuarioUltimaActualizacion(pPermisos.getUsuarioUltimaActualizacion());
		permisosSelected.setComentarios(pPermisos.getComentarios());
    }
	
	public void actualizaPermiso() {
		boolean updatedIn = false;
		PermisosDto permisosDto = new PermisosDto();
		
		permisosDto.setNumeroModulo(permisosSelected.getNumeroModulo());
		permisosDto.setNumeroPantalla(permisosSelected.getNumeroPantalla());
		permisosDto.setTipoPermiso(permisosSelected.getTipoPermiso());
		permisosDto.setTipoAdministrador(permisosSelected.getTipoAdministrador());
		permisosDto.setEstatus(permisosSelected.getEstatus());
		permisosDto.setFechaUltimaActualizacion(permisosSelected.getFechaUltimaActualizacion());
		permisosDto.setUsuarioUltimaActualizacion(permisosSelected.getUsuarioUltimaActualizacion());
		permisosDto.setComentarios(permisosSelected.getComentarios());
		
		permisosLocal.updatePermisos(permisosSelected.getNumeroPermiso(), permisosDto);
	
		refreshEntity();	
		updatedIn = true; 
		PrimeFaces.current().ajax().addCallbackParam("updatedIn", updatedIn);
	}
	
	public void delete() {
		permisosLocal.deletePermisos(permisosSelected.getNumeroPermiso());
		
		refreshEntity();	
	}
	
	
	public void insertPermisos() {
		
		boolean guardarIn = false;
		
		PermisosDto permisosDto  = new PermisosDto();
		permisosDto.setNumeroUbicacion(permisos.getNumeroUbicacion());
		permisosDto.setNumeroModulo(permisos.getNumeroModulo());
		permisosDto.setNumeroPantalla(permisos.getNumeroPantalla());
		permisosDto.setTipoPermiso(permisos.getTipoPermiso());
		permisosDto.setFechaCreacion(permisos.getFechaCreacion());
		permisosDto.setTipoAdministrador(permisos.getTipoAdministrador());
		permisosDto.setEstatus(permisos.getEstatus());
		permisosDto.setFechaUltimaActualizacion(permisos.getFechaUltimaActualizacion());
		permisosDto.setUsuarioUltimaActualizacion(permisos.getUsuarioUltimaActualizacion());
		permisosDto.setComentarios(permisos.getComentarios());
		
		permisosLocal.insertPermisos(permisosDto);
		
		refreshEntity();	
		guardarIn = true;
		PrimeFaces.current().ajax().addCallbackParam("guardarIn", guardarIn);
		
	};
	
	public Permisos getPermisos() {
		return permisos;
	}

	public void setPermisos(Permisos permisos) {
		this.permisos = permisos;
	}

	public List<Permisos> getListPermisos() {
		return listPermisos;
	}

	public void setListPermisos(List<Permisos> listPermisos) {
		this.listPermisos = listPermisos;
	}
	
	private void refreshEntity() {
		listPermisos = new ArrayList<Permisos>();
		List<PermisosDto> listPermisosDto = permisosLocal.findAll();
		Iterator<PermisosDto> iterPermisosDto =  listPermisosDto.iterator();
		while(iterPermisosDto.hasNext()) {
			PermisosDto permisosDto = iterPermisosDto.next();
			Permisos permisos = new Permisos();
			permisos.setNumeroPermiso(permisosDto.getNumeroPermiso());
			permisos.setNumeroUbicacion(permisosDto.getNumeroUbicacion());
			permisos.setNumeroModulo(permisosDto.getNumeroModulo());
			permisos.setNumeroPantalla(permisosDto.getNumeroPantalla());
			permisos.setTipoPermiso(permisosDto.getTipoPermiso());
			permisos.setTipoAdministrador(permisosDto.getTipoAdministrador());
			permisos.setEstatus(permisosDto.getEstatus());
			permisos.setComentarios(permisosDto.getComentarios());
			listPermisos.add(permisos);
		}		
	}

	public Permisos getPermisosSelected() {
		return permisosSelected;
	}

	public void setPermisosSelected(Permisos permisosSelected) {
		this.permisosSelected = permisosSelected;
	}

}
