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
	public Statement statement;
	public Connection Con;
	
	public User(String login,String password,String pseudo,boolean etat,ArrayList<User> activeMembers){
		this.login = login;
		this.password = password;
		this.pseudo = pseudo;
		this.etat = etat;
		this.activeMembers = activeMembers;
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
	
	public void Connexion() throws SQLException, ClassNotFoundException {
		Con = null;
		Class.forName("com.mysql.jdbc.Driver");
		Con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb");
		statement = Con.createStatement();
	}
	
	public void FinConnexion() throws SQLException {
		Con.close();
	}
	
	public boolean UserExist(String user) throws SQLException, ClassNotFoundException {
		//récupérer le login et le mot de passe
		//faire une recherche dans la table sql pour voir si elle existe
		ResultSet rs = statement.executeQuery("SELECT login FROM User WHERE login=user");
		//if (rs==1) then return true;
		//else return false;
		FinConnexion();
		return true;
	}
	
	public boolean VerifPassword(String pswd) throws SQLException {
		ResultSet rs = statement.executeQuery("SELECT login FROM User WHERE passwd=pswd");
		//if (rs==1) then return true;
		//else return false;
		FinConnexion();
		return true;
	}
	
	public void main (String args[]) throws ClassNotFoundException, SQLException {
		Connexion();
		System.out.println("je suis connectée\n");
		FinConnexion();
	}
}
