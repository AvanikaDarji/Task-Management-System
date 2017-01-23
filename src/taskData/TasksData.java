package taskData;

//import java.sql.Connection;
//import java.sql.Date;
import java.util.Date;

public class TasksData {
	
	private String taskcategory;
//	private String taskstatus;
	private String taskPriority;
	private String taskDescription;
	private String assignedEmployee;
	private Date createdate;
	private Date enddate;
	private int duration;
	
	
	
	public TasksData(){
		super();
	}
	
	public TasksData( String taskcategory,String taskPriority, String taskDescription,String assignedEmployee,Date createdate,Date enddate ,int duration) {
		super();
		//this.taskstatus = taskstatus;
		this.taskcategory = taskcategory;
		this.assignedEmployee = assignedEmployee;
		this.taskDescription = taskDescription;
		this.taskPriority = taskPriority;
		this.createdate = createdate;
		this.enddate = enddate;
		this.duration = duration;
		
	}
	/*public String getTaskstatus() {
		return taskstatus;
	}
	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}*/
	public String getTaskcategory() {
		return taskcategory;
	}
	public void setTaskcategory(String taskcategory) {
		this.taskcategory = taskcategory;
	}
	public String getAssignedEmployee() {
		return assignedEmployee;
	}
	public void setAssignedEmployee(String assignedEmployee) {
		this.assignedEmployee = assignedEmployee;
	}
	public String getTaskDescription() {
		return taskDescription;
	}
	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}
	public String getTaskPriority() {
		return taskPriority;
	}
	public void setTaskPriority(String taskPriority) {
		this.taskPriority = taskPriority;
	}
	
	public Date getCreateDate() {
		return createdate;
	}
	public void setCreateDate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getCompletionDate() {
		return enddate;
	}
	public void setCompletionDate(Date enddate) {
		this.enddate = enddate;
	}

	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
}

