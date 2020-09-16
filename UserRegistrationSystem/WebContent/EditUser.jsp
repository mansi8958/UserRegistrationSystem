<%@page import="beans.UserDetails"%>
<%@page import="beans.UserDetailsDao"%>
<%@page import="beans.UserDetailsDaoImplementation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<c:import url="header.jsp"></c:import>

<%
UserDetailsDao usdDao = new UserDetailsDaoImplementation();
UserDetails user = usdDao.fetchUser(Integer.parseInt(request.getParameter("id")));
%>

</head>
<body class="container" style="background-color:Aqua;">
<div>
		<h1>EDIT USER</h1>
		<hr>
	</div>
	
	<form action="/UserRegistrationSystem/RegisterOperation" method="post">
        <table>
			<tr>
				<td>User Name :</td>
				<td><input type="text" value="<%= user.getUsername() %>" name="userName" size="30" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" value="<%= user.getPassword() %>" name="password" size="30" /></td>
			</tr>
			<tr>
				<td>Age :</td>
				<td><input type="number" value="<%= user.getAge() %>" name="age" min="10" max="99" /></td>
			</tr>
			<tr>
				<td>Gender:</td>
				<td>
					<select id="gender" name="gender">
						<option value="male">Male</option>
						<option value="female">Female</option>
				</select>
				</td>
			</tr>
			<tr>
				<td>Contact Number :</td>
				<td><input type="text" value="<%= user.getC_num() %>" name="c_num" pattern="[6789][0-9]{9}"/></td>
			</tr>
			<tr>
				<td>Email :</td>
				<td><input type="email" value="<%= user.getEmail() %>" name="email" size="30" /></td>
			</tr>
		</table>
        <p />
	<input type="hidden" name="id" value="<%=user.getId()%>">
	<button name="action" value="update" type="submit" class="btn btn-primary">EDIT</button>
    </form>

</body>
</html>