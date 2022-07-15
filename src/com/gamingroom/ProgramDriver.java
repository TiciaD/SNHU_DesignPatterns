package com.gamingroom;

/**
 * Application start-up program
 * 
 * @author coce@snhu.edu
 */
public class ProgramDriver {
	
	/**
	 * The one-and-only main() method
	 * 
	 * @param args command line arguments
	 */
	public static void main(String[] args) {
		
		// FIXME: obtain reference to the singleton instance
		GameService service = GameService.getInstance(); // replace null with the method to get the only instance of GameService
		
		System.out.println("\nAbout to test initializing game data...");
		
		// initialize with some game data
		Game game1 = service.addGame("Game #1");
		System.out.println("Game 1: " + game1);
		Game game2 = service.addGame("Game #2");
		System.out.println("Game 2: " + game2);
		
		// use another class to prove there is only one instance
		SingletonTester tester = new SingletonTester();
		tester.testSingleton();

		// another class to test Teams
		Team team1 = game1.addTeam("Wombats");
		Team team2 = game1.addTeam("Wildcats");
		System.out.println("Team 1: " + team1);
		System.out.println("Team 2: " + team2);

		// another class to test Players
		Player player1 = team1.addPlayer("Michael");
		Player player2 = team1.addPlayer("Steven");
		System.out.println("Player 1: " + player1);
		System.out.println("Player 2: " + player2);
	}
}
