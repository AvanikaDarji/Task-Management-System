package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.text.ParseException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpServletResponse;

import taskData.TasksData;
import taskServices.taskdbServices;

@WebServlet(name = "CreateTaskServlet", urlPatterns = {"/CreateTaskServlet"})

public class CreateTaskServlet extends HttpServlet { 
	
	private static final long serialVersionUID = 1L;
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
       
		 PrintWriter pw = response.getWriter(); 
	
		
		try
		
		{
TasksData t1 = new TasksData();

String TaskCategory = request.getParameter("category");
String TaskPriority = request.getParameter("taskPriority");
String TaskDescription = request.getParameter("task_description");
String AssignedEmployee = request.getParameter("assignedEmployee");

SimpleDateFormat cdate=new SimpleDateFormat("MM/DD/YYYY");
/*SimpleDateFormat cdate = new SimpleDateFormat("MM-DD-YYYY");*/
String createdate= request.getParameter("createdate");
Date CreateTaskDate = cdate.parse(createdate);


String endDateStr = request.getParameter("completiondate");
Date EndTaskDate = cdate.parse(endDateStr);

String d = request.getParameter("duration");
int Duration= Integer.parseInt(d);

		t1.setTaskcategory(TaskCategory);
		t1.setTaskPriority(TaskPriority);
		t1.setTaskDescription(TaskDescription);
		t1.setAssignedEmployee(AssignedEmployee);
		t1.setCreateDate(CreateTaskDate);
		t1.setCompletionDate(EndTaskDate);
		t1.setDuration(Duration);
		
		
		try{
  Boolean b = taskdbServices.insertfunction(t1);
  System.out.print(b);
  RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/TaskSave.jsp");  
  rd.forward(request,response);
        
     } catch (ClassNotFoundException ex) {
    	 ex.printStackTrace();
     } catch (SQLException ex) {
    	 ex.printStackTrace();
     }

    
 } catch (Exception ex) {
	 ex.printStackTrace();
 }


	}

}
	       
	      
  