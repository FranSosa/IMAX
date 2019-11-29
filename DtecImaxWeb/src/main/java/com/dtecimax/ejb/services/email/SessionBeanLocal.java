package com.dtecimax.ejb.services.email;

import javax.ejb.Local;

@Local
public interface SessionBeanLocal {

	public void sendEmail(String pTo
			             ,String pSubject
			             ,String pBody 
			             );
	
}
