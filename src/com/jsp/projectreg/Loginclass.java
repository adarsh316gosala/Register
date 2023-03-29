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
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/Loginclass")
public class Loginclass extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {


	
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		String url="jdbc:mysql://localhost:3306?user=root&password=12345";
		String query="select * from teja18.reg where email=? and password=?";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement ps=connection.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			PrintWriter writer=res.getWriter();
			if(rs.next())
			{
				RequestDispatcher dispatcher=req.getRequestDispatcher("welcome.html");
				 dispatcher.include(req, res);

				 writer.print("<h3 style='color:green;'>login sucessfully...</h3>");
				  writer.print("<h2 style='color:blue;'>wellcome to the WebPage:"+rs.getString("fullname")+"</h2>");
				
			   
			
			}
			
			else
			{
				RequestDispatcher dispatcher=req.getRequestDispatcher("studentlogin.html");
				 dispatcher.include(req, res);
				writer.print("<h3 style='color:red;'>invalid password or emailid...</h3>");
				 
			}
			connection.close();
		} catch (SQLException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	
	

		
	}
	


