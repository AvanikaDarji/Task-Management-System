<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> Employee Task Management System </title>
</head>
<body background="img1.jpg">
	<center>
	<H1> Task Management System </H1>
    <form action="loginServlet" method="post">
        <fieldset style="width: 300px">
            <legend> Login to System </legend>
            <table >
            	<tr>
                    <td>User Type: </td>
                    <td><select required name="usertype">
					    <option value="blank">None</option>
					    <option value="Manager">Manager</option>
					    <option value="Employee">Employee</option>
					   </select>
					</td>
                </tr>  
                <tr>
                    <td>User ID: </td>
                    <td><input type="text" name="username" required="required" /></td>
                </tr>
                <tr>
                    <td>Password: </td>
                    <td><input type="password" name="userpass" required="required" /></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login" /></td>
                </tr>
            </table>
        </fieldset>
    </form>
    </center>
</body>
</html>