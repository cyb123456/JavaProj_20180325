package com.jsp3;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.annotation.WebServlet;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// test
		System.out.println("doGet method called here...");
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// test
		System.out.println("doPost method called here...");
		
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// set mysql driver
		String driver = "com.mysql.jdbc.Driver";
		// set url of database
		String url = "jdbc:mysql://localhost/test1";
		// String url = "jdbc:mysql://39.108.144.46/login";
		// set the user and password of database
		String user = "root";
		String password = "123456";
		// String password = "passw0rd";
		// username and password read from login page
		String username = request.getParameter("username");
		String pwd = request.getParameter("pwd");
		// String pwd = request.getParameter("password");
		
		Connection conn = null;
		ResultSet rs = null;
		try{
			// Executed here...
			// load driver
			Class.forName(driver);
			// get connected
			conn = (Connection) DriverManager.getConnection(url, user, password);

			//
			//PrintWriter pw1 = response.getWriter();
			//pw1.println("<script>");
			//pw1.println("alert('Logining!');");
			//pw1.println("history.back();");
			//pw1.println("</script>");
			//
			
			// prepare for querying in mysql
			String sql = "select * from user where username=? and psw=?";			
			// String sql = "select * from user where username=? and password=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pwd);
			
			// System.out.println(ps);
			
			// result of the query 
			rs = ps.executeQuery();
			// if the username exists and matches its password
			if (rs.next()){
				// test
				System.out.println("login successfully...");
				
				// alert shown on screen
				
				PrintWriter pw = response.getWriter();
				pw.flush();
				pw.println("<script>");
				pw.println("alert('Login successfully');");
				pw.println("history.back();");
				pw.println("</script>");
				pw.close();
			}else{
				// test
				System.out.println("psw or user incorrect...");
				
				// alert shown on screen
				PrintWriter pw = response.getWriter();
				pw.flush();
				pw.println("<script>");
				pw.println("alert('Password incorrect or no such user!');");
				pw.println("history.back();");
				pw.println("</script>");
				pw.close();
			}
				
			ps.close();
			
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			// close the connection
			if (conn != null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(rs != null){
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		// Executede here...
		doGet(request, response);
	}

}
