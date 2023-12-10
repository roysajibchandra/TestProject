package in.timtim.DB;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection con = null;
	
	public static Connection getcon() {
		
		try {
			if(con==null) {
				Class.forName("com.mysql.cj.jdbc.Driver");			
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/shoopingcart", "root", "!@TimtimSa@1");
				System.out.println("Connected");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
		
	}
}
