package servlet;

import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.UserDetails;
import beans.UserDetailsDao;
import beans.UserDetailsDaoImplementation;


@WebServlet("/RegisterOperation")
public class RegisterOperation extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		
		String action = req.getParameter("action");
		PrintWriter out = resp.getWriter();
		
		switch(action) {
		case "insert":
			System.out.println("Reached");
			String username = req.getParameter("userName");
			String password = req.getParameter("password");
			String gender = req.getParameter("gender");
			int age = Integer.parseInt(req.getParameter("age"));
			long c_num = Long.parseLong(req.getParameter("c_num"));
			String email = req.getParameter("email");
			
			try {
				UserDetailsDao usdDao = new UserDetailsDaoImplementation();
				usdDao.addUser(username,password,gender,age,c_num,email);
				out.println("<h1>User Added</h1>");
			}catch(Exception e){
				e.printStackTrace();
			}
			break;
		
		case "delete":
			int id = Integer.parseInt(req.getParameter("id"));
			try {
				UserDetailsDao usdDao = new UserDetailsDaoImplementation();
				usdDao.remove(id);
				out.println("<h1>User Deleted</h1>");
			}catch(Exception e){
				e.printStackTrace();
			}
			break;
			
		case "update":
			id = Integer.parseInt(req.getParameter("id"));
			username = req.getParameter("userName");
			password = req.getParameter("password");
			gender = req.getParameter("gender");
			age = Integer.parseInt(req.getParameter("age"));
			c_num = Long.parseLong(req.getParameter("c_num"));
			email = req.getParameter("email");
			
			UserDetails user = new UserDetails();
			user.setId(id);
			user.setUsername(username);
			user.setPassword(password);
			user.setGender(gender);
			user.setAge(age);
			user.setC_num(c_num);
			user.setEmail(email);
			
			boolean result = new UserDetailsDaoImplementation().update(user);
			
			if (result) {
				out.println("<h1>User Updated Successfully</h1>");
			} else {
				out.println("<h1>User Update Failure</h1>");
			}
		
		
		}
		
		
		
		
		
	}
	
}
