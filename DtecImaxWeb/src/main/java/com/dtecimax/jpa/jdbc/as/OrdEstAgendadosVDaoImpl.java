package com.dtecimax.jpa.jdbc.as;

import java.sql.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.dtecimax.jpa.dao.as.OrdEstAgendadosVDao;
import com.dtecimax.jpa.dto.as.OrdEstAgendadosDtoV1;
import com.dtecimax.jpa.dto.as.OrdEstAgendadosDtoV2;

@Stateless 
public class OrdEstAgendadosVDaoImpl implements OrdEstAgendadosVDao {

	@PersistenceContext(unitName = "DTECIMAXPU") 
	EntityManager em;
	
	
	@Override
	public List<OrdEstAgendadosDtoV1> findByTipoOrdenV1(String pTipoOrden) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdEstAgendadosDtoV2> findByTipoOrdenV2(String pTipoOrden) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public long countV1(String pTipoOrden, Date pFecha) {
		long retval = 0l; 
		String strQuery = "SELECT o.numeroOrdenes FROM OrdEstAgendadosDtoV1 o";
		strQuery = strQuery+" WHERE o.tipoOrden = '"+pTipoOrden+"'";
		strQuery = strQuery+" AND o.fechaCreacion = '"+pFecha+"'";
		Query query = em.createQuery(strQuery); 
		Object object = null; 
		try {
		  object= query.getSingleResult();
		}catch(javax.persistence.NoResultException e){
			System.out.println("****"); 
		}
		
		if(null==object) {
			retval = 0l; 	
		}else {
			retval = ((Integer)object).longValue();
		}
		return retval; 
	}

	@Override
	public long countV2(String pTipoOrden, Date pFecha) {
		// TODO Auto-generated method stub
		return 0;
	}

}
