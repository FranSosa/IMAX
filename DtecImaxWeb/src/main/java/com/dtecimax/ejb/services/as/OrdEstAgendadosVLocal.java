package com.dtecimax.ejb.services.as;

import java.sql.Date;
import java.util.List;

import javax.ejb.Local;

import com.dtecimax.jpa.dto.as.OrdEstAgendadosDtoV1;
import com.dtecimax.jpa.dto.as.OrdEstAgendadosDtoV2;

@Local
public interface OrdEstAgendadosVLocal {

	public List<OrdEstAgendadosDtoV1> findByTipoOrdenV1(String pTipoOrden);
	public List<OrdEstAgendadosDtoV2> findByTipoOrdenV2(String pTipoOrden);
	public long countV1(String pTipoOrden,Date pFecha); 
	public long countV2(String pTipoOrden,Date pFecha); 
	
}
