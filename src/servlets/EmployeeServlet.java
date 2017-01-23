package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/EmployeeServlet")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 public void doPost(HttpServletRequest request, HttpServletResponse response)  
	            throws ServletException, IOException {  

	        response.setContentType("text/html");  
	        PrintWriter out = response.getWriter();  
	        
	        //String n=request.getParameter("NewTask");
	        //String e=request.getParameter("ExistingTask");
	        //System.out.println(e);
	        //String m = "NewTask";
	        if(request.getParameter("EmployeeNewTask")!= null){
	        	RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/CreateNewTask.jsp");  
	            rd.forward(request,response);
	        }
	        else if(request.getParameter("EmployeeExistingTask")!= null){
	        	RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/EmployeeExisitingTask.jsp");  
	            rd.forward(request,response);
	        }
	        else if(request.getParameter("EmployeeTask")!= null){
	        	RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/EmployeeTask.jsp");  
	            rd.forward(request,response);
	        }
	        out.close();  
	 }
}
