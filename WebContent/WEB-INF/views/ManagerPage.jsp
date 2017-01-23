<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("name")%></title>
</head>
<body bgcolor="#A9D0F5">
    <h4>
        Hello,
        <%=session.getAttribute("name")%></h4>
     <center>
        <fieldset style="width: 300px">
        <table>
	     <form action="ManagerServlet" method="POST">
		     <input type="submit" name="ManagerNewTask" value="Create New Task" />
		     <input type="submit" name="ManagerExistingTask" value="Manage Existing Task" />
	     </form>
        </fieldset>
       </table> 
	 </center>

</body>
</html>