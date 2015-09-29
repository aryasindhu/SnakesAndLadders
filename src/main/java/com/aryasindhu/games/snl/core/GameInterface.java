package com.aryasindhu.games.snl.core;

import java.util.Set;

import com.aryasindhu.games.snl.core.bo.GamePlay;
import com.aryasindhu.games.snl.core.bo.Player;

/**
 * 
 * @author aryasindhusahu@gmail.com
 * 
 */
public interface GameInterface {

	public Set<Player> createPlayers(Set<String> playerNames);

	public String initializeGame(Set<Player> players);

	public void rollDice(String gameId, Player player);

	public GamePlay getGameStatus(String gameId);

}
