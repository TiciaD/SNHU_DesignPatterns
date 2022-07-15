package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a game
 * 
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a game is
 * created.
 * </p>
 * 
 * @author coce@snhu.edu
 *
 */
public class Game extends Entity {
	/**
	 * A list of the active teams
	 */
	private List<Team> teams = new ArrayList<Team>();
	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
		super(id, name);
	}

	/**
	 * Construct a new team instance
	 *
	 * @param name the unique name of the team
	 * @return the team instance (new or existing)
	 */
	public Team addTeam(String name) {
		// a local team instance
		Team team = null;

		// create iterator object
		// This incorporates the iterator interface with the teams list
		Iterator<Team> teamIterator = teams.iterator();
		// start loop and check if there is another team next, if not then we've reached the end of the list and loop can terminate
		while(teamIterator.hasNext()){
			// set variable for next team, so it's easier to compare the name of the next team with the name of the team we're searching for
			Team nextTeam = teamIterator.next();
			// if found, simply return the existing instance
			if (name.equals(nextTeam.getName())) {
				// set local team instance to the nextTeam object
				team = nextTeam;
				// break from loop
				break;
			}
		}

		// if not found, make a new team instance and add to list of teams
		if (team == null) {
			long nextTeamId = GameService.getInstance().getNextTeamId();
			team = new Team(nextTeamId, name);
			teams.add(team);
		}

		// return the new/existing team instance to the caller
		return team;
	}
	@Override
	public String toString() {
		return "Game [id=" + super.getId() + ", name=" + super.getName() + "]";
	}

}
