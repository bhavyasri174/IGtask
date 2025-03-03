package com.insight.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class JdbcDemo1 {
	public static void main(String[] args) // throws ClassNotFoundException,SQLException
	{	//step1
		Connection con;
		Statement st;
		ResultSet rs;
		try { //connection
			Class.forName("com.mysql.cj.jdbc.Driver");
			//step2
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ig","root","Ammulu174");
			System.out.println("connection success");
			 st=con.createStatement();
		 //BL
			st.executeUpdate("create table product1(id int primary key,name varchar(20))");
			st.executeUpdate("insert into product1 values(4,'box')");
			st.executeUpdate("insert into product1 values(5,'bag')");
			st.executeUpdate("insert into product1 values(3,'box3')");
			st.executeUpdate("insert into product1 values(2,'box4')");
			
			st.execute("update product1 set name='table' where id=2");
			st.execute("delete from product1 where id=3");
			
		ResultSet rs1=st.executeQuery("select * from product");
			while(rs1.next()) {
				System.out.println(rs1.getString(1)+  "  "+rs1.getString(2));
			}
			System.out.println("table creation success");
			
					
		}
		catch(ClassNotFoundException | SQLException e) {
			
		}
		/*
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			rs.close();
			st.close();
			con.close();
		}
		
*/
	}

}


/*

<dependency>
<groupId>mysql</groupId>
<artifactId>mysql-connector-java</artifactId>
<version>8.0.28</version>
</dependency>



*/