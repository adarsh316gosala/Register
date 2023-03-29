package com.jsp.projectreg;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import javax.servlet.GenericServlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/registrationclass")
public class registrationclass extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
	
		 String fullname=req.getParameter("FullName");
		 String email=req.getParameter("email");
		 String mobile=req.getParameter("mobile");
		 String password=req.getParameter("password");
		 
		 
		 String url="jdbc:mysql://localhost:3306?user=root&password=12345";
		 String query="insert into teja18.reg values (?,?,?,?)";
		 try {
			 Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, fullname);
			ps.setString(2, email);
			ps.setString(3, mobile);
			ps.setString(4, password);
			PrintWriter writer=res.getWriter();
		int up=ps.executeUpdate();
		
		if(up>0)
		{
			
			RequestDispatcher dispathcer=req.getRequestDispatcher("studentlogin.html");
			dispathcer.include(req, res);
			writer.print("<h2>sucessfully registered.</h2>");
		
		}
		connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				 
	}
	

}
