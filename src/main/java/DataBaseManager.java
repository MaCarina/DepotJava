import java.util.ArrayList;
import java.util.Arrays;

public class DataBaseManager {
	
	public ArrayList<User> Discussion;
	public ArrayList<Message> Liste_messages;
	
	public DataBaseManager() {
		ArrayList<User> Discussion = new ArrayList<User>();
		ArrayList<Message> Liste_messages = new ArrayList<Message>();
		ArrayList<User> Liste_Users = new ArrayList<User>();
	}
	
	public ArrayList<Message> getHistory(User user1, User user2) {
		//aller chercher le numéro de discussion dans la liste discussion entre user1 et user2
		//retourner tous les messages de la liste messages qui ont ce numéro de discussion
		return this.Liste_messages;
	}
	
	public void addMessages(Message M,User user1,User user2) {
		//aller chercher le numéro de discussion dans la liste discussion entre user1 et user2
		//ajouter le message avec ce numéro de discussion dans la liste messages
		if ((==user1 && ==user2) | (==))
	}
	
	public void addUser(User user){
		Liste_Users.add(user);
	}
}
