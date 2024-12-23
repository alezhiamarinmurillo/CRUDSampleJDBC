package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
	Connection cx = null;
	
	public Connection connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			cx = DriverManager.getConnection("jdbc:mysql://localhost:3306/migros", "root", "mysql");
			System.out.println("Connected :)");
		} catch (ClassNotFoundException | SQLException e ) {
			System.out.println("Not connected :(");
		}
		return cx;
	}
	
	public void disconnect() {
		try {
			cx.close();
			System.out.println("Disconnected :)");
		} catch (Exception e) {
			System.out.println("A problem occurs when trying to disconnect :(");
		}
	}
	
	public static void main(String[] args) {
		MyConnection cx = new MyConnection();
		cx.connect();
		cx.disconnect();
	}
}
