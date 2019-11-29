package com.dtecimax.ejb.helpers;

import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;
import javax.inject.Inject;
import com.dtecimax.ejb.services.admin.PermisosLocal;
import com.dtecimax.ejb.services.admin.UbicacionesLocal;
import com.dtecimax.ejb.services.admin.UsuariosLocal;
import com.dtecimax.ejb.services.ar.AlergiasPacientesLocal;
import com.dtecimax.ejb.services.ar.PacientesLocal;
import com.dtecimax.ejb.services.as.CitasLocal;
import com.dtecimax.ejb.services.as.EstudiosLocal;
import com.dtecimax.ejb.services.as.InterpretacionesLocal;
import com.dtecimax.ejb.services.as.OrdenesEstudiosLocal;
import com.dtecimax.ejb.services.hr.DoctoresLocal;
import com.dtecimax.jpa.dto.admin.PermisosDto;
import com.dtecimax.jpa.dto.admin.UbicacionesDto;
import com.dtecimax.jpa.dto.admin.UsuariosDto;
import com.dtecimax.jpa.dto.ar.AlergiasPacientesDto;
import com.dtecimax.jpa.dto.ar.PacientesDto;
import com.dtecimax.jpa.dto.as.CitasDto;
import com.dtecimax.jpa.dto.as.EstudiosDto;
import com.dtecimax.jpa.dto.as.InterpretacionesDto;
import com.dtecimax.jpa.dto.as.OrdenesEstudiosDto;
import com.dtecimax.jpa.dto.hr.DoctoresDto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@ManagedBean  
@RequestScoped
public class AdminHelper {
	
	@Inject
	UbicacionesLocal ubicacionesLocal;
	
	@Inject
	UsuariosLocal usuariosLocal;
	
	@Inject
	DoctoresLocal doctoresLocal;
	
	@Inject
	PacientesLocal pacientesLocal;
	
	@Inject
	EstudiosLocal estudiosLocal;
	
	@Inject
	CitasLocal citasLocal;
	
	@Inject
	AlergiasPacientesLocal alergiasPacientesLocal;
	
	@Inject
	OrdenesEstudiosLocal ordenesEstudiosLocal;
	
	@Inject
	InterpretacionesLocal interpretacionesLocal;
	
	@Inject
	PermisosLocal permisosLocal;
	
	private String styles; 
	
	public List<SelectItem> getSelectUbicacionesItems() {
		List<SelectItem> lselectUbicacionesItems = new ArrayList<SelectItem>();
		List<UbicacionesDto> lisUbicacionesDto = ubicacionesLocal.findSelectItems();
		Iterator<UbicacionesDto> iterUbicacionesDto = lisUbicacionesDto.iterator();
		while(iterUbicacionesDto.hasNext()) {
			UbicacionesDto ubicacionesDto = iterUbicacionesDto.next();
			SelectItem selectItem = new SelectItem(ubicacionesDto.getNumeroUbicacion(),ubicacionesDto.getNombreUbicacion());
			lselectUbicacionesItems.add(selectItem);
		}
      return lselectUbicacionesItems;
	}
	
	public List<SelectItem> getSelectUsuariosItems(){
		List<SelectItem> lselectUsuariosItems = new ArrayList<SelectItem>();
		List<UsuariosDto> lisUsuariosDto = usuariosLocal.findSelectItems();
		Iterator<UsuariosDto> iterUsuariosDto = lisUsuariosDto.iterator();
		while(iterUsuariosDto.hasNext()) {
			UsuariosDto usuariosDto = iterUsuariosDto.next();
			SelectItem selectItem = new SelectItem(usuariosDto.getNumeroUsuario(),usuariosDto.getNombreUsuario());
			lselectUsuariosItems.add(selectItem);
		}
		
		return lselectUsuariosItems;
	}
	
	public List<SelectItem> getSelectDoctoresItems(){
		List<SelectItem> lselectDoctoresItems = new ArrayList<SelectItem>();
		List<DoctoresDto> lisDoctoresDto = doctoresLocal.findSelectItems();
		Iterator<DoctoresDto> iterDoctoresDto = lisDoctoresDto.iterator();
		while(iterDoctoresDto.hasNext()) {
			DoctoresDto doctoresDto =iterDoctoresDto.next();
			SelectItem selectItem = new SelectItem(doctoresDto.getNumeroDoctor(),doctoresDto.getNombreDoctor()+" "+doctoresDto.getApellidoPaternoDoctor()+" "+doctoresDto.getApellidoMaternoDoctor());
			lselectDoctoresItems.add(selectItem);
		}
		return lselectDoctoresItems;
	}
	
