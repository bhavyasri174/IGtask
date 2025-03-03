package com.insight.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Types;
import java.util.Scanner;

import com.mysql.cj.jdbc.CallableStatement;

public class CallableDemo {

	public static void main(String[] args)  throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//step 2
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ig","root","Ammulu174");
			System.out.println(" connection is success");
			//step3 
			CallableStatement cst=(CallableStatement) con.prepareCall("{CALL arthSum(?,?)}");
			Scanner sc=new Scanner(System.in);
			int a=sc.nextInt();
			cst.setInt(1,a);
			cst.registerOutParameter(2,Types.INTEGER);
			cst.execute();
			int b=cst.getInt(2);
			System.out.println("REsult"+b);
}

}
/*
 * 
DELIMITER $$
CREATE PROCEDURE addnum(in x int  ,out y int )
BEGIN
   set y =x*x;
END $$
DELIMITER ;

*/