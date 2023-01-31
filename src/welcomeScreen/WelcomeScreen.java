package welcomeScreen;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException; 
import java.util.Scanner;


public class WelcomeScreen {
	
	private static final String usersFolderName = "C:\\Users\\ZZ08SY820\\eclipse-workspace\\financeLog\\files\\users\\";
	private static final Path usersFilePath = Paths.get(usersFolderName, "users");
	private static final Path usersFolderPath = Paths.get(usersFolderName);

	public static String getUsersFilePath() {
		return usersFilePath.toString();
	}
	
	/*
	public static void login() {
		
		Scanner getDataFromUsersFile = new Scanner(getUsersFilePath());
		
		try (Scanner getCredentialsInput = new Scanner(System.in)) {
			System.out.print("username: "); 
			String inputLogin = getCredentialsInput.nextLine();
			
			//getDataFromUsersFile.findInLine(inputLogin);
			
			System.out.println(getDataFromUsersFile.findInLine(inputLogin));
		}
		
		//String user = scan.nextLine();
		
	}
	
	public static void register() {
		
	}
	*/
	public static void displayWelcomeMessage() {
		
		System.out.println("Welcome in Finance App");
	}
	
	public static void prechecks() throws IOException {
		
		checkIfUsersFileExists();
		
	}
	
	public static void checkIfUsersFileExists() throws IOException {	
		
		Files.createDirectories(usersFolderPath);
		
		try {
			Files.createFile(usersFilePath);
		}
		catch(Exception fileAlreadyExists) {
			System.out.println("Users file exists, please log in.");	
		}
	}
	

}
