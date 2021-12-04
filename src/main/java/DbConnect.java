import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {

	public static Statement statement;

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		try {
			User.UserExist("idiot", "null");
			/*if (User.VerifPassword("carina","hello")) {
				System.out.println("Le password est bon");
			}else {
				System.out.println("Mauvais mot de passe");
			}*/
			System.out.println("je rame pas");
		} catch (SQLException e) {
			System.out.println("Erreur en se connectant à la database"+e);
		}
	}

}
