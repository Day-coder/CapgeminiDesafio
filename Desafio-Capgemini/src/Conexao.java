import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	public  static Connection C() {
		try {

			return DriverManager.getConnection("jdbc:mysql://localhost:3306/DesafioC", "root", "****");
		} 
		catch (SQLException ex) {
			System.out.println("erro SQLException" + ex);
		}
		return null;
	}

}
