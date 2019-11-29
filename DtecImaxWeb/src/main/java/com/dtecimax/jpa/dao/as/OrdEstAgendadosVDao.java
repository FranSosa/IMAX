package com.dtecimax.jpa.dao.as;

import java.util.List;
import com.dtecimax.jpa.dto.as.OrdEstAgendadosDtoV1;
import com.dtecimax.jpa.dto.as.OrdEstAgendadosDtoV2;
import java.sql.Date; 

public interface OrdEstAgendadosVDao {
	
	public List<OrdEstAgendadosDtoV1> findByTipoOrdenV1(String pTipoOrden);
	public List<OrdEstAgendadosDtoV2> findByTipoOrdenV2(String pTipoOrden);
	public long countV1(String pTipoOrden,Date pFecha); 
	public long countV2(String pTipoOrden,Date pFecha); 
}
