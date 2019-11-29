package com.dtecimax.ejb.backing.as;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import org.primefaces.event.SelectEvent;

import com.dtecimax.ejb.model.as.ResumenCitas;
import com.dtecimax.ejb.services.as.ResumenCitasLocal;
import com.dtecimax.jpa.dto.as.ResumenCitasVDto;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List; 

@ManagedBean  
@ViewScoped
public class ResumenCitasForm {

	@Inject
	ResumenCitasLocal resumenCitasLocal;
	
	private List<ResumenCitas> listResumenCitas;
	
	private java.util.Date fechaFiltro; 
	
	private Date sysdate = new Date();
	

	@PostConstruct
	public void init() {
		Timestamp sysTimestamp = new Timestamp(sysdate.getTime()); 
		
		 listResumenCitas = new ArrayList<ResumenCitas>();
			List<String> listHrsIni  = resumenCitasLocal.findHorasIniciales(sysTimestamp);
			Iterator<String> iterHrsIni =  listHrsIni.iterator(); 
			while(iterHrsIni.hasNext()) {
				String hrIni = iterHrsIni.next(); 
				List<ResumenCitasVDto> listEstuUltr =  resumenCitasLocal.findEstuUltr(sysTimestamp, hrIni);
				int sizeEstuUltr =  listEstuUltr.size(); 
				List<ResumenCitasVDto> listMamDens =  resumenCitasLocal.findMamDens(sysTimestamp, hrIni);
				int sizeMamDens =  listMamDens.size(); 
				List<ResumenCitasVDto> listResTac =  resumenCitasLocal.findResTac(sysTimestamp, hrIni);
				int sizeResTac =  listResTac.size(); 
				System.out.println("sizeEstuUltr:"+sizeEstuUltr);
				System.out.println("sizeMamDens:"+sizeMamDens);
				System.out.println("sizeResTac:"+sizeResTac);
				int max = 0; 
				if(sizeEstuUltr<sizeMamDens) {
					max = sizeMamDens; 
				}else {
					max = sizeEstuUltr; 
				}
				if(max<sizeResTac) {
					max = sizeResTac; 
				}
				
				for(int i=1;i<=max;i++) {
					ResumenCitas resumenCitas = new ResumenCitas(); 
					resumenCitas.setHora1(hrIni);
					resumenCitas.setHora2(hrIni);
					resumenCitas.setHora3(hrIni);
					ResumenCitasVDto resumenCitasVDto = null; 
					if(sizeEstuUltr>=i) {
						resumenCitasVDto = listEstuUltr.get(i-1);
						resumenCitas.setDoctoryo1(resumenCitasVDto.getNombreDoctor());
						resumenCitas.setEstudiosUltrasonidos(resumenCitasVDto.getNombreEstudio());
					}
					if(sizeMamDens>=i) {
						resumenCitasVDto = listMamDens.get(i-1);
						resumenCitas.setDoctoryo2(resumenCitasVDto.getNombreDoctor());
						resumenCitas.setMamografiaDensito(resumenCitasVDto.getNombreEstudio());
					}
					if(sizeResTac>=i) {
						resumenCitasVDto = listResTac.get(i-1);
						resumenCitas.setDoctoryo3(resumenCitasVDto.getNombreDoctor());
						resumenCitas.setResonanciaTac(resumenCitasVDto.getNombreEstudio());									
					}
					
					listResumenCitas.add(resumenCitas);
				}
				
				System.out.println("max:"+max);
			}
			
		
	}
	
	
	public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        String strFormat = format.format(event.getObject()); 
        System.out.println("strFormat:"+strFormat);
        java.util.Date utilDate=null;
        java.sql.Timestamp sqlDate=null; 
        try {
		  utilDate = format.parse(strFormat);
		  sqlDate = new java.sql.Timestamp(utilDate.getTime()); 
		} catch (ParseException e) {
            System.out.println(e);
			e.printStackTrace();
		} 
        System.out.println("sqlDate:"+sqlDate);
        String strTimeStamp = sqlDate.toString().substring(0,10); 
        System.out.println("strTimeStamp:"+strTimeStamp);
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
        
        
        listResumenCitas = new ArrayList<ResumenCitas>();
		List<String> listHrsIni  = resumenCitasLocal.findHorasIniciales(sqlDate);
		Iterator<String> iterHrsIni =  listHrsIni.iterator(); 
		while(iterHrsIni.hasNext()) {
			String hrIni = iterHrsIni.next(); 
			List<ResumenCitasVDto> listEstuUltr =  resumenCitasLocal.findEstuUltr(sqlDate, hrIni);
			int sizeEstuUltr =  listEstuUltr.size(); 
			List<ResumenCitasVDto> listMamDens =  resumenCitasLocal.findMamDens(sqlDate, hrIni);
			int sizeMamDens =  listMamDens.size(); 
			List<ResumenCitasVDto> listResTac =  resumenCitasLocal.findResTac(sqlDate, hrIni);
			int sizeResTac =  listResTac.size(); 
			System.out.println("sizeEstuUltr:"+sizeEstuUltr);
			System.out.println("sizeMamDens:"+sizeMamDens);
			System.out.println("sizeResTac:"+sizeResTac);
			int max = 0; 
			if(sizeEstuUltr<sizeMamDens) {
				max = sizeMamDens; 
			}else {
				max = sizeEstuUltr; 
			}
			if(max<sizeResTac) {
				max = sizeResTac; 
			}
			
			for(int i=1;i<=max;i++) {
				ResumenCitas resumenCitas = new ResumenCitas(); 
				resumenCitas.setHora1(hrIni);
				resumenCitas.setHora2(hrIni);
				resumenCitas.setHora3(hrIni);
				ResumenCitasVDto resumenCitasVDto = null; 
				if(sizeEstuUltr>=i) {
					resumenCitasVDto = listEstuUltr.get(i-1);
					resumenCitas.setDoctoryo1(resumenCitasVDto.getNombreDoctor());
					resumenCitas.setEstudiosUltrasonidos(resumenCitasVDto.getNombreEstudio());
				}
				if(sizeMamDens>=i) {
					resumenCitasVDto = listMamDens.get(i-1);
					resumenCitas.setDoctoryo2(resumenCitasVDto.getNombreDoctor());
					resumenCitas.setMamografiaDensito(resumenCitasVDto.getNombreEstudio());
				}
				if(sizeResTac>=i) {
					resumenCitasVDto = listResTac.get(i-1);
					resumenCitas.setDoctoryo3(resumenCitasVDto.getNombreDoctor());
					resumenCitas.setResonanciaTac(resumenCitasVDto.getNombreEstudio());									
				}
				
				listResumenCitas.add(resumenCitas);
			}
			
			System.out.println("max:"+max);
		}
		
        
        
     }

	
	public List<ResumenCitas> getListResumenCitas() {
		return listResumenCitas;
	}

	public void setListResumenCitas(List<ResumenCitas> listResumenCitas) {
		this.listResumenCitas = listResumenCitas;
	}

	public java.util.Date getFechaFiltro() {
		return fechaFiltro;
	}

	public void setFechaFiltro(java.util.Date fechaFiltro) {
		this.fechaFiltro = fechaFiltro;
	} 
	
}