	public List<SelectItem> getSelectPacientesItems(){
		List<SelectItem> lselectPacientesItems = new ArrayList<SelectItem>();
		List<PacientesDto> lisPacientesDto = pacientesLocal.findSelectItems();
		Iterator<PacientesDto> iterPacientesDto = lisPacientesDto.iterator();
		while(iterPacientesDto.hasNext()) {
			PacientesDto pacientesDto = iterPacientesDto.next();
			SelectItem selectItem = new SelectItem(pacientesDto.getNumeroPaciente(),pacientesDto.getNombrePaciente()+" "+pacientesDto.getApellidoPaternoPaciente()+" "+pacientesDto.getApellidoMaternoPaciente());
			lselectPacientesItems.add(selectItem);
		}
		return lselectPacientesItems;
	}
	
	public List<SelectItem> getSelectEstudiosItems(){
		List<SelectItem> lselectEstudiosItems = new ArrayList<SelectItem>();
		List<EstudiosDto> lisEstudiosDto = estudiosLocal.findSelectItems();
		Iterator<EstudiosDto> iterEstudiosDto = lisEstudiosDto.iterator();
		while(iterEstudiosDto.hasNext()) {
			EstudiosDto estudiosDto = iterEstudiosDto.next();
			SelectItem selectItem = new SelectItem(estudiosDto.getNumeroEstudio(),estudiosDto.getNombreEstudio());
			lselectEstudiosItems.add(selectItem);
		}
		return lselectEstudiosItems;
	}
	

	public List<SelectItem> getSelectCitasItems(){
		List<SelectItem> lselectCitasItems = new ArrayList<SelectItem>();
		List<CitasDto> lisEstudiosDto = citasLocal.findSelectItems();
		Iterator<CitasDto> iterEstudiosDto = lisEstudiosDto.iterator();
		while(iterEstudiosDto.hasNext()) {
			CitasDto citasDto = iterEstudiosDto.next();
			SelectItem selectItem = new SelectItem(citasDto.getNumeroCita(),citasDto.getNumeroCita()+"");
			lselectCitasItems.add(selectItem);
		}
		return lselectCitasItems;
	}
	
	
	public List<SelectItem> getSelectTipoOrdenItems(){
		List<SelectItem> lselectTipoOrdenItems = new ArrayList<SelectItem>();
		SelectItem selectItem = new SelectItem(1,"Simple");
		SelectItem selectItem2 = new SelectItem(2,"Dentales");
		SelectItem selectItem3 = new SelectItem(3,"Contrastados");
		SelectItem selectItem4 = new SelectItem(3,"Especiales");
		lselectTipoOrdenItems.add(selectItem);
		lselectTipoOrdenItems.add(selectItem2);
		lselectTipoOrdenItems.add(selectItem3);
		lselectTipoOrdenItems.add(selectItem4);
		return lselectTipoOrdenItems;
	}
	
	public List<SelectItem> getSelectTipoEstudiosItems(){
		List<SelectItem> lselectTipoEstudioItems = new ArrayList<SelectItem>();
		SelectItem selectItem = new SelectItem("Placa Simple","Placa Simple");
		lselectTipoEstudioItems.add(selectItem);
		selectItem = new SelectItem("Estudios Contrastados","Estudios Contrastados");
		lselectTipoEstudioItems.add(selectItem);
		selectItem = new SelectItem("Angiografias","Angiografias");
		lselectTipoEstudioItems.add(selectItem);
		selectItem = new SelectItem("Biopsias y procedimientos especiales","Biopsias y procedimientos especiales");
		lselectTipoEstudioItems.add(selectItem);
		selectItem = new SelectItem("Ultrasonidos","Ultrasonidos");
		lselectTipoEstudioItems.add(selectItem);
		selectItem = new SelectItem("Mamografia","Mamografia");
		lselectTipoEstudioItems.add(selectItem);
		selectItem = new SelectItem("Tomografía","Tomografía");
		lselectTipoEstudioItems.add(selectItem);
		selectItem = new SelectItem("Estudios especiales de TAC","Estudios especiales de TAC");
		lselectTipoEstudioItems.add(selectItem);
		selectItem = new SelectItem("Resonancia magnética","Resonancia magnética");
		lselectTipoEstudioItems.add(selectItem);
		selectItem = new SelectItem("Densitometria","Densitometria");
		lselectTipoEstudioItems.add(selectItem);
		selectItem = new SelectItem("Baropodometria","Baropodometria");
		lselectTipoEstudioItems.add(selectItem);
		selectItem = new SelectItem("Densitometria","Densitometria");
		lselectTipoEstudioItems.add(selectItem);
		selectItem = new SelectItem("Radiología dental","Radiología dental");
		lselectTipoEstudioItems.add(selectItem);
		
		return lselectTipoEstudioItems; 
	}
	
