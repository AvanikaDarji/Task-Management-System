<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP List Users Records</title>
<style>
table {
    border-collapse: collapse;
}

table, td, th {
    border: 1px solid black;
}
</style>
</head>
<body bgcolor="#A9D0F5">
    <sql:setDataSource
        var="myDS"
        driver="com.mysql.jdbc.Driver"
        url="jdbc:mysql://localhost:3306/CompanyTask?useSSL=false"
        user="root" password="Summer$2016"
    />
     
    <sql:query var="listUsers"   dataSource="${myDS}">
        SELECT * FROM CompanyTask.taskData t JOIN CompanyTask.user u ON u.UserId = t.UserId Where u.UserType="Employee";
    </sql:query>
     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Tasks</h2></caption>
            <tr>
                <th>Task ID</th>
                <th>Category</th>
                <th>Priority</th>
                <th>Description</th>
                <th>Assigned To</th>
                <th>Duration</th>
                <th>Edit Task</th>
            </tr>
            <c:forEach var="user" items="${listUsers.rows}">
                <tr>
                    <td><c:out value="${user.TaskId}" /></td>
                    <td><c:out value="${user.TaskCategory}" /></td>
                    <td><c:out value="${user.TaskPriority}" /></td>
                    <td><c:out value="${user.TaskDescription}" /></td>
                    <td><c:out value="${user.AssignedEmployee}" /></td>
                    <td><c:out value="${user.Duration}" /></td>
                    <td><a href="editTask?TaskId=${user.TaskId}">Edit</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>