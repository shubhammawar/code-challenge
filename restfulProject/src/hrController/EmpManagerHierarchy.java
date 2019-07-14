package hrController;

import java.util.ArrayList;

public class EmpManagerHierarchy {
	
	private String employee;
	private String supervisor;
	private String reportees;
	private String seniorSupervisor;
	int reporteesCount;
	
	public EmpManagerHierarchy(String employee, String supervisor, String reportees, String seniorSupervisor, int reporteesCount) {
		// TODO Auto-generated constructor stub
		this.employee = employee;
		this.supervisor = supervisor;
		this.reportees = reportees;
		this.seniorSupervisor = seniorSupervisor;
		this.reporteesCount = reporteesCount;
	}
	
	public EmpManagerHierarchy() {
		// TODO Auto-generated constructor stub
	}

	public String getEmployee() {
		return employee;
	}
	public void setEmployee(String employee) {
		this.employee = employee;
	}
	public String getSupervisor() {
		return supervisor;
	}
	public void setSupervisor(String supervisor) {
		this.supervisor = supervisor;
	}
	
	public String getReportees() {
		return reportees;
	}

	public void setReportees(String reportees) {
		this.reportees = reportees;
	}

	public String getSeniorSupervisor() {
		return seniorSupervisor;
	}
	public void setSeniorSupervisor(String seniorSupervisor) {
		this.seniorSupervisor = seniorSupervisor;
	}
	
	
	public int getReporteesCount() {
		return reporteesCount;
	}

	public void setReporteesCount(int reporteesCount) {
		this.reporteesCount = reporteesCount;
	}

	@Override
	public String toString() {
		return "EmpManagerHierarchy [employee=" + employee + ", supervisor=" + supervisor + ", reportees=" + reportees
				+ ", seniorSupervisor=" + seniorSupervisor + ", reporteesCount=" + reporteesCount + "]";
	}

	

	
	
	

}
