package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManagerServlet
 */
@WebServlet("/ManagerServlet")
public class ManagerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        //String n=request.getParameter("NewTask");
        //String e=request.getParameter("ExistingTask");
        //System.out.println(e);
        //String m = "NewTask";
        if(request.getParameter("ManagerNewTask")!= null){
        	System.out.println("in");
        	RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/CreateNewTask.jsp");  
            rd.forward(request,response);
        }
        else if(request.getParameter("ManagerExistingTask")!= null){
        	RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/ManagerExistingTask.jsp");  
            rd.forward(request,response);
        }
        out.close();  
    }
    public void doGet(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        //String n=request.getParameter("NewTask");
        //String e=request.getParameter("ExistingTask");
        //System.out.println(e);
        //String m = "NewTask";
        	RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/ManagerExistingTask.jsp");  
            rd.forward(request,response);
    }
}