	public List<SelectItem> getSelectTipoPagoItems(){
		List<SelectItem> lselectTipoPagoItems = new ArrayList<SelectItem>();
		
		SelectItem selectItem = new SelectItem(1,"Efectivo");
		SelectItem selectItem2 = new SelectItem(2,"Tarjeta Bancaria");
		SelectItem selectItem3 = new SelectItem(3,"Tarjeta de credito");
		
		lselectTipoPagoItems.add(selectItem);
		lselectTipoPagoItems.add(selectItem2);
		lselectTipoPagoItems.add(selectItem3);
		
		return lselectTipoPagoItems;
	}
	
	public List<SelectItem> getSelectAlergiasPacientesItems(){
		List<SelectItem> lselectAlergiasPacientesItems = new ArrayList<SelectItem>();
		List<AlergiasPacientesDto> listAlergiasPacientesDto = alergiasPacientesLocal.findSelectItems();
		Iterator<AlergiasPacientesDto>  iterAlergiasPacientesDto = listAlergiasPacientesDto.iterator();
		while(iterAlergiasPacientesDto.hasNext()) {
			AlergiasPacientesDto alergiasPacientesDto = iterAlergiasPacientesDto.next();
			SelectItem selectItem = new SelectItem(alergiasPacientesDto.getNumeroAlergia(),alergiasPacientesDto.getNombreAlergia());
			lselectAlergiasPacientesItems.add(selectItem);
		}
		return lselectAlergiasPacientesItems; 
	}
	
	public List<SelectItem> getSelectUbicacionPacienteItems(){
		List<SelectItem> lselectUbicacionPacienteItems = new ArrayList<SelectItem>();
		
		SelectItem selectItem = new SelectItem(1,"IMAX");
		SelectItem selectItem2 = new SelectItem(2,"Centro Medico");
		
		lselectUbicacionPacienteItems.add(selectItem);
		lselectUbicacionPacienteItems.add(selectItem2);
		
		return lselectUbicacionPacienteItems;
	}
	
	public List<SelectItem> getSelectOrdenesEstudiosItems(){
		List<SelectItem> lselectOrdenesEstudiosItems = new ArrayList<SelectItem>();
		List<OrdenesEstudiosDto> listOrdenesEstudiosDto = ordenesEstudiosLocal.findSelectItems();
		Iterator<OrdenesEstudiosDto> iterOrdenesEstudiosDto = listOrdenesEstudiosDto.iterator();
		while(iterOrdenesEstudiosDto.hasNext()) {
			OrdenesEstudiosDto ordenesEstudiosDto = iterOrdenesEstudiosDto.next();
			SelectItem selectItem = new SelectItem(ordenesEstudiosDto.getNumeroOrden(),ordenesEstudiosDto.getNumeroOrden()+"");
			lselectOrdenesEstudiosItems.add(selectItem);
		}
		return lselectOrdenesEstudiosItems; 
	}
	
	
	public List<SelectItem> getSelectInterpretacionesItems(){
		List<SelectItem> lselectInterpretacionesItems = new ArrayList<SelectItem>();
		List<InterpretacionesDto> listInterpretacionesDto = interpretacionesLocal.findSelectItems();
		Iterator<InterpretacionesDto> iterInterpretacionesDto = listInterpretacionesDto.iterator();
		while(iterInterpretacionesDto.hasNext()) {
			InterpretacionesDto InterpretacionesDto = iterInterpretacionesDto.next();
			SelectItem selectItem = new SelectItem(InterpretacionesDto.getNumeroInterpretacion(),InterpretacionesDto.getInterpretacion());
			lselectInterpretacionesItems.add(selectItem);
		}
		return lselectInterpretacionesItems; 
	}

