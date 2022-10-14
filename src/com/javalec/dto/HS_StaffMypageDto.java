package com.javalec.dto;

public class HS_StaffMypageDto {  //static 입니다. employee 정보를 static으로 저장했습니다

	public HS_StaffMypageDto() {
		// TODO Auto-generated constructor stub
	}
	
	
	String tfNameupdate;
	String tfTelnoupdate;
	String tfemailupdate;
	String tfpwupdate;
	
	
	


	public HS_StaffMypageDto(String tfNameupdate, String tfTelnoupdate, String tfemailupdate, String tfpwupdate
			) {
		super();
		this.tfNameupdate = tfNameupdate;
		this.tfTelnoupdate = tfTelnoupdate;
		this.tfemailupdate = tfemailupdate;
		this.tfpwupdate = tfpwupdate;
		
	}

	

	
	
	public String getTfNameupdate() {
		return tfNameupdate;
	}


	public void setTfNameupdate(String tfNameupdate) {
		this.tfNameupdate = tfNameupdate;
	}


	public String getTfTelnoupdate() {
		return tfTelnoupdate;
	}


	public void setTfTelnoupdate(String tfTelnoupdate) {
		this.tfTelnoupdate = tfTelnoupdate;
	}


	public String getTfemailupdate() {
		return tfemailupdate;
	}


	public void setTfemailupdate(String tfemailupdate) {
		this.tfemailupdate = tfemailupdate;
	}


	public String getTfpwupdate() {
		return tfpwupdate;
	}


	public void setTfpwupdate(String tfpwupdate) {
		this.tfpwupdate = tfpwupdate;
	}
	
	
	
	
	
	
}
