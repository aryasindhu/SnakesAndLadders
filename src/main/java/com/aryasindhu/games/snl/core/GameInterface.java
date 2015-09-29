package com.aryasindhu.games.snl.core;

import java.util.List;

import com.aryasindhu.games.snl.core.bo.GamePlay;
import com.aryasindhu.games.snl.core.bo.Player;

/**
 * 
 * @author aryasindhusahu@gmail.com
 *
 */
public interface GameInterface {

	public List<Player> createPlayers(List<String> playerNames);

	public String initializeGame(List<Player> players);

	public void rollDice(String gameId, Player player);
	
	public GamePlay getGameStatus(String gameId);

}
