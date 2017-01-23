package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import taskData.TasksData;
/**
 * Servlet implementation class doEditTaskServlet
 */
@WebServlet("/doEditTaskServlet")
public class doEditTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public doEditTaskServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		boolean status = false;
        Connection conn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;

        String url = "jdbc:mysql://localhost:3306/CompanyTask?useSSL=false";
        String driver = "com.mysql.jdbc.Driver";
        String userName = "root";
        String password = "Summer$2016";
		 
        String TaskId = request.getParameter("TaskId");
        String TaskCategory = request.getParameter("category");
        String TaskPriority = request.getParameter("taskPriority");
        String TaskDescription = request.getParameter("task_description");
        String AssignedEmployee = request.getParameter("assignedEmployee");
        SimpleDateFormat cdate=new SimpleDateFormat("MM/DD/YYYY");
        String createdate= request.getParameter("createdate");
        try {
			Date CreateTaskDate = cdate.parse(createdate);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        String endDateStr = request.getParameter("completiondate");
        try {
			Date EndTaskDate = cdate.parse(endDateStr);
		} catch (ParseException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
        String Duration = request.getParameter("duration");

	       TasksData tasksdata = new TasksData();
	 
	       String errorString = null;
	 
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
	        try {
	        	pst = conn
	                    .prepareStatement("Update companytask.taskdata SET TaskDescription=? Where TaskId=?");
	            pst.setString(1, TaskDescription);
	            pst.setString(2, TaskId);

	            rs = pst.executeQuery();
	        } catch (SQLException e) {
	            e.printStackTrace();
	            errorString = e.getMessage();
	        }
	 
	       // Store infomation to request attribute, before forward to views.
	       request.setAttribute("errorString", errorString);
	       request.setAttribute("product", tasksdata);
	 
	 
	       // If error, forward to Edit page.
	       if (errorString != null) {
	           RequestDispatcher dispatcher = request.getServletContext()
	                   .getRequestDispatcher("/WEB-INF/views/EditTask.jsp");
	           dispatcher.forward(request, response);
	       }
	        
	       // If everything nice.
	       // Redirect to the product listing page.            
	       else {
	           response.sendRedirect(request.getContextPath() + "/productList");
	       }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
