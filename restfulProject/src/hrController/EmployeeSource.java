package hrController;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EmployeeSource {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Connection c = null;
	      Statement stmt = null;
	     final Statement smt = null;
		
		
		try {
			
			// sql lite
			Class.forName("org.sqlite.JDBC");
	         c = DriverManager.getConnection("jdbc:sqlite:test.db");
	         c.setAutoCommit(false);
	         System.out.println("Opened database successfully");

	         stmt = c.createStatement();
	         String sql = "CREATE TABLE COMPANY " +
	                        "(EmpLOYEE CHAR(200)  PRIMARY KEY     NOT NULL," +
	                        " SUPERVISOR           CHAR(200), " + 
	                        " REPORTEES_COUNT            INT     NOT NULL, " + 
	                        " REPORTEES        CHAR(1000), " + 
	                        " SENIOR_SUPERVISOR         CHAR(200))"; 
	         stmt.executeUpdate(sql);
	         
			// sql lite
			
			
		int met = 0;
		Map<String, String> dataSet = new HashMap<String, String>(); 
        dataSet.put("Pete", "Nick"); 
        dataSet.put("Barbara", "Nick"); 
        dataSet.put("Nick", "Sophie"); 
        dataSet.put("Sophie", "Jonas"); 
        dataSet.put("Mr X", "Jonas");
        ArrayList<EmpManagerHierarchy> emp = new ArrayList<>();
        for(Map.Entry<String, String> entry : dataSet.entrySet()) {
        	EmpManagerHierarchy tempObj = new EmpManagerHierarchy();
        	if(dataSet.containsKey(entry.getKey())) {
        		tempObj.setEmployee(entry.getKey());
        		tempObj.setSupervisor(entry.getValue());
        	}
        	emp.add(tempObj);
        }
        
        for(String val : dataSet.values()) {
        	StringBuilder st = new StringBuilder();
        	int count = 0;
        	for(String key : dataSet.keySet()) {
        		if(val.equalsIgnoreCase(key)) {
        			count = count + 1;
        		}
        	}
        	if(count == 0 && met == 0) {
        		met = 1;
        		EmpManagerHierarchy tempObj = new EmpManagerHierarchy();
        		tempObj.setSupervisor("NA");
        		tempObj.setSeniorSupervisor("NA");
        		tempObj.setEmployee(val);
        		int repCount = 0;
        		for(Map.Entry<String, String> entry : dataSet.entrySet()) {
        			if(val.equalsIgnoreCase(entry.getValue())) {
        				st.append(entry.getKey() + ",");
        				repCount = repCount + 1;
        			}
        		}
        		tempObj.setReporteesCount(repCount);
        		tempObj.setReportees(st.toString());
        		emp.add(tempObj);
        	}
        }
        
        
        
        for(EmpManagerHierarchy empTemp : emp) {
        	int count = 0;
        	StringBuilder temp = new StringBuilder();
        	for(Map.Entry<String, String> entry : dataSet.entrySet()) {
        		if(empTemp.getEmployee().equalsIgnoreCase(entry.getValue())) {
        			//empTemp.getReportees().add(entry.getKey());
        			temp.append(entry.getKey() + ",");
        			empTemp.setReportees(temp.toString());
        			count = count + 1;
        			empTemp.setReporteesCount(count);
        		}
        		if(empTemp.getSupervisor().equalsIgnoreCase(entry.getKey())) {
        			empTemp.setSeniorSupervisor(entry.getValue());
        		}
        	}
        }
        
			/*
			 * emp.forEach(p -> { System.out.println(p); try {
			 * smt.executeUpdate("INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY)"); }
			 * catch (SQLException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); } });
			 */
        
        for(EmpManagerHierarchy empObj : emp) {
        	smt.executeUpdate("INSERT INTO COMPANY");
        }
        
        
        emp.forEach(p -> {
        	if("NA".equalsIgnoreCase(p.getSupervisor()) && "NA".equalsIgnoreCase(p.getSeniorSupervisor())) {
        		
        	}
        });
		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
