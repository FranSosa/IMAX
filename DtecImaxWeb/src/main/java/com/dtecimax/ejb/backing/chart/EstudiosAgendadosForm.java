package com.dtecimax.ejb.backing.chart;

import java.text.SimpleDateFormat;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

import com.dtecimax.ejb.services.as.OrdEstAgendadosVLocal;

@ManagedBean  
@ViewScoped
public class EstudiosAgendadosForm {
	
	private BarChartModel barModelOrdenesSimples;
	private BarChartModel barModelOrdenesEspeciales; 
	private BarChartModel barModelOrdenesContrastados;
	private BarChartModel barModelOrdenesDentales;
	
	private java.util.Date fechaDesde; 
	private java.util.Date fechaHasta;
	
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	@Inject 
	OrdEstAgendadosVLocal  ordEstAgendadosVLocal; 
	
	 @PostConstruct
	 public void init() {
		 barModelOrdenesSimples = initBarCharModelOS();
		 barModelOrdenesEspeciales = initBarCharModelOE();
		 barModelOrdenesContrastados = initBarCharModelOC();
		 barModelOrdenesDentales = initBarCharModelOD();
	 }
    
	 public BarChartModel initBarCharModelOS() {
		    BarChartModel model = new BarChartModel();	   	 
	        ChartSeries numeroOrdenes = new ChartSeries();
	        numeroOrdenes.setLabel("Numero Ordenes");
	        numeroOrdenes.set(0, 0);
	        model.addSeries(numeroOrdenes);
	        
	        model.setTitle("Grafica Ordenes Estudios Simples");
	        model.setLegendPosition("ne");
	 
	        Axis xAxis = model.getAxis(AxisType.X);
	        xAxis.setLabel("Fechas");
	 
	        Axis yAxis = model.getAxis(AxisType.Y);
	        yAxis.setLabel("Numero Ordenes");
	        yAxis.setMin(0);
	        yAxis.setMax(10);
	        
	        return model; 
	 }
	 
	 public BarChartModel initBarCharModelOE() {
		    BarChartModel model = new BarChartModel();	   	 
	        ChartSeries numeroOrdenes = new ChartSeries();
	        numeroOrdenes.setLabel("Numero Ordenes");
	        numeroOrdenes.set(0, 0);
	        model.addSeries(numeroOrdenes);
	        
	        model.setTitle("Grafica Ordenes Estudios Especiales");
	        model.setLegendPosition("ne");
	 
	        Axis xAxis = model.getAxis(AxisType.X);
	        xAxis.setLabel("Fechas");
	 
	        Axis yAxis = model.getAxis(AxisType.Y);
	        yAxis.setLabel("Numero Ordenes");
	        yAxis.setMin(0);
	        yAxis.setMax(10);
	        
	        return model; 
	 }
	 
	 public BarChartModel initBarCharModelOC() {
		    BarChartModel model = new BarChartModel();	   	 
	        ChartSeries numeroOrdenes = new ChartSeries();
	        numeroOrdenes.setLabel("Numero Ordenes");
	        numeroOrdenes.set(0, 0);
	        model.addSeries(numeroOrdenes);
	        
	        model.setTitle("Grafica Ordenes Estudios Contrastados");
	        model.setLegendPosition("ne");
	 
	        Axis xAxis = model.getAxis(AxisType.X);
	        xAxis.setLabel("Fechas");
	 
	        Axis yAxis = model.getAxis(AxisType.Y);
	        yAxis.setLabel("Numero Ordenes");
	        yAxis.setMin(0);
	        yAxis.setMax(10);
	        
	        return model; 
	 }
	 
