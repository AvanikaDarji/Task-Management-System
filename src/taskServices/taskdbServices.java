package taskServices;

import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import taskData.TasksData;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class taskdbServices { 

	ResultSet rs;
    static Connection connection = null;
    Statement stmt = null;
  //  static private Connection CompanyTaskconnection;
	static private String dbSourceUrl = "jdbc:mysql://localhost:3306/CompanyTask";
	static	private String userId = "root";
    static private String dbPassword ="Summer$2016";
    public static Connection Open() {

        System.out.println("-------- MySQL JDBC Connection Testing ------------");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(dbSourceUrl, userId, dbPassword);
            System.out.println("Succeed!");
            // return connection;

        } catch (Exception e) {

            System.out.println("you have stucked with error!!!!!!");

        }
      
        System.out.println("MySQL JDBC Driver Registered!");

        if (connection != null) {
            System.out.println("You made it, take control your database now!");
        } else {
            System.out.println("Failed to make connection!");
        }

        return connection;
    }

    public void db_Close(Connection con) throws SQLException {
        con.close();
        return;
    }
    
    public static java.sql.Date convertUtilDateToSqlDate(java.util.Date date){
        if(date != null) {
            java.sql.Date sqlDate = new java.sql.Date(date.getTime());
            return sqlDate;
        }
        return null;
    }
    
    public static boolean insertfunction(TasksData ob) throws ClassNotFoundException, SQLException {
    	
    	try{
    		
    	
    	
    		Connection conn = Open();
    		
        String query = "insert into CompanyTask.taskData(TaskCategory,TaskPriority,TaskDescription,AssignedEmployee,CreateTaskDate,EndTaskDate,Duration) values(?,?,?,?,?,?,?)";
        java.sql.PreparedStatement  pst = conn.prepareStatement(query);
        
        
        pst.setString(1,ob.getTaskcategory());  
        pst.setString(2,ob.getTaskPriority());        
        pst.setString(3,ob.getTaskDescription());
        pst.setString(4,ob.getAssignedEmployee());
        
        //java.util.Date date = new java.util.Date();
        //java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
        
        pst.setDate(5,convertUtilDateToSqlDate(ob.getCreateDate()));
        pst.setDate(6,convertUtilDateToSqlDate(ob.getCompletionDate()));
        //pst.setDate(5,(java.sql.Date) ob.getCreateDate());
        //pst.setDate(6,(java.sql.Date) ob.getCompletionDate());
        pst.setInt(7,ob.getDuration());
        
        pst.executeUpdate();

        return true;
    } catch (Exception ex) {
        ex.printStackTrace();
        return false;
    }

    }
    	}



	 
	
	
	
	
	

 

	