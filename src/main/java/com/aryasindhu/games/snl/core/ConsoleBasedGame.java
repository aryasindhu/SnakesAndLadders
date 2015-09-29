package com.aryasindhu.games.snl.core;

import java.util.ArrayList;
import java.util.List;

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
	public List<Player> createPlayers(List<String> playerNames) {
		List<Player> players = new ArrayList<Player>(playerNames.size());
		for (String playerName : playerNames) {
			players.add(GameController.createPlayer(playerName));
		}
		return players;
	}

	@Override
	public String initializeGame(List<Player> players) {
		return GameController.initializeGame(players);
	}

	@Override
	public void rollDice(String gameId, Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public GamePlay getGameStatus(String gameId) {
		// TODO Auto-generated method stub
		return null;
	}

}