	 public BarChartModel initBarCharModelOD() {
		    BarChartModel model = new BarChartModel();	   	 
	        ChartSeries numeroOrdenes = new ChartSeries();
	        numeroOrdenes.setLabel("Numero Ordenes");
	        numeroOrdenes.set(0, 0);
	        model.addSeries(numeroOrdenes);
	        
	        model.setTitle("Grafica Ordenes Estudios Dentales");
	        model.setLegendPosition("ne");
	 
	        Axis xAxis = model.getAxis(AxisType.X);
	        xAxis.setLabel("Fechas");
	 
	        Axis yAxis = model.getAxis(AxisType.Y);
	        yAxis.setLabel("Numero Ordenes");
	        yAxis.setMin(0);
	        yAxis.setMax(10);
	        
	        return model; 
	 }
	  public void filtraPorFechas() {
			
		    if(0==fechaDesde.compareTo(fechaHasta)
		    ||1==fechaDesde.compareTo(fechaHasta)) {
		     return; 
		    }
		  
		    java.util.Date utilTmpDate = fechaDesde; 
		    
		    System.out.println(fechaDesde);
		    System.out.println(utilTmpDate);
		    System.out.println(fechaHasta);
		    
		    System.out.println(fechaDesde.compareTo(utilTmpDate)); 
		    System.out.println(fechaDesde.compareTo(fechaHasta)); 
		    System.out.println(utilTmpDate.compareTo(fechaHasta)); 
		    
		    
		    BarChartModel model = new BarChartModel();	   	 
	        ChartSeries numeroOrdenes = new ChartSeries();
	        numeroOrdenes.setLabel("Numero Ordenes");
	        model.setTitle("Grafica Ordenes Estudios Simples");
	        model.setLegendPosition("ne");
	        Axis xAxis = model.getAxis(AxisType.X);
	        xAxis.setLabel("Fechas");
	        Axis yAxis = model.getAxis(AxisType.Y);
	        yAxis.setLabel("Numero Ordenes");
	 
	        long maxNumOrd = 10; 
	        
		    while(utilTmpDate.compareTo(fechaHasta)!=1) {
		    	System.out.println(utilTmpDate.compareTo(fechaHasta));
		    	java.sql.Date sqlTmpDate = new java.sql.Date(utilTmpDate.getTime());
		    	long countV1 = 0; 
		    	countV1 = ordEstAgendadosVLocal.countV1("ORDENES SIMPLES",sqlTmpDate);
		    	if(countV1>maxNumOrd) {
		    		maxNumOrd = countV1; 
		    	}
		    	numeroOrdenes.set(sdf.format(utilTmpDate), countV1);
		    	utilTmpDate = new java.util.Date(utilTmpDate.getTime()+(1000 * 60 * 60 * 24)); 
		    	
		    }
		    model.addSeries(numeroOrdenes);
		    
		    yAxis.setMin(0);
	        yAxis.setMax(maxNumOrd);
	        
	        barModelOrdenesSimples = model;
		    
	        /**********************************************************/
	        utilTmpDate = fechaDesde; 
		    
	        BarChartModel modelOrdenesEspeciales = new BarChartModel();	   	 
	        ChartSeries numeroOrdenesEspeciales = new ChartSeries();
	        numeroOrdenesEspeciales.setLabel("Numero Ordenes");
	        modelOrdenesEspeciales.setTitle("Grafica Ordenes Estudios Especiales");
	        modelOrdenesEspeciales.setLegendPosition("ne");
	        Axis xAxisOrdenesEspeciales = modelOrdenesEspeciales.getAxis(AxisType.X);
	        xAxisOrdenesEspeciales.setLabel("Fechas");
	        Axis yAxisOrdenesEspeciales = modelOrdenesEspeciales.getAxis(AxisType.Y);
	        yAxisOrdenesEspeciales.setLabel("Numero Ordenes");
	 
	        long maxNumOrdEspeciales = 10; 
	        
		    while(utilTmpDate.compareTo(fechaHasta)!=1) {
		    	System.out.println(utilTmpDate.compareTo(fechaHasta));
		    	java.sql.Date sqlTmpDate = new java.sql.Date(utilTmpDate.getTime());
		    	long countV1 = 0; 
		    	countV1 = ordEstAgendadosVLocal.countV1("ORDENES SIMPLES",sqlTmpDate);
		    	if(countV1>maxNumOrdEspeciales) {
		    		maxNumOrdEspeciales = countV1; 
		    	}
		    	numeroOrdenesEspeciales.set(sdf.format(utilTmpDate), countV1);
		    	utilTmpDate = new java.util.Date(utilTmpDate.getTime()+(1000 * 60 * 60 * 24)); 
		    	
		    }
		    modelOrdenesEspeciales.addSeries(numeroOrdenesEspeciales);
		    yAxisOrdenesEspeciales.setMin(0);
	        yAxisOrdenesEspeciales.setMax(maxNumOrdEspeciales);
	        
	        barModelOrdenesEspeciales = modelOrdenesEspeciales;
	        
	        /****************************************************************/
            utilTmpDate = fechaDesde; 
		    
	        BarChartModel modelOrdenesContrastados = new BarChartModel();	   	 
	        ChartSeries numeroOrdenesContrastados = new ChartSeries();
	        numeroOrdenesContrastados.setLabel("Numero Ordenes");
	        modelOrdenesContrastados.setTitle("Grafica Ordenes Estudios Contrastados");
	        modelOrdenesContrastados.setLegendPosition("ne");
	        Axis xAxisOrdenesContrastados = modelOrdenesContrastados.getAxis(AxisType.X);
	        xAxisOrdenesContrastados.setLabel("Fechas");
	        Axis yAxisOrdenesContrastados = modelOrdenesContrastados.getAxis(AxisType.Y);
	        yAxisOrdenesContrastados.setLabel("Numero Ordenes");
	 
	        long maxNumOrdContrastados = 10; 
	        
		    while(utilTmpDate.compareTo(fechaHasta)!=1) {
		    	System.out.println(utilTmpDate.compareTo(fechaHasta));
		    	java.sql.Date sqlTmpDate = new java.sql.Date(utilTmpDate.getTime());
		    	long countV1 = 0; 
		    	countV1 = ordEstAgendadosVLocal.countV1("ORDENES CONTRASTADOS",sqlTmpDate);
		    	if(countV1>maxNumOrdContrastados) {
		    		maxNumOrdContrastados = countV1; 
		    	}
		    	numeroOrdenesContrastados.set(sdf.format(utilTmpDate), countV1);
		    	utilTmpDate = new java.util.Date(utilTmpDate.getTime()+(1000 * 60 * 60 * 24)); 
		    	
		    }
		    modelOrdenesContrastados.addSeries(numeroOrdenesContrastados);
		    yAxisOrdenesContrastados.setMin(0);
	        yAxisOrdenesContrastados.setMax(maxNumOrdContrastados);
	        
	        barModelOrdenesContrastados = modelOrdenesContrastados;
	        
	        /****************************************************************/
	        
            utilTmpDate = fechaDesde; 
		    
	        BarChartModel modelOrdenesDentales = new BarChartModel();	   	 
	        ChartSeries numeroOrdenesDentales = new ChartSeries();
	        numeroOrdenesDentales.setLabel("Numero Ordenes");
	        modelOrdenesDentales.setTitle("Grafica Ordenes Estudios Dentales");
	        modelOrdenesDentales.setLegendPosition("ne");
	        Axis xAxisOrdenesDentales = modelOrdenesDentales.getAxis(AxisType.X);
	        xAxisOrdenesDentales.setLabel("Fechas");
	        Axis yAxisOrdenesDentales = modelOrdenesDentales.getAxis(AxisType.Y);
	        yAxisOrdenesDentales.setLabel("Numero Ordenes");
	 
	        long maxNumOrdDentales = 10; 
	        
		    while(utilTmpDate.compareTo(fechaHasta)!=1) {
		    	System.out.println(utilTmpDate.compareTo(fechaHasta));
		    	java.sql.Date sqlTmpDate = new java.sql.Date(utilTmpDate.getTime());
		    	long countV1 = 0; 
		    	countV1 = ordEstAgendadosVLocal.countV1("ORDENES DENTALES",sqlTmpDate);
		    	if(countV1>maxNumOrdDentales) {
		    		maxNumOrdDentales = countV1; 
		    	}
		    	numeroOrdenesDentales.set(sdf.format(utilTmpDate), countV1);
		    	utilTmpDate = new java.util.Date(utilTmpDate.getTime()+(1000 * 60 * 60 * 24)); 
		    	
		    }
		    modelOrdenesDentales.addSeries(numeroOrdenesDentales);
		    yAxisOrdenesDentales.setMin(0);
	        yAxisOrdenesDentales.setMax(maxNumOrdDentales);
	        
	        barModelOrdenesDentales = modelOrdenesDentales;
	        
	        /****************************************************************/
	        
	        
			
	  }
	
