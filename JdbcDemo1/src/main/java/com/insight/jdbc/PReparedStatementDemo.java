package com.insight.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.Scanner;



public class PReparedStatementDemo {

	

		public static void main(String[] args) throws Exception{
		//step1	
		Class.forName("com.mysql.cj.jdbc.Driver");
		//step 2
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ig","root","Ammulu174");
			System.out.println(" connection is success");
			//step3 
			Statement st=con.createStatement();
			Scanner sc=new Scanner(System.in);
			PreparedStatement pst=con.prepareStatement("insert into product1 values(?,?)");
			for(int i=1;i<=3;i++) {
				int id=sc.nextInt();
				String name=sc.next();
				pst.setInt(1,id);
				pst.setString(2,name);
				pst.execute();
			}
			System.out.println("Inserted");
			ResultSet rs=st.executeQuery("select * from product1");
			ResultSetMetaData rsmd=rs.getMetaData();
			for(int i=1;i<=rsmd.getColumnCount();i++) {
				System.out.print("  " +rsmd.getColumnName(i));
			}
			System.out.println();
			while(rs.next()) {
				System.out.println(rs.getString(1)+"  "+rs.getString(2));
			}
			
		}

	}