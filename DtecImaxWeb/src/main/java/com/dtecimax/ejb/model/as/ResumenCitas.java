package com.dtecimax.ejb.model.as;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean  
@RequestScoped /** Solo Vista **/
public class ResumenCitas {
	
   private String hora1; 
   private String estudiosUltrasonidos; 
   private String doctoryo1;
   private String hora2; 
   private String mamografiaDensito; 
   private String doctoryo2;
   private String hora3; 
   private String resonanciaTac; 
   private String doctoryo3;
   
	public String getHora1() {
		return hora1;
	}
	public void setHora1(String hora1) {
		this.hora1 = hora1;
	}
	public String getEstudiosUltrasonidos() {
		return estudiosUltrasonidos;
	}
	public void setEstudiosUltrasonidos(String estudiosUltrasonidos) {
		this.estudiosUltrasonidos = estudiosUltrasonidos;
	}
	public String getDoctoryo1() {
		return doctoryo1;
	}
	public void setDoctoryo1(String doctoryo1) {
		this.doctoryo1 = doctoryo1;
	}
	public String getHora2() {
		return hora2;
	}
	public void setHora2(String hora2) {
		this.hora2 = hora2;
	}
	public String getMamografiaDensito() {
		return mamografiaDensito;
	}
	public void setMamografiaDensito(String mamografiaDensito) {
		this.mamografiaDensito = mamografiaDensito;
	}
	public String getDoctoryo2() {
		return doctoryo2;
	}
	public void setDoctoryo2(String doctoryo2) {
		this.doctoryo2 = doctoryo2;
	}
	public String getHora3() {
		return hora3;
	}
	public void setHora3(String hora3) {
		this.hora3 = hora3;
	}
	public String getResonanciaTac() {
		return resonanciaTac;
	}
	public void setResonanciaTac(String resonanciaTac) {
		this.resonanciaTac = resonanciaTac;
	}
	public String getDoctoryo3() {
		return doctoryo3;
	}
	public void setDoctoryo3(String doctoryo3) {
		this.doctoryo3 = doctoryo3;
	} 

   
}