	public List<SelectItem> getSelectModulosItems(){
		List<SelectItem> lselectModulosItems = new ArrayList<SelectItem>();
		SelectItem selectItem1 = new SelectItem("1","Modulo1");
		SelectItem selectItem2 = new SelectItem("2","Modulo2");
		SelectItem selectItem3 = new SelectItem("3","Modulo3");
		lselectModulosItems.add(selectItem1);
		lselectModulosItems.add(selectItem2);
		lselectModulosItems.add(selectItem3);
		return lselectModulosItems; 
	}
	
	public List<SelectItem> getSelectPantallasItems(){
		List<SelectItem> lselectPantallasItems = new ArrayList<SelectItem>();
		SelectItem selectItem1 = new SelectItem("1","Pantalla1");
		SelectItem selectItem2 = new SelectItem("2","Pantalla2");
		SelectItem selectItem3 = new SelectItem("3","Pantalla3");
		lselectPantallasItems.add(selectItem1);
		lselectPantallasItems.add(selectItem2);
		lselectPantallasItems.add(selectItem3);
		return lselectPantallasItems; 
	}
	
	public List<SelectItem> getSelectTipoPermisosItems(){
		List<SelectItem> lselectPantallasItems = new ArrayList<SelectItem>();
		SelectItem selectItem1 = new SelectItem("1","Completo");
		SelectItem selectItem2 = new SelectItem("2","Solo Lectura");
		lselectPantallasItems.add(selectItem1);
		lselectPantallasItems.add(selectItem2);
		return lselectPantallasItems; 
	}
	
	public String descUbicacion(long pNumeroUbicacion) {
		UbicacionesDto ubicacionesDto = ubicacionesLocal.findByNumeroUbicacion(pNumeroUbicacion);
		return ubicacionesDto.getNombreUbicacion();
	}
	
	public List<SelectItem> getSelectPermisosItems(){
		List<SelectItem> lselectPermisosItems = new ArrayList<SelectItem>();
		List<PermisosDto> listPermisosDto = permisosLocal.findAll();
		Iterator<PermisosDto> iterPermisosDto = listPermisosDto.iterator();
		System.out.println("Debug**"+iterPermisosDto);
		while(iterPermisosDto.hasNext()) {
			PermisosDto permisosDto = iterPermisosDto.next();
			SelectItem selectItem1 = new SelectItem(permisosDto.getNumeroPermiso(),"Modulo-Pantalla"+permisosDto.getNumeroPermiso());
			lselectPermisosItems.add(selectItem1);
		}
		return lselectPermisosItems; 
	}
	
	public List<SelectItem> getSelectColorEstudiosItems(){
		List<SelectItem> lselectColorsItems = new ArrayList<SelectItem>();
		List<String> listStrColors = estudiosLocal.findColorsEstudio(); 
		Iterator<String> iterStrColors = listStrColors.iterator(); 
		while(iterStrColors.hasNext()) {
			String color = iterStrColors.next();
			SelectItem selectItem = new SelectItem(color,color); 
			lselectColorsItems.add(selectItem); 
		}
		return lselectColorsItems; 
	}
	
	public String getStyles() {
		/****** Example .dtecimaxblue         {background-color:blue !important; } **/
		StringBuffer buff = new StringBuffer(); 
		List<String> listStrColors = estudiosLocal.findColorsEstudio(); 
		Iterator<String> iterStrColors = listStrColors.iterator(); 
		while(iterStrColors.hasNext()) {
			String color = iterStrColors.next();
			buff.append(" .dimax"+color+" {background-color:#"+color+" !important;} "); 
		}
		this.styles = buff.toString(); 
		return this.styles; 
		
	}


	public void setStyles(String styles) {
		this.styles = styles;
	}
	
	public List<SelectItem> getSelectOrdenesItems(){
		List<SelectItem> lselectOrdenesItems = new ArrayList<SelectItem>();
		SelectItem selectItem1 = new SelectItem("OrdenesSimples","Ordenes Simples");
		SelectItem selectItem2 = new SelectItem("OrdenesEspeciales","Ordenes Especiales");
		SelectItem selectItem3 = new SelectItem("OrdenesContrastados","Ordenes Contrastados");
		SelectItem selectItem4 = new SelectItem("OrdenesDentales","Ordenes Dentales");
		
		lselectOrdenesItems.add(selectItem1);
		lselectOrdenesItems.add(selectItem2);
		lselectOrdenesItems.add(selectItem3);
		lselectOrdenesItems.add(selectItem4);
		
		return lselectOrdenesItems; 
	}
	
	
}
