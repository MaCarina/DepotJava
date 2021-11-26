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
		for (int i=0;i< Liste_Users.size();i++) {
			if (Liste_Users[i]==user) then
				return true
		}
		return false;
	}
	
	public boolean VerifPassword() {
		return true;
	}
}
