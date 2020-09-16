<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="beans.UserDetails"%>
<%@page import="beans.UserDetailsDao"%>
<%@page import="beans.UserDetailsDaoImplementation"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<c:import url="header.jsp"></c:import>

<style type="text/css">
body{
	background-image: url("https://images.pexels.com/photos/1130643/pexels-photo-1130643.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940");
}

.form-control{
		margin: 10px; 
}

h3,h1{
	color: #c2b9a5;
}

</style>

</head>
<body class="container">
 <div class="col-sm-12 form-heading">
				<h1>Registration form</h1><hr>
			</div>
		<form action="/UserRegistrationSystem/RegisterOperation" method="post">
        <table class="row">
			<tr class="form-group col-sm-12">
				<td><input type="text" placeholder="Enter Your Name" size="100%" class="form-control" name="userName" /></td>
			</tr>
			<tr class="form-group col-sm-12">
				<td><input class="form-control" placeholder="Password" type="password" name="password" size="30" /></td>
			</tr>
			<tr class="form-group col-sm-12">
				<td><input type="number" class="form-control" placeholder="Age" name="age" min="10" max="99" /></td>
			</tr>
			<tr class="form-group col-sm-12">
				
				<td>
					<select class="form-control" id="gender" name="gender">
						<option value="male">Male</option>
						<option value="female">Female</option>
				</select>
				</td>
			</tr>
			<tr class="form-group col-sm-12">
				<td><input type="text" class="form-control" maxlength="10" placeholder="Mobile No." name="c_num" pattern="[6789][0-9]{9}"/></td>
			</tr>
			<tr class="form-group col-sm-12">
				<td><input type="email" class="form-control" name="email" placeholder="Email" size="30" /></td>
			</tr>
		</table>
        <p />
		<input type="hidden" name="action" value="insert" />
		<button type="submit" class="btn btn-primary ">REGISTER</button>
    </form>
<br><hr>

	<h3>CURRENT USERS :</h3>
    
    <div class="container">
    <table class="table table-dark table-striped">
    
    	<thead>
    		<tr>
    		
    		<th>ID</th>
    		<th>USERNAME</th>
    		<th>AGE</th>
    		<th>GENDER</th>
    		<th>CONTACT NUMBER</th>
    		<th>EMAIL</th>
    		<th>OPERATIONS</th>
    		
    		</tr>
    	</thead>
    	
    	
   
    		<tr>
    		
    	<%
    	UserDetailsDao usdDao = new UserDetailsDaoImplementation();
    	for(UserDetails userDetails : usdDao.fetchAllUsers()){
    	%>
    	<tr>
    	<td><%= userDetails.getId() %> </td>
    	<td><%= userDetails.getUsername()%> </td>
    	<td><%= userDetails.getAge()%> </td>
    	<td><%= userDetails.getGender()%> </td>
    	<td><%= userDetails.getC_num()%> </td>
    	<td><%= userDetails.getEmail()%> </td>
    	<td>
    	<form action="/HibernateForm/RegisterOperation" method="post" style="display:inline;">	
   			<input type="hidden" name="id" value="<%= userDetails.getId()%>">
    		<input type="hidden" name="action" value="delete">
    		<button type="submit" class="btn btn-danger btn-sm fas fa-minus">Delete</button>
    	</form>
    	<a href="/HibernateForm/EditUser.jsp?id=<%= userDetails.getId()%>"  class="btn btn-success btn-sm fas fa-cog" style="margin-left:50px;">Edit</a>
    	</td>
    	</tr>
    		
    	<%  } 
    		%>
    
    </table>
    </div>

</body>
</html>