
package com.dtecimax.ejb.backing.admin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ValueChangeEvent;
import javax.inject.Inject;
import org.primefaces.PrimeFaces;
import com.dtecimax.ejb.model.admin.PermisosUsuarios;
import com.dtecimax.ejb.services.admin.PermisosUsuariosLocal;
import com.dtecimax.jpa.dto.admin.PermisosUsuariosDto;




@ManagedBean  
@ViewScoped
public class PermisosUsuariosForm {
	
	@ManagedProperty(value="#{permisosUsuarios}")
	private PermisosUsuarios permisosUsuarios;
	
	@Inject
	PermisosUsuariosLocal permisosUsuariosLocal;
	
	private List<PermisosUsuarios> listPermisosUsuarios = new ArrayList<PermisosUsuarios>();

	private PermisosUsuarios permisosUsuariosSelected = new PermisosUsuarios();
	
	private String strPantalla; 
	private String strModulo;
	private String strTipoPermiso; 
	
	 @PostConstruct
	 public void init() {
		 System.out.println("PermisosUsuariosForm init()");
		 refreshEntity();	 
	 }
	
	
	 
	public void insertPermisosUsuarios() {
		boolean loggedIn = false;
		System.out.println("Comienza insertaPermisosUsuarios");
		PermisosUsuariosDto permisosUsuariosDto = new PermisosUsuariosDto();
		
		/** David Esto hacer en el DAO 
		permisosUsuariosDto.setNumeroPermisoUsuario(permisosUsuarios.getNumeroPermisoUsuario());
		***/
		permisosUsuariosDto.setNumeroUsuario(permisosUsuarios.getNumeroUsuario());
		permisosUsuariosDto.setNumeroUbicacion(permisosUsuarios.getNumeroUbicacion());
		permisosUsuariosDto.setNumeroPermiso(permisosUsuarios.getNumeroPermiso());
		permisosUsuariosDto.setEstatus(permisosUsuarios.getEstatus());
		permisosUsuariosDto.setFechaCreacion(permisosUsuarios.getFechaCreacion());
		permisosUsuariosDto.setFechaUltimaActualizacion(permisosUsuarios.getFechaUltimaActualizacion());
		permisosUsuariosDto.setComentarios(permisosUsuarios.getComentarios());
		
		permisosUsuariosLocal.insertPermisosUsuarios(permisosUsuariosDto);
		
		refreshEntity();	
		
		loggedIn = true;
		PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
	
	
	}

	public void selectForDelete(PermisosUsuarios pPermisosUsuarios) {
		permisosUsuariosSelected = new PermisosUsuarios();
		permisosUsuariosSelected.setNumeroPermisoUsuario(pPermisosUsuarios.getNumeroPermisoUsuario());
		
	}
	
	public void selectForUpdate(PermisosUsuarios pPermisosUsuarios) {
		System.out.println("Entra selectForUpdate");
		System.out.println(pPermisosUsuarios);
		
		permisosUsuariosSelected = new PermisosUsuarios();
		
		permisosUsuariosSelected.setNumeroUsuario(pPermisosUsuarios.getNumeroUsuario());
		permisosUsuariosSelected.setNumeroPermisoUsuario(pPermisosUsuarios.getNumeroPermisoUsuario());
		permisosUsuariosSelected.setNumeroUbicacion(pPermisosUsuarios.getNumeroUbicacion());
		permisosUsuariosSelected.setComentarios(pPermisosUsuarios.getComentarios());
		permisosUsuariosSelected.setEstatus(pPermisosUsuarios.getEstatus());
		
	}
	public void delete() {
		System.out.println("Entra Delete PermisosUsuarios Form");
		System.out.println(this.permisosUsuariosSelected);
		if(null!=permisosUsuariosSelected) {
			permisosUsuariosLocal.deletePermisosUsuarios(permisosUsuariosSelected.getNumeroPermisoUsuario());
			refreshEntity();
		}
	}
	
