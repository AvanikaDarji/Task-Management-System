package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
 
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taskData.TasksData;
//import org.o7planning.simplewebapp.beans.Product;
//import org.o7planning.simplewebapp.utils.DBUtils;
//import org.o7planning.simplewebapp.utils.MyUtils;
 
@WebServlet(urlPatterns = { "/editTask" })
public class EditTaskServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
 
    public EditTaskServlet() {
        super();
    }
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/CompanyTask?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "Summer$2016";
    	
        try {
			Class.forName(driver).newInstance();
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        try {
			conn = DriverManager.getConnection(url, userName, password);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
 
        String taskid = (String) request.getParameter("TaskId");
 
        TasksData tasksdata = null;
 
        String errorString = null;
 
        try {
        	pst = conn
                    .prepareStatement("select * from companytask.taskData where TaskId=?");
            pst.setString(1, taskid);
            rs = pst.executeQuery();
            status = rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
            errorString = e.getMessage();
        }
 
        // If no error.
        // The product does not exist to edit.
        // Redirect to productList page.
        if (errorString != null && tasksdata == null) {
            response.sendRedirect(request.getServletPath() + "/CreateTaskServlet");
            return;
        }

        // Store errorString in request attribute, before forward to views.
        request.setAttribute("errorString", errorString);
        request.setAttribute("taskdata", rs);
 
        RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/EditTask.jsp");
        dispatcher.forward(request, response);
 
    }
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
 
}
