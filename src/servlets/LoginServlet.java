package servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import taskServices.LoginDao;

public class LoginServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    public void doPost(HttpServletRequest request, HttpServletResponse response)  
            throws ServletException, IOException {  
 
        response.setContentType("text/html");  
        PrintWriter out = response.getWriter();  
        
        String n=request.getParameter("username");  
        String p=request.getParameter("userpass");
        String u=request.getParameter("usertype");
        
        HttpSession session = request.getSession(false);
        if(session!=null)
        session.setAttribute("name", n);
        String m = "Manager";
        String e = "Employee";
        if(LoginDao.validate(n,p,u)){  
        	if (u.equals(m)){
        		System.out.println(u);
	            RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/ManagerPage.jsp");  
	            rd.forward(request,response); 
        	}
        	else if (u.equals(e)){
        		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/EmployeePage.jsp");  
                rd.forward(request,response); 
        	}
        }  
        else{   
	            RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/views/Error.jsp");  
	            rd.include(request,response);
        }  

        out.close();  
    }  
} 