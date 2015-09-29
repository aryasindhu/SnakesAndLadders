package com.aryasindhu.games.snl.core;

import java.util.HashSet;
import java.util.Set;

import com.aryasindhu.games.snl.core.bo.GamePlay;
import com.aryasindhu.games.snl.core.bo.Player;
import com.aryasindhu.games.snl.core.controller.GameController;

/**
 * 
 * @author aryasindhusahu@gmail.com
 * 
 */
public class ConsoleBasedGame implements GameInterface {

	@Override
	public Set<Player> createPlayers(Set<String> playerNames) {
		Set<Player> players = new HashSet<Player>(playerNames.size());
		for (String playerName : playerNames) {
			players.add(GameController.createPlayer(playerName));
		}
		return players;
	}

	@Override
	public String initializeGame(Set<Player> players) {
		return GameController.initializeGame(players);
	}

	@Override
	public void rollDice(String gameId, Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public GamePlay getGameStatus(String gameId) {
		return GameController.getGameStatus(gameId);
	}

}
