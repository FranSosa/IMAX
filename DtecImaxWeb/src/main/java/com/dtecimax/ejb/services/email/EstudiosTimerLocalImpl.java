package com.dtecimax.ejb.services.email;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.TimerService;
import javax.inject.Inject;
import com.dtecimax.ejb.services.as.OrdenesEstudiosVLocal;
import com.dtecimax.ejb.services.email.SessionBeanLocal;
import com.dtecimax.jpa.dto.as.OrdenesEstudiosVDto;
import com.dtecimax.jpa.dto.email.NotificacionesDto;

@Singleton
@Startup
public class EstudiosTimerLocalImpl implements EstudiosTimerLocal{
	@Resource
    TimerService timerService;

	@Inject
	OrdenesEstudiosVLocal ordenesEstudiosVLocal; 
	
	@Inject 
	SessionBeanLocal sessionBeanLocal; 
	
	@Inject 
	NotificacionesLocal notificacionesLocal; 
	
	private Date lastAutomaticTimeout;

	public Date getLastAutomaticTimeout() {
		return lastAutomaticTimeout;
	}

	public void setLastAutomaticTimeout(Date lastAutomaticTimeout) {
		this.lastAutomaticTimeout = lastAutomaticTimeout;
	}
	
	 @Schedule(hour = "*/10",minute = "*/47", persistent = false)
	  public void automaticTimeout() {
	    this.setLastAutomaticTimeout(new Date());
	      
	    List<OrdenesEstudiosVDto> listOrdenesEstudios = ordenesEstudiosVLocal.findOneYearOld();
	    Iterator<OrdenesEstudiosVDto> iterOrdenesEstudios = listOrdenesEstudios.iterator(); 
	    while(iterOrdenesEstudios.hasNext()) {
	    	OrdenesEstudiosVDto ordenesEstudiosVDto = iterOrdenesEstudios.next(); 
	    	System.out.println(ordenesEstudiosVDto.getNombrePaciente()+" - "+ordenesEstudiosVDto.getCorreoPaciente());
	    	
	    	String strSubject = "Aviso importante Ordenes Estudios"; 
	    	String strBody = "Buen dia, el presente es para recordarle que hace un anio se realizo un estudio con nosotros y como sugerencia dicho examen debe realizarse anualmente.\r\n" + 
                             "Le sugerimos ponerse en contacto para agendar una cita."; 
	    	
	    	sessionBeanLocal.sendEmail(ordenesEstudiosVDto.getCorreoPaciente()
	    			                  , strSubject
	    			                  , strBody
	    			                  );
	    	
	    	java.util.Date utilSysdate = new java.util.Date(); 
	    	java.sql.Timestamp sqlSysdate = new java.sql.Timestamp(utilSysdate.getTime()); 
	    	NotificacionesDto  notificacionesDto = new NotificacionesDto(); 
	    	
	    	notificacionesDto.setNumeroPaciente(ordenesEstudiosVDto.getNumeroPaciente());
	    	notificacionesDto.setCorreoElectronico(ordenesEstudiosVDto.getCorreoPaciente());
	    	notificacionesDto.setVcharSubject(strSubject);
	    	notificacionesDto.setVcharBody(strBody);
	    	
	    	notificacionesDto.setCreadoPor(-1l);
	    	notificacionesDto.setFechaCreacion(sqlSysdate);
	    	notificacionesDto.setActualizadoPor(-1l);
	    	notificacionesDto.setFechaActualizacion(sqlSysdate);
	    	
	    	notificacionesLocal.insert(notificacionesDto);
	    	
	    	break;
	    }
	 }



}
