package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	// FIXME: Add missing pieces to turn this class a singleton
	/*
	* We use a singleton because we will only ever need one instance of the GameService object at a time
	* We don't need new GameServices we just need access to the one already created
	* */
	// create a GameService object
	// that way this class holds the only instantiation of this object
	public static GameService gameService = new GameService();

	// make a private constructor so GameService object cannot be instantiated again
	private GameService() {}

	// public method to grab the only instance of GameService object
	// Other methods can access the instantiated object but can't create a new one
	public static GameService getGameService() {
		return gameService;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		/*
		* We use the iterator pattern so we don't have to worry about the underlying data structure of the games
		* We just need an easy way to traverse through that data structure
		*/
		// create iterator object
		// This incorporates the iterator interface with the games list
		Iterator<Game> gameIterator = games.iterator();
		// start loop and check if there is another game next, if not then we've reached the end of the list and loop can terminate
		while(gameIterator.hasNext()){
			// set variable for next game, so it's easier to compare the name of the next game with the name of the game we're searching for
			Game nextGame = gameIterator.next();
			// if found, simply return the existing instance
			if (name.equals(nextGame.getName())) {
				// set local game instance to the nextGame object
				game = nextGame;
				// break from loop
				break;
			}
		}
		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same id
		// create iterator object
		// This incorporates the iterator interface with the games list
		Iterator<Game> gameIterator = games.iterator();
		// start loop and check if there is another game next, if not then we've reached the end of the list and loop can terminate
		while(gameIterator.hasNext()){
			// set variable for next game, so it's easier to compare the id of the next game with the id of the game we're searching for
			Game nextGame = gameIterator.next();
			// if found, simply assign that instance to the local variable
			if (id == nextGame.getId()) {
				// set local game instance to the nextGame object
				game = nextGame;
				// break from loop
				break;
			}
		}


		return game;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// a local game instance
		Game game = null;

		// FIXME: Use iterator to look for existing game with same name
		// create iterator object
		// This incorporates the iterator interface with the games list
		Iterator<Game> gameIterator = games.iterator();
		// start loop and check if there is another game next, if not then we've reached the end of the list and loop can terminate
		while(gameIterator.hasNext()){
			// set variable for next game, so it's easier to compare the name of the next game with the name of the game we're searching for
			Game nextGame = gameIterator.next();
			// if found, simply assign that instance to the local variable
			if (name.equals(nextGame.getName())) {
				// set local game instance to the nextGame object
				game = nextGame;
				// break from loop
				break;
			}
		}
		// if found, simply assign that instance to the local variable

		return game;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
