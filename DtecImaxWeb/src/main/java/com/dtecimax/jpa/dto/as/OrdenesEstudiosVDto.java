package com.dtecimax.jpa.dto.as;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the ORDENES_ESTUDIOS_V1 database table.
 * 
 */
@Entity
@Table(name="ORDENES_ESTUDIOS_V1")
@NamedQuery(name="OrdenesEstudiosVDto.findAll", query="SELECT o FROM OrdenesEstudiosVDto o")
public class OrdenesEstudiosVDto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="ALERGIAS")
	private String alergias;

	@Column(name="CAST_FECHA_CREACION")
	private Date castFechaCreacion;

	@Column(name="CAST_HORA_FINAL")
	private String castHoraFinal;

	@Column(name="CAST_HORA_INICIAL")
	private String castHoraInicial;

	@Column(name="DECODE_REQUIERE_FACTURA")
	private String decodeRequiereFactura;

	@Column(name="DECODE_TIPO_ORDEN")
	private String decodeTipoOrden;

	@Column(name="DECODE_TIPO_PAGO")
	private String decodeTipoPago;

	@Column(name="ESTATUS")
	private boolean estatus;

	@Column(name="FECHA_CREACION")
	private Timestamp fechaCreacion;

	@Column(name="FECHA_ULTIMA_ACTUALIZACION")
	private Timestamp fechaUltimaActualizacion;

	@Column(name="HORA_FINAL_ORDEN")
	private Time horaFinalOrden;

	@Column(name="HORA_INICIAL_ORDEN")
	private Time horaInicialOrden;

	@Column(name="INDICACIONES_DOCTOR")
	private String indicacionesDoctor;

	@Column(name="INFO_ADICIONAL")
	private String infoAdicional;

	@Column(name="NOMBRE_DOCTOR")
	private String nombreDoctor;

	@Column(name="NOMBRE_ESTUDIO")
	private String nombreEstudio;

	@Column(name="NOMBRE_PACIENTE")
	private String nombrePaciente;

	@Column(name="NOMBRE_UBICACION")
	private String nombreUbicacion;

	@Column(name="NUMERO_ALERGIA")
	private String numeroAlergia;

	@Column(name="NUMERO_CITA")
	private long numeroCita;

	@Column(name="NUMERO_DOCTOR")
	private long numeroDoctor;

	@Id
	@Column(name="NUMERO_ESTUDIO")
	private long numeroEstudio;

	@Column(name="NUMERO_ORDEN")
	private long numeroOrden;

	@Column(name="NUMERO_PACIENTE")
	private long numeroPaciente;

	@Column(name="NUMERO_UBICACION")
	private long numeroUbicacion;

	@Column(name="REQUIERE_FACTURA")
	private boolean requiereFactura;

	@Column(name="TIPO_ORDEN")
	private short tipoOrden;

	@Column(name="TIPO_PAGO")
	private short tipoPago;

	@Column(name="UBICACION_PACIENTE")
	private short ubicacionPaciente;

	@Column(name="USUARIO_ULTIMA_ACTUALIZACION")
	private long usuarioUltimaActualizacion;
	
	@Column(name="CORREO_PACIENTE")
	private String correoPaciente; 

	public OrdenesEstudiosVDto() {
	}

	public String getAlergias() {
		return this.alergias;
	}

	public void setAlergias(String alergias) {
		this.alergias = alergias;
	}

	public Date getCastFechaCreacion() {
		return this.castFechaCreacion;
	}

	public void setCastFechaCreacion(Date castFechaCreacion) {
		this.castFechaCreacion = castFechaCreacion;
	}

	public String getCastHoraFinal() {
		return this.castHoraFinal;
	}

	public void setCastHoraFinal(String castHoraFinal) {
		this.castHoraFinal = castHoraFinal;
	}

	public String getCastHoraInicial() {
		return this.castHoraInicial;
	}

	public void setCastHoraInicial(String castHoraInicial) {
		this.castHoraInicial = castHoraInicial;
	}

	public String getDecodeRequiereFactura() {
		return this.decodeRequiereFactura;
	}

	public void setDecodeRequiereFactura(String decodeRequiereFactura) {
		this.decodeRequiereFactura = decodeRequiereFactura;
	}

	public String getDecodeTipoOrden() {
		return this.decodeTipoOrden;
	}

	public void setDecodeTipoOrden(String decodeTipoOrden) {
		this.decodeTipoOrden = decodeTipoOrden;
	}

	public String getDecodeTipoPago() {
		return this.decodeTipoPago;
	}

	public void setDecodeTipoPago(String decodeTipoPago) {
		this.decodeTipoPago = decodeTipoPago;
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

	public Time getHoraFinalOrden() {
		return this.horaFinalOrden;
	}

	public void setHoraFinalOrden(Time horaFinalOrden) {
		this.horaFinalOrden = horaFinalOrden;
	}

	public Time getHoraInicialOrden() {
		return this.horaInicialOrden;
	}

	public void setHoraInicialOrden(Time horaInicialOrden) {
		this.horaInicialOrden = horaInicialOrden;
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

	public String getNombreDoctor() {
		return this.nombreDoctor;
	}

	public void setNombreDoctor(String nombreDoctor) {
		this.nombreDoctor = nombreDoctor;
	}

	public String getNombreEstudio() {
		return this.nombreEstudio;
	}

	public void setNombreEstudio(String nombreEstudio) {
		this.nombreEstudio = nombreEstudio;
	}

	public String getNombrePaciente() {
		return this.nombrePaciente;
	}

	public void setNombrePaciente(String nombrePaciente) {
		this.nombrePaciente = nombrePaciente;
	}

	public String getNombreUbicacion() {
		return this.nombreUbicacion;
	}

	public void setNombreUbicacion(String nombreUbicacion) {
		this.nombreUbicacion = nombreUbicacion;
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

	public long getNumeroOrden() {
		return this.numeroOrden;
	}

	public void setNumeroOrden(long numeroOrden) {
		this.numeroOrden = numeroOrden;
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

	public String getCorreoPaciente() {
		return correoPaciente;
	}

	public void setCorreoPaciente(String correoPaciente) {
		this.correoPaciente = correoPaciente;
	}

}
