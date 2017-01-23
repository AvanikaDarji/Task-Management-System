<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>

</head>

<body bgcolor="#A9D0F5">

<div id="heading">

<h1>Create A Task </h1>

</div>

	<form name="EnterTaskdata" action="CreateTaskServlet" method="post">
	
	
	<br> Task Category:  <br><input type="radio" name="category" value="Analysis & Design" /> AnalysisDesign<br>
	<input type="radio" name="category" value="Testing" /> Testing<br> 
    <input type="radio" name="category" value="Developing" /> Developing<br> 
	
	<br> Task Priority:  <select name ="taskPriority" id="taskPriority">
	<option value="Important" selected="selected">Important</option>
    <option value="Regular">Regular</option>
	</select> <br>
	
Task Description:<textarea rows="3" cols="30" name="task_description" style="vertical-align:middle"></textarea><br>

<br> Assigned Employee:  <select name ="assignedEmployee" id ="assignedEmployee">
		<option value=""> </option>
			<option value="Avanika">Avanika</option>
			<option value="Siddharth">Siddharth</option>
			<option value="Jack">Jack</option>
			<option value="Marck">Marck</option>
   </select> <br>	
   	
 <br> Create Date:  <input type="date"  name="createdate"><br>

<br> EndDate:  <input type="date" name="completiondate"/><br>

<br> Duration(Days):  <input type="duration" name="duration"/><br>
		

<br> Task Status:  <select name ="taskStatus" id ="taskStatus">
		<option value=""> </option>
			<option value="Assigned">Assigned</option>
			<option value="Not assigned">Not assigned</option>
			<option value="In-Progress">In-Progress</option>
			<option value="Completed">Completed</option>
			<option value="Closed">Closed</option>
</select> <br>	

<br><input type="submit" name="assigntask" value="Assign Task"> <br> 	

</form>

</body>
</html>