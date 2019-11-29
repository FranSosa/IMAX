package com.dtecimax.ejb.model.as;

import java.io.Serializable;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Date;

public abstract class OrdenesEstudios implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Date sysdate = new Date();
	
	private long numeroOrden;
	private boolean estatus;
	private Timestamp fechaCreacion;
	private Timestamp fechaUltimaActualizacion;
	private String indicacionesDoctor;
	private String infoAdicional;
	private String numeroAlergia;
	private long numeroCita;
	private long numeroDoctor;
	private long numeroEstudio;
	private long numeroPaciente;
	private long numeroUbicacion;
	private boolean requiereFactura;
	private short tipoOrden;
	private short tipoPago;
	private short ubicacionPaciente;
	private long usuarioUltimaActualizacion;
	private Time horaFinalOrden;
	private Time horaInicialOrden;
	
	private Date utilFechaCreacion = sysdate;
	private Date utilFechaUltimaActualizacion = sysdate;
	private Date utilHoraFinalOrden; 
	private Date utilHoraInicialOrden;  
	
	
	public OrdenesEstudios() {
	}

	public long getNumeroOrden() {
		return this.numeroOrden;
	}

	public void setNumeroOrden(long numeroOrden) {
		this.numeroOrden = numeroOrden;
	}

	public boolean getEstatus() {
		return this.estatus;
	}

	public void setEstatus(boolean estatus) {
		this.estatus = estatus;
	}

	public Timestamp getFechaCreacion() {
		return this.fechaCreacion;
	}

	public void setFechaCreacion(Timestamp fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}

	public Timestamp getFechaUltimaActualizacion() {
		return this.fechaUltimaActualizacion;
	}

	public void setFechaUltimaActualizacion(Timestamp fechaUltimaActualizacion) {
		this.fechaUltimaActualizacion = fechaUltimaActualizacion;
	}

	public String getIndicacionesDoctor() {
		return this.indicacionesDoctor;
	}

	public void setIndicacionesDoctor(String indicacionesDoctor) {
		this.indicacionesDoctor = indicacionesDoctor;
	}

	public String getInfoAdicional() {
		return this.infoAdicional;
	}

	public void setInfoAdicional(String infoAdicional) {
		this.infoAdicional = infoAdicional;
	}

	public String getNumeroAlergia() {
		return this.numeroAlergia;
	}

	public void setNumeroAlergia(String numeroAlergia) {
		this.numeroAlergia = numeroAlergia;
	}

	public long getNumeroCita() {
		return this.numeroCita;
	}

	public void setNumeroCita(long numeroCita) {
		this.numeroCita = numeroCita;
	}

	public long getNumeroDoctor() {
		return this.numeroDoctor;
	}

	public void setNumeroDoctor(long numeroDoctor) {
		this.numeroDoctor = numeroDoctor;
	}

	public long getNumeroEstudio() {
		return this.numeroEstudio;
	}

	public void setNumeroEstudio(long numeroEstudio) {
		this.numeroEstudio = numeroEstudio;
	}

	public long getNumeroPaciente() {
		return this.numeroPaciente;
	}

	public void setNumeroPaciente(long numeroPaciente) {
		this.numeroPaciente = numeroPaciente;
	}

	public long getNumeroUbicacion() {
		return this.numeroUbicacion;
	}

	public void setNumeroUbicacion(long numeroUbicacion) {
		this.numeroUbicacion = numeroUbicacion;
	}

	public boolean getRequiereFactura() {
		return this.requiereFactura;
	}

	public void setRequiereFactura(boolean requiereFactura) {
		this.requiereFactura = requiereFactura;
	}

	public short getTipoOrden() {
		return this.tipoOrden;
	}

	public void setTipoOrden(short tipoOrden) {
		this.tipoOrden = tipoOrden;
	}

	public short getTipoPago() {
		return this.tipoPago;
	}

	public void setTipoPago(short tipoPago) {
		this.tipoPago = tipoPago;
	}

	public short getUbicacionPaciente() {
		return this.ubicacionPaciente;
	}

	public void setUbicacionPaciente(short ubicacionPaciente) {
		this.ubicacionPaciente = ubicacionPaciente;
	}

	public long getUsuarioUltimaActualizacion() {
		return this.usuarioUltimaActualizacion;
	}

	public void setUsuarioUltimaActualizacion(long usuarioUltimaActualizacion) {
		this.usuarioUltimaActualizacion = usuarioUltimaActualizacion;
	}

	public Date getUtilFechaCreacion() {
		return utilFechaCreacion;
	}

	public void setUtilFechaCreacion(Date utilFechaCreacion) {
		this.utilFechaCreacion = utilFechaCreacion;
		this.setFechaCreacion(new Timestamp(utilFechaCreacion.getTime()));
	}

	public Date getUtilFechaUltimaActualizacion() {
		return utilFechaUltimaActualizacion;
	}

	public void setUtilFechaUltimaActualizacion(Date utilFechaUltimaActualizacion) {
		this.utilFechaUltimaActualizacion = utilFechaUltimaActualizacion;
		this.setFechaUltimaActualizacion(new Timestamp(utilFechaUltimaActualizacion.getTime()));
	}
	
	public Time getHoraFinalOrden() {
		return horaFinalOrden;
	}

	public void setHoraFinalOrden(Time horaFinalOrden) {
		this.horaFinalOrden = horaFinalOrden;
	}

	public Time getHoraInicialOrden() {
		return horaInicialOrden;
	}

	public void setHoraInicialOrden(Time horaInicialOrden) {
		this.horaInicialOrden = horaInicialOrden;
	}
	
	public Date getUtilHoraFinalOrden() {
		return utilHoraFinalOrden;
	}

	public void setUtilHoraFinalOrden(Date utilHoraFinalOrden) {
		this.utilHoraFinalOrden = utilHoraFinalOrden;
		if(null!=utilHoraFinalOrden) {
			this.setHoraFinalOrden(new java.sql.Time(utilHoraFinalOrden.getTime()));
		}
	}

	public Date getUtilHoraInicialOrden() {
		return utilHoraInicialOrden;
	}

	public void setUtilHoraInicialOrden(Date utilHoraInicialOrden) {
		this.utilHoraInicialOrden = utilHoraInicialOrden;
		if(null!=utilHoraInicialOrden) {
			this.setHoraInicialOrden(new java.sql.Time(utilHoraInicialOrden.getTime()));
		}
	}
	
	/***********************************************************************
	 ***********************************************************************/
	private String nombrePaciente;
	private String nombreDoctor; 
	private String nombreUbicacion; 
	private Timestamp fechaNacimientoPaciente;
	private Date utilFechaNacimientoPaciente; 
	private String edad; 
    private String[] selectedAlergiasPacientes;
    private long costoEstudio; 
    private String nombreEstudio; 
	
	public String[] getSelectedAlergiasPacientes() {
		if(null!=this.numeroAlergia) {
		  return numeroAlergia.split(",");
		}
		return selectedAlergiasPacientes;
	}
	
	public void setSelectedAlergiasPacientes(String[] selectedAlergiasPacientes) {
		String strNumeroAlergia = null; 
		if(null!=selectedAlergiasPacientes) {
			if(selectedAlergiasPacientes.length>0) {
			strNumeroAlergia = "";
			 for(int i=0;i<selectedAlergiasPacientes.length;i++) {
				 strNumeroAlergia = strNumeroAlergia+selectedAlergiasPacientes[i]+",";
	  		  }
			 strNumeroAlergia = strNumeroAlergia.substring(0, strNumeroAlergia.length()-1);
			}
	     }
		setNumeroAlergia(strNumeroAlergia);
		this.selectedAlergiasPacientes = selectedAlergiasPacientes;
	}
	
	public String getNombrePaciente() {
		return nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getNombreDoctor() {
		return nombreDoctor;
	}

	public void setNombreDoctor(String nombreDoctor) {
		this.nombreDoctor = nombreDoctor;
	}

	public String getNombreUbicacion() {
		return nombreUbicacion;
	}

	public void setNombreUbicacion(String nombreUbicacion) {
		this.nombreUbicacion = nombreUbicacion;
	}

	public Timestamp getFechaNacimientoPaciente() {
		return fechaNacimientoPaciente;
	}

	public void setFechaNacimientoPaciente(Timestamp fechaNacimientoPaciente) {
		this.fechaNacimientoPaciente = fechaNacimientoPaciente;
	}

	public Date getUtilFechaNacimientoPaciente() {
		if(null!=this.getFechaNacimientoPaciente()) {
			return new Date(this.getFechaNacimientoPaciente().getTime());
		}
		return utilFechaNacimientoPaciente;
	}

	public void setUtilFechaNacimientoPaciente(Date utilFechaNacimientoPaciente) {
		this.utilFechaNacimientoPaciente = utilFechaNacimientoPaciente;
	}

	public String getEdad() {
		return edad;
	}

	public void setEdad(String edad) {
		this.edad = edad;
	} 
	
	public long getCostoEstudio() {
		return costoEstudio;
	}

	public void setCostoEstudio(long costoEstudio) {
		this.costoEstudio = costoEstudio;
	}

	public String getNombreEstudio() {
		return nombreEstudio;
	}

	public void setNombreEstudio(String nombreEstudio) {
		this.nombreEstudio = nombreEstudio;
	}

		
  /*********************************************************************************
   *********************************************************************************/

	

}