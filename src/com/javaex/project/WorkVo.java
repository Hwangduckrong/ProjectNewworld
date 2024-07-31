package com.javaex.project;

public class WorkVo {
	private int workNumber;
	private int employeeId;
	private String startDateAndtime;
	private String endDateAndtime;
    private String workStauts;

	public WorkVo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WorkVo(int workNumber, int employeeId, String startDateAndtime, String endDateAndtime, String workStauts) {
		super();
		this.workNumber = workNumber;
		this.employeeId = employeeId;
		this.startDateAndtime = startDateAndtime;
		this.endDateAndtime = endDateAndtime;
		this.workStauts = workStauts;
	}

	public int getWorkNumber() {
		return workNumber;
	}

	public void setWorkNumber(int workNumber) {
		this.workNumber = workNumber;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getStartDateAndtime() {
		return startDateAndtime;
	}

	public void setStartDateAndtime(String startDateAndtime) {
		this.startDateAndtime = startDateAndtime;
	}

	public String getEndDateAndtime() {
		return endDateAndtime;
	}

	public void setEndDateAndtime(String endDateAndtime) {
		this.endDateAndtime = endDateAndtime;
	}

	public String getWorkStauts() {
		return workStauts;
	}

	public void setWorkStauts(String workStauts) {
		this.workStauts = workStauts;
	}

	@Override
	public String toString() {
		return "WorkVo [workNumber=" + workNumber + ", employeeId=" + employeeId + ", startDateAndtime="
				+ startDateAndtime + ", endDateAndtime=" + endDateAndtime + ", workStauts=" + workStauts + "]";
	}

}

	