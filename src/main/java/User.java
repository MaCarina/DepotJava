import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
	
	public String login;
	public String password;
	public String pseudo;
	public boolean etat;
	public ArrayList<User> activeMembers;
	public static Statement statement;
	public static Connection connection;
	public static int id=0;
	
	User(String login,String password,String pseudo){
		this.login = login;
		this.password = password;
		this.pseudo = pseudo;
		this.etat = true;
		this.activeMembers = null;
		this.id++;
	}
	
	public void setPseudo(String pseudo){
		this.pseudo = pseudo;
	}
	
	public String getPseudo(){
		return this.pseudo;
	}
	
	public boolean getEtat(){
		return this.etat;
	}
	
	public boolean PseudoValide(String pswd){
		//doit regarder dans la BDD tous les pseudos
		return true;
	}
	
	public void modifyPseudo(){
		
	}
	
	public static void Connexion() throws SQLException, ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","1029");
			System.out.println("Connexion ok");
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Erreur en se connectant à la database"+e);
		}
	}
	
	public static void FinConnexion() throws SQLException {
		connection.close();
	}
	
	public static boolean UserExist(String user,String p) throws SQLException, ClassNotFoundException {
		Connexion();
		ResultSet rs = statement.executeQuery("SELECT * FROM User WHERE login='"+user+"'");
		if (rs.next()) {
			if (user.equals(rs.getString(2))) {
				System.out.println("l'utilisateur existe");
				return true;
			}else {
				return false;
			}
		}else {
			//Créer l'user
			id++;
			int c = statement.executeUpdate("INSERT INTO `mydb`.`user` (`idUser`, `login`, `password`) VALUES ('"+Integer.toString(id)+"', '"+user+"','"+p+"')");
			System.out.println("user ajouté");
			//gérer idUser avec une var globale
		}
		return false;
	}
	
	public static boolean VerifPassword(String user,String pswd) throws SQLException, ClassNotFoundException {
		Connexion();
		ResultSet rs = statement.executeQuery("SELECT * FROM User WHERE login='"+user+"'");
		if (rs.next()) {
			if (user.equals(rs.getString(2))) {
				System.out.println("user OK");
			}else {
				return false;
			}
			if (pswd.equals(rs.getString(3))) {
				return true;
			}else {
				return false;
			}
		}
		return false;
	}
}
