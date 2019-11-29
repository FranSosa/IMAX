package com.dtecimax.ejb.backing.email;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import com.dtecimax.ejb.model.email.NotificacionesV;
import com.dtecimax.ejb.services.email.NotificacionesVLocal;
import com.dtecimax.jpa.dto.email.NotificacionesVDto;

import java.util.List; 
import java.util.ArrayList;
import java.util.Iterator; 

@ManagedBean  
@ViewScoped
public class NotificacionesForm {

	@Inject
	NotificacionesVLocal notificacionesVLocal;
	
	
	private List<NotificacionesV> listNotificacionesV = new ArrayList<NotificacionesV>() ;

	private java.util.Date fechaDesde; 
	private java.util.Date fechaHasta;
	
	@PostConstruct
    public void init() {
		java.util.Date utilCurrentDate = new java.util.Date(); 
		java.sql.Date sqlCurrentDate = new java.sql.Date(utilCurrentDate.getTime());
		List<NotificacionesVDto> listNotificacionesVDto = notificacionesVLocal.findByCurrentSysdate(sqlCurrentDate);
		Iterator<NotificacionesVDto> iterNotificacionesVDto =  listNotificacionesVDto.iterator(); 
		while(iterNotificacionesVDto.hasNext()) {
			NotificacionesV notificacionesV = new NotificacionesV();
			NotificacionesVDto notificacionesVDto = iterNotificacionesVDto.next();
			notificacionesV.setNombrePaciente(notificacionesVDto.getNombrePaciente());
			notificacionesV.setCorreoElectronico(notificacionesVDto.getCorreoElectronico());
			notificacionesV.setVcharSubject(notificacionesVDto.getVcharSubject());
			notificacionesV.setVcharBody(notificacionesVDto.getVcharBody());
			notificacionesV.setFechaCreacion(notificacionesVDto.getFechaCreacion());
			listNotificacionesV.add(notificacionesV); 	
		}
		
    }
	
	public void filtraPorFechas() {
		
		java.sql.Date sqlFechaDesde = new java.sql.Date(this.fechaDesde.getTime()); 
		java.sql.Date sqlFechaHasta = new java.sql.Date(this.fechaHasta.getTime()); 
		listNotificacionesV = new ArrayList<NotificacionesV>() ;
		List<NotificacionesVDto> listNotificacionesVDto = notificacionesVLocal.findByDates(sqlFechaDesde, sqlFechaHasta);
		Iterator<NotificacionesVDto> iterNotificacionesVDto =  listNotificacionesVDto.iterator(); 
		while(iterNotificacionesVDto.hasNext()) {
			NotificacionesV notificacionesV = new NotificacionesV();
			NotificacionesVDto notificacionesVDto = iterNotificacionesVDto.next();
			notificacionesV.setNombrePaciente(notificacionesVDto.getNombrePaciente());
			notificacionesV.setCorreoElectronico(notificacionesVDto.getCorreoElectronico());
			notificacionesV.setVcharSubject(notificacionesVDto.getVcharSubject());
			notificacionesV.setVcharBody(notificacionesVDto.getVcharBody());
			notificacionesV.setFechaCreacion(notificacionesVDto.getFechaCreacion());
			listNotificacionesV.add(notificacionesV); 	
		}
		
	} 

	
	public List<NotificacionesV> getListNotificacionesV() {
		return listNotificacionesV;
	}

	public void setListNotificacionesV(List<NotificacionesV> listNotificacionesV) {
		this.listNotificacionesV = listNotificacionesV;
	}


	public java.util.Date getFechaDesde() {
		return fechaDesde;
	}


	public void setFechaDesde(java.util.Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}


	public java.util.Date getFechaHasta() {
		return fechaHasta;
	}


	public void setFechaHasta(java.util.Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	
}
