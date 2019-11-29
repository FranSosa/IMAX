package com.dtecimax.ejb.backing.chart;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.dtecimax.ejb.services.as.ResumenCitasLocal;
import com.dtecimax.jpa.dto.as.CitasAgendadasDto;

@ManagedBean  
@ViewScoped
public class CitasAgendadasForm {

	private BarChartModel barModelCitasAgendadas;
	private Date fechaDesde; 
	private Date fechaHasta; 
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Inject 
	ResumenCitasLocal resumenCitasLocal; 
	
	 @PostConstruct
	 public void init() {
		 barModelCitasAgendadas = initModelCitasAgendadas(); 
	 }
	 
	 public BarChartModel initModelCitasAgendadas() {
		 BarChartModel retval = new BarChartModel(); 
		 
		 ChartSeries numeroCitas = new ChartSeries();
		 numeroCitas.setLabel("Numero Citas");
		 numeroCitas.set(0, 0);
         retval.addSeries(numeroCitas);
        
         retval.setTitle("Grafica Citas");
         retval.setLegendPosition("ne");
 
         Axis xAxis = retval.getAxis(AxisType.X);
         xAxis.setLabel("Fechas");
 
         Axis yAxis = retval.getAxis(AxisType.Y);
         yAxis.setLabel("Numero Citas");
         yAxis.setMin(0);
         yAxis.setMax(10);
		 
		 return retval; 
	 }
	 
	 public void filtraPorFechas() {
			
		    if(0==getFechaDesde().compareTo(getFechaHasta())
		    ||1==getFechaDesde().compareTo(getFechaHasta())) {
		     return; 
		    }
		  
		    java.util.Date utilTmpDate = getFechaDesde(); 
		    
            long maxNumOrd = 10; 
            
            BarChartModel barChartModel = new BarChartModel(); 
            ChartSeries numeroCitas = new ChartSeries();
   		    numeroCitas.setLabel("Numero Citas");
   		 
   		    long maxNumCitas = 10;
   		 
		    while(utilTmpDate.compareTo(fechaHasta)!=1) {
		    	
		    	System.out.println(utilTmpDate.compareTo(fechaHasta));
		    	java.sql.Date sqlTmpDate = new java.sql.Date(utilTmpDate.getTime());
		    	
		    	List<CitasAgendadasDto> listCitasAgendadasDto = resumenCitasLocal.findCitasAgendadas(sqlTmpDate);
		    	Iterator<CitasAgendadasDto> iteratorCitasAgendadasDto =  listCitasAgendadasDto.iterator();
		    	CitasAgendadasDto citasAgendadasDto = null; 
		    	if(iteratorCitasAgendadasDto.hasNext()) {
		    		citasAgendadasDto = iteratorCitasAgendadasDto.next(); 
		    		numeroCitas.set(sdf.format(sqlTmpDate),citasAgendadasDto.getNumeroCitas());
		    		if(citasAgendadasDto.getNumeroCitas()>maxNumCitas) {
		    			maxNumCitas = citasAgendadasDto.getNumeroCitas(); 
		    		}
		    	}else {
		    		numeroCitas.set(sdf.format(sqlTmpDate),0);
		    	}
		    	
		    	System.out.println(citasAgendadasDto);
		    	utilTmpDate = new java.util.Date(utilTmpDate.getTime()+(1000 * 60 * 60 * 24)); 
		   
		    }
		   
		    barChartModel.addSeries(numeroCitas);
	        
		    barChartModel.setTitle("Grafica Citas");
		    barChartModel.setLegendPosition("ne");
	 
	         Axis xAxis = barChartModel.getAxis(AxisType.X);
	         xAxis.setLabel("Fechas");
	 
	         Axis yAxis = barChartModel.getAxis(AxisType.Y);
	         yAxis.setLabel("Numero Citas");
	         yAxis.setMin(0);
	         yAxis.setMax(maxNumCitas);
		    
	         barModelCitasAgendadas = barChartModel; 
		    
	 }
	 
	public BarChartModel getBarModelCitasAgendadas() {
		return barModelCitasAgendadas;
	}

	public void setBarModelCitasAgendadas(BarChartModel barModelCitasAgendadas) {
		this.barModelCitasAgendadas = barModelCitasAgendadas;
	}

	public java.util.Date getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(Date fechaDesde) {
		this.fechaDesde = fechaDesde;
	}

	public java.util.Date getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(Date fechaHasta) {
		this.fechaHasta = fechaHasta;
	}
	
}
