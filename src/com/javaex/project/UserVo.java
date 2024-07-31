package com.javaex.project;

public class UserVo {

	private int employeeId;
	private String empName;
	private String loginID;
	private String loginPW;
	private String eMail;
	private int departmentId;
	private String phoneNumber;
	private String addRess;
	private String hireDate;

	public UserVo() {
		super();
	
	}

	public UserVo(int employeeId, String empName, String loginID, String loginPW, String eMail, int departmentId,
			String phoneNumber, String addRess, String hireDate) {
		
		this.employeeId = employeeId;
		this.empName = empName;
		this.loginID = loginID;
		this.loginPW = loginPW;
		this.eMail = eMail;
		this.departmentId = departmentId;
		this.phoneNumber = phoneNumber;
		this.addRess = addRess;
		this.hireDate = hireDate;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getLoginID() {
		return loginID;
	}

	public void setLoginID(String loginID) {
		this.loginID = loginID;
	}

	public String getLoginPW() {
		return loginPW;
	}

	public void setLoginPW(String loginPW) {
		this.loginPW = loginPW;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getAddRess() {
		return addRess;
	}

	public void setAddRess(String addRess) {
		this.addRess = addRess;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}

	@Override
	public String toString() {
		return "UserVo [employeeId=" + employeeId + ", empName=" + empName + ", loginID=" + loginID + ", loginPW="
				+ loginPW + ", eMail=" + eMail + ", departmentId=" + departmentId + ", phoneNumber=" + phoneNumber
				+ ", addRess=" + addRess + ", hireDate=" + hireDate + "]";
	}

}