	 public void actualizaPermisosUsuarios() {
	    	System.out.println("Entra actualizaPermisosUsuarios Form");
			System.out.println(this.permisosUsuariosSelected);
			boolean updatedIn = false;
			
			PermisosUsuariosDto permisosUsuariosDto = new PermisosUsuariosDto();
			
			permisosUsuariosDto.setNumeroUsuario(permisosUsuariosSelected.getNumeroUsuario());
			permisosUsuariosDto.setComentarios(permisosUsuariosSelected.getComentarios());
			permisosUsuariosDto.setEstatus(permisosUsuariosSelected.getEstatus());
			
			permisosUsuariosLocal.updatePermisosUsuarios(permisosUsuariosSelected.getNumeroPermisoUsuario(), permisosUsuariosDto);
			refreshEntity();
			updatedIn = true;
			PrimeFaces.current().ajax().addCallbackParam("updatedIn", updatedIn);
	    }		
	 public PermisosUsuarios getPermisosUsuarios() {
			return permisosUsuarios;
		}

		public void setPermisosUsuarios(PermisosUsuarios permisosUsuarios) {
			this.permisosUsuarios = permisosUsuarios;
		}




		public PermisosUsuarios getPermisosUsuariosSelected() {
			System.out.println("getPermisosUsuariosSelected:"+permisosUsuariosSelected);
			return permisosUsuariosSelected;
		}


		public void setPermisosUsuariosSelected(PermisosUsuarios permisosUsuariosSelected) {
			this.permisosUsuariosSelected = permisosUsuariosSelected;
		}
		
		private void refreshEntity() {
			 
			 listPermisosUsuarios = new ArrayList<PermisosUsuarios>();
			 
			 List<PermisosUsuariosDto> listPermisosUsuariosDto = permisosUsuariosLocal.findAll();
			 Iterator<PermisosUsuariosDto> iterPermisosUsuariosDto = listPermisosUsuariosDto.iterator();
			 listPermisosUsuariosDto = new ArrayList<PermisosUsuariosDto>();
			 while(iterPermisosUsuariosDto.hasNext()) {
				 PermisosUsuariosDto permisosUsuariosDto = iterPermisosUsuariosDto.next();
				 
				 PermisosUsuarios permisosUsuarios = new PermisosUsuarios();
				 
				 permisosUsuarios.setNumeroUsuario(permisosUsuariosDto.getNumeroUsuario());
				 permisosUsuarios.setNumeroPermisoUsuario(permisosUsuariosDto.getNumeroPermisoUsuario());
				 permisosUsuarios.setNumeroUbicacion(permisosUsuariosDto.getNumeroUbicacion());
				 permisosUsuarios.setEstatus(permisosUsuariosDto.getEstatus());
				 permisosUsuarios.setComentarios(permisosUsuariosDto.getComentarios());
				 
				 listPermisosUsuarios.add(permisosUsuarios);
			 }
			 
		}
		
		
		public void permisoChangeEvent(ValueChangeEvent event) {
			
			String strEventNewValue = event.getNewValue().toString();
			if("1".equals(strEventNewValue)) {
				strPantalla = "Pantalla1";
				strModulo = "Modulo1";
				strTipoPermiso = "TipoPermiso1";
			}else if("2".equals(strEventNewValue)) {
				strPantalla = "Pantalla2";
				strModulo = "Modulo2";
				strTipoPermiso = "TipoPermiso2";
			}
		}

		public String getStrPantalla() {
			return strPantalla;
		}

		public void setStrPantalla(String strPantalla) {
			this.strPantalla = strPantalla;
		}

		public String getStrModulo() {
			return strModulo;
		}

		public void setStrModulo(String strModulo) {
			this.strModulo = strModulo;
		}

		public String getStrTipoPermiso() {
			return strTipoPermiso;
		}

		public void setStrTipoPermiso(String strTipoPermiso) {
			this.strTipoPermiso = strTipoPermiso;
		}
		
		public List<PermisosUsuarios> getListPermisosUsuarios() {
			return listPermisosUsuarios;
		}

		public void setListPermisosUsuarios(List<PermisosUsuarios> listPermisosUsuarios) {
			this.listPermisosUsuarios = listPermisosUsuarios;
		}
	
}
