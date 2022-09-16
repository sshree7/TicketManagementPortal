package com.nagarro.training.TicketManagementPortal.dto;

public class TicketDto {

	private int id;
	private String title;
	private String department;
	private String description;
	private String status;
	private String user;

	public TicketDto() {
		super();
	}

	public TicketDto(int id, String title, String department, String description, String status, String user) {
		super();
		this.id = id;
		this.title = title;
		this.department = department;
		this.description = description;
		this.status = status;
		this.user = user;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmployee() {
		return user;
	}

	public void setEmployee(String employee) {
		this.user = employee;
	}

}
