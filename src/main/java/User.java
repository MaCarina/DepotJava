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
	public static ArrayList<User> activeMembers;
	public static int nb_user=0;
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
		this.nb_user++;
	}
	
	User(ResultSet rs) throws SQLException {
		this.login=rs.getString(2);
		this.password=rs.getString(3);
		this.etat=rs.getBoolean(4);
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
	
	public static boolean PseudoValide(String pseudo){
		//doit regarder dans la BDD tous les pseudos
		return true;
	}
	
	public void modifyPseudo(){
		
	}
	
	public static void Connexion() throws SQLException, ClassNotFoundException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://srv-bdens.insa-toulouse.fr:3306/tp_servlet_002","tp_servlet_002","fi6Cho0e");
			System.out.println("Connexion ok");
			statement = connection.createStatement();
		} catch (SQLException e) {
			System.out.println("Erreur en se connectant à la database"+e);
		} catch (ClassNotFoundException c) {
			System.out.println("Erreur en se connectant à la database: classe non trouvée"+c);
		}
	}
	
	public static void FinConnexion() throws SQLException {
		connection.close();
	}
	
	public static boolean UserExist(String user,String p) throws SQLException, ClassNotFoundException {
		Connexion();
		ResultSet rs = statement.executeQuery("SELECT * FROM user WHERE login='"+user+"'");
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
			int c = statement.executeUpdate("INSERT INTO `tp_servlet_002`.`user` (`idUser`, `login`, `password`) VALUES ('100', '"+user+"','"+p+"')");
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
	
	public static ArrayList<User> ActiveUsers () throws SQLException, ClassNotFoundException{
		Connexion();
		ResultSet rs = statement.executeQuery("SELECT * FROM user WHERE etat='1'");
		ArrayList<User> liste = new ArrayList<User>(nb_user);
		while(rs.next()) {
			liste.add(new User(rs));
			System.out.println("id = "+rs.getInt(1)+" login = "+rs.getString(2)+" password = "+rs.getString(3)+" etat = "+rs.getInt(4));
		}
		return liste;
		
	}
}
