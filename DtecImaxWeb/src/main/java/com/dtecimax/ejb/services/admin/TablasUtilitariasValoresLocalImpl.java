package com.dtecimax.ejb.services.admin;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import com.dtecimax.jpa.dao.admin.TablasUtilitariasValoresDao;
import com.dtecimax.jpa.dto.admin.TablasUtilitariasValoresDto;

@Stateless 
public class TablasUtilitariasValoresLocalImpl implements TablasUtilitariasValoresLocal{

	@Inject 
	TablasUtilitariasValoresDao  tablasUtilitariasValoresDao; 
	
	public void insert(TablasUtilitariasValoresDto pTablasUtilitariasValoresDto) {
		tablasUtilitariasValoresDao.insert(pTablasUtilitariasValoresDto);
	}

	public List<TablasUtilitariasValoresDto> findByTipoTabla(String pTipoTabla) {
		return tablasUtilitariasValoresDao.findByTipoTabla(pTipoTabla);
	}

	public void update(long pNumero, TablasUtilitariasValoresDto pTablasUtilitariasValoresDto) {
		tablasUtilitariasValoresDao.update(pNumero, pTablasUtilitariasValoresDto);
	}

}
