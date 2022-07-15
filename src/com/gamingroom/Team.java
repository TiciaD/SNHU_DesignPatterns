package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {
	/**
	 * A list of the active players
	 */
	private List<Player> players = new ArrayList<Player>();
	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name);
	}

	/**
	 * Construct a new player instance
	 *
	 * @param name the unique name of the player
	 * @return the player instance (new or existing)
	 */
	public Player addPlayer(String name) {

		// a local teams instance
		Player player = null;

		// create iterator object
		// This incorporates the iterator interface with the players list
		Iterator<Player> playerIterator = players.iterator();
		// start loop and check if there is another player next, if not then we've reached the end of the list and loop can terminate
		while(playerIterator.hasNext()){
			// set variable for next player, so it's easier to compare the name of the next player with the name of the player we're searching for
			Player nextPlayer = playerIterator.next();
			// if found, simply return the existing instance
			if (name.equals(nextPlayer.getName())) {
				// set local team instance to the nextPlayer object
				player = nextPlayer;
				// break from loop
				break;
			}
		}
		// if not found, make a new player instance and add to list of players
		if (player == null) {
			long nextPlayerId = GameService.getInstance().getNextPlayerId();
			player = new Player(nextPlayerId, name);
			players.add(player);
		}

		// return the new/existing player instance to the caller
		return player;
	}

	@Override
	public String toString() {
		return "Team [id=" + super.getId() + ", name=" + super.getName() + "]";
	}
}
