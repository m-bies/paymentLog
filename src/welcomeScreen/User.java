package welcomeScreen;

import java.io.FileWriter;
import java.io.IOException;

public class User {
	
	private String username;
	private String password;	
	private String salt;
	private int id = 0;
		
	public User(String username, String password) throws IOException {
		
		this.username = username;
		this.password = password;
		id = id++;
		
		salt = SaltGenerator.getSalt(4);
		
		try {
			FileWriter addNewUser = new FileWriter(WelcomeScreen.getUsersFilePath(), true);
			addNewUser.append(username + ":" + PasswordStorage.generatePasswdForStorage(password, salt) + "\n");
			addNewUser.close();
		}
		catch(IOException e) {
			System.out.println("Cannot register new user in users database.");
		}
	}
}