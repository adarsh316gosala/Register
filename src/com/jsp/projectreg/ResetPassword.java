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
@WebServlet("/ResetPassword")
public class ResetPassword  extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException 
	{
		String email=req.getParameter("e");
		String password=req.getParameter("p");
		
		
		
	   String url="jdbc:mysql://localhost:3306?user=root&password=12345";
	   String query="update teja18.reg set password=? where email=?";
	   try {
		   Class.forName("com.mysql.jdbc.Driver");
		Connection connection=DriverManager.getConnection(url);
		     PreparedStatement ps =connection.prepareStatement(query);
		     ps.setString(1, password);
		     ps.setString(2,email);
		     PrintWriter writer=res.getWriter();
		     int r=ps.executeUpdate();
		    if(r>0)
		    {
		    	RequestDispatcher dispatcher=req.getRequestDispatcher("studentlogin.html");
				 dispatcher.include(req, res);
		    	writer.println("<h2 style='color:green;'>Password reset sucessfully....</h2>");
		    }
		    else
		    {
		    	RequestDispatcher dispatcher=req.getRequestDispatcher("studentlogin.html");
				 dispatcher.include(req, res);
		    	writer.println(" <h2 style='color:red;'>password Reset Falied....</h2>");
		    }
		   
		     connection.close();
	} catch (SQLException | ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   
	}

}