	  private BarChartModel initBarModel() {
	        BarChartModel model = new BarChartModel();
	 
	        ChartSeries boys = new ChartSeries();
	        boys.setLabel("Boys");
	        boys.set("2004", 120);
	        boys.set("2005", 100);
	        boys.set("2006", 44);
	        boys.set("2007", 150);
	        boys.set("2008", 25);
	 
	        ChartSeries girls = new ChartSeries();
	        girls.setLabel("Girls");
	        girls.set("2004", 52);
	        girls.set("2005", 60);
	        girls.set("2006", 110);
	        girls.set("2007", 135);
	        girls.set("2008", 120);
	 
	        model.addSeries(boys);
	        model.addSeries(girls);
	 
	        return model;
	    }
		
		 private void createBarModel() {
			 barModelOrdenesSimples = initBarModel();
		 
			 barModelOrdenesSimples.setTitle("Bar Chart");
			 barModelOrdenesSimples.setLegendPosition("ne");
		 
		        Axis xAxis = barModelOrdenesSimples.getAxis(AxisType.X);
		        xAxis.setLabel("Gender");
		 
		        Axis yAxis = barModelOrdenesSimples.getAxis(AxisType.Y);
		        yAxis.setLabel("Births");
		        yAxis.setMin(0);
		        yAxis.setMax(200);
		  }
		 
		 private void createBarModels() {
		        createBarModel();
		    }
	  
	public BarChartModel getBarModelOrdenesSimples() {
		return barModelOrdenesSimples;
	}

	public void setBarModelOrdenesSimples(BarChartModel barModel) {
		this.barModelOrdenesSimples = barModel;
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

	public BarChartModel getBarModelOrdenesEspeciales() {
		return barModelOrdenesEspeciales;
	}

	public void setBarModelOrdenesEspeciales(BarChartModel barModelOrdenesEspeciales) {
		this.barModelOrdenesEspeciales = barModelOrdenesEspeciales;
	}

	public BarChartModel getBarModelOrdenesContrastados() {
		return barModelOrdenesContrastados;
	}

	public void setBarModelOrdenesContrastados(BarChartModel barModelOrdenesContrastados) {
		this.barModelOrdenesContrastados = barModelOrdenesContrastados;
	}

	public BarChartModel getBarModelOrdenesDentales() {
		return barModelOrdenesDentales;
	}

	public void setBarModelOrdenesDentales(BarChartModel barModelOrdenesDentales) {
		this.barModelOrdenesDentales = barModelOrdenesDentales;
	}
	 
	
}
