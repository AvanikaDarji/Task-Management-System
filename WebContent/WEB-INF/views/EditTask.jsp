<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>  
<!DOCTYPE html>
<html>
 <head>
    <meta charset="UTF-8">
    <title>Edit Task</title>
 </head>
 <body bgcolor="#A9D0F5">
    <sql:setDataSource
        var="editTask"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/CompanyTask?useSSL=false"
        user="root" password="Summer$2016"
    />
     
    <sql:query var="listTask"   dataSource="${editTask}">
        Select * from CompanyTask.taskData Where TaskId=1;
    </sql:query>
    <h3>Edit Task</h3>
    
     <c:forEach var="user" items="${listTask.rows}">
		<form name="EnterTaskdata" action="CreateTaskServlet" method="post">
			<tr>
				<td> Task Category: <input type="radio" name="category" value="Analysis & Design" /> <c:out value="${user.TaskCategory}" /><c:if test="${user.TestCategory}">checked="checked"</c:if> AnalysisDesign <td>
								    <input type="radio" name="category" value="Testing" /> Testing </td>
								    <input type="radio" name="category" value="Developing" /> Developing </td> 
				<td>
		    <tr>
	
	<br> Task Priority:  <select name ="taskPriority" id="taskPriority">
	<option value="Important" selected="selected">Important</option>
    <option value="Regular">Regular</option>
	</select> <br>
                <tr>
                	<td> Task Description: <textarea rows="3" cols="30" name="task_description" style="vertical-align:middle"><c:out value="${user.TaskDescription}" /></textarea> <td>
                </td>	

                </form>
     </c:forEach> 
 
 </body>
</html>