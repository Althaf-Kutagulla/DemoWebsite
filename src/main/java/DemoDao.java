//comment
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DemoDao {
	Connection con=null;
	public void connectDB() {
		
		try {
			 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/college","root","althaf");
			 
			 
		}catch(Exception ex) {
			
			System.out.println(ex);
		}
	}
	
	public boolean isValidLogin(String username, String password) throws SQLException {
		
		connectDB();
		
		Statement st = con.createStatement();
		
		ResultSet rs = st.executeQuery("SELECT * FROM student WHERE username='Althaf' AND password='password'");
		
		if(rs.next()) {
			return true;
		}
		
		return false;
		
	}

}
