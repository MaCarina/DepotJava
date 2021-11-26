import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class User {
	
	public String login;
	public String password;
	public String pseudo;
	public boolean etat;
	public ArrayList<User> activeMembers;
	
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
	
	public boolean PseudoValide(){
		//doit regarder dans la BDD tous les pseudos
		return true;
	}
	
	public void modifyPseudo(){
		
	}
	
	public boolean UserExist(User user) {
		//récupérer le login et le mot de passe
		//faire une recherche dans la table sql pour voir si elle existe
		Connection Con = null;
		Class.forName("");
		Con = DriverManager.getConnection("");
		Statement statement = Con.createStatement();
		ResultSet rs = statement.executeQuery("SELECT...WHERE...");
		if (rs==1) then return true;
		else return false;
		Con.close();
	}
	
	public boolean VerifPassword() {
		return true;
	}
}
