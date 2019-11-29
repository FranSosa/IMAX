package com.dtecimax.jpa.dao.as;

import java.util.List;
import com.dtecimax.jpa.dto.as.OrdenesEstudiosVDto;

public interface OrdenesEstudiosVDao {
	
	public List<OrdenesEstudiosVDto> findOneYearOld();

}
