package jdbc;

import java.sql.*;

public class JDBC {

	public static void main(String[] args) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/office","root","shashank@97");
			Statement statement = con.createStatement();
			ResultSet result = statement.executeQuery("call joinTables");
			
			while(result.next()) {
				System.out.println(result.getInt(1) + "        " + result.getString(2) + "          " + result.getString(3) + "            " + result.getString(4));
			}
			
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
