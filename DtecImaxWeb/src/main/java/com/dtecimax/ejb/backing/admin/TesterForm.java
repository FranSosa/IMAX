package com.dtecimax.ejb.backing.admin;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

@ManagedBean  
@RequestScoped
public class TesterForm {

	public String citasAction() {
        addMessage("Bienvenido a la pantalla de Citas.!!");
         return "/dtecimax/as/Citas";
    }
 
	public String pacientesAction() {
		  addMessage("Bienvenido a la pantalla de Pacientes.!!");
	      return "/dtecimax/ar/Pacientes";
	}
	
	public String ubicacionesAction() {
		 addMessage("Bienvenido a la pantalla de Ubicaciones.!!");
	      return "/dtecimax/admin/Ubicaciones";
	}
	
	public String permisosAction() {
		  addMessage("Bienvenido a la pantalla de Doctores.!!");
	      return "/dtecimax/admin/Permisos";
	}
	
	public String permisosUsuariosAction() {
		  addMessage("Bienvenido a la pantalla de Permisos Usuarios.!!");
	      return "/dtecimax/admin/PermisosUsuarios";
	}
	
	public String usuariosAction() {
		 addMessage("Bienvenido a la pantalla de Usuarios.!!");
	      return "/dtecimax/admin/Usuarios";
	}
	
	public String doctoresAction() {
		  addMessage("Bienvenido a la pantalla de Doctores.!!");
	      return "/dtecimax/hr/Doctores";
	}
	
	public String alergiasPacientesAction() {
		addMessage("Bienvenido a la pantalla de Alergias Pacientes.!!");
	    return "/dtecimax/ar/AlergiasPacientes";
	}
	
	public String ordenesSimplesAction() {
		  addMessage("Bienvenido a la pantalla de Ordenes Simples.!!");
	      return "/dtecimax/as/OrdenesSimples";
	}
	
	public String ordenesEspecialesAction() {
		  addMessage("Bienvenido a la pantalla de Ordenes Especiales.!!");
	      return "/dtecimax/as/OrdenesEspeciales";
	}
	
	public String ordenesContrastadosAction() {
		  addMessage("Bienvenido a la pantalla de Ordenes Contrastados.!!");
	      return "/dtecimax/as/OrdenesContrastados";
	}
	
	public String ordenesDentalesAction() {
		  addMessage("Bienvenido a la pantalla de Ordenes Dentales.!!");
	      return "/dtecimax/as/OrdenesDentales";
	}
	
	public String estudiosAction() {
		 addMessage("Bienvenido a la pantalla de Estudios.!!");
	      return "/dtecimax/as/Estudios";
	}
	
    public void addMessage(String summary) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

}
