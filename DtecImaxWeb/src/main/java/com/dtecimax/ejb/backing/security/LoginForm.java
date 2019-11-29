package com.dtecimax.ejb.backing.security;

import java.io.IOException;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;

@ManagedBean  
@RequestScoped
public class LoginForm {

	 
	 public void init() {
		System.out.println("init() LoginForm");
		HttpServletRequest req = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		String strError = req.getParameter("error");
		System.out.println("strError:"+strError);
		if(null!=strError&&!"".equals(strError)) {
			if("1".equals(strError)) {
				 FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fallo al iniciar Session.", null);
			     FacesContext.getCurrentInstance().addMessage(null, message);
			}
		}
	 }
	
	 public String doLogin() throws IOException, ServletException {
		    System.out.println("Comienza LoginForm doLogin");
	        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
	        ServletRequest servletRequest = (ServletRequest) context.getRequest();
	        String strUsername =  servletRequest.getParameter("username");
	        System.out.println("strUsername:"+strUsername);
	        Map<String, Object> sessionMap  = context.getSessionMap();
	        sessionMap.put("svUserName", strUsername);
	        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/login");
	        dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
	        FacesContext.getCurrentInstance().responseComplete();
	        System.out.println("Finaliza LoginForm doLogin");
	        return null;
	    }
	 
	 public String doLogout() throws IOException, ServletException {
	        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
	        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
	        if (null != authentication) {
	            new SecurityContextLogoutHandler().logout((HttpServletRequest) 
	                    context.getRequest(), (HttpServletResponse) context.getResponse(), authentication);
	        }
	        
	        RequestDispatcher dispatcher = ((ServletRequest) context.getRequest()).getRequestDispatcher("/logout");
	        dispatcher.forward((ServletRequest) context.getRequest(), (ServletResponse) context.getResponse());
	        FacesContext.getCurrentInstance().responseComplete();
	        return null;
	    }
	 
}
