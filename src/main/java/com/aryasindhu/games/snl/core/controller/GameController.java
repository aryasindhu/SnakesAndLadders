package com.aryasindhu.games.snl.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.aryasindhu.games.snl.core.bo.Action;
import com.aryasindhu.games.snl.core.bo.GamePlay;
import com.aryasindhu.games.snl.core.bo.Player;
import com.aryasindhu.games.snl.core.util.GameUtil;

/**
 * 
 * @author aryasindhusahu@gmail.com
 *
 */
public class GameController {

	private static Map<String, GamePlay> runningGames = new HashMap<String, GamePlay>();
	
	public static String initializeGame(List<Player> players) {
		// initialize game play, store gameId
		List<Action> actions = GameUtil.generateSnakesAndLadders();
		GamePlay gamePlay =new GamePlay(players, actions);
		String gameId = gamePlay.getGameId();
		runningGames.put(gameId, gamePlay);
		return gameId;
	}

	public static Player createPlayer(String playerName) {
		return new Player(playerName);
	}
	
	public void rollDice(String gameId, Player player) {
		int randomDiceValue = GameUtil.rollDice();
		//call game service to perform operation
		System.out.println("GameId : " + gameId + ", Player :" + player + ", Dice :" + randomDiceValue);
	}
	
	private void performDiceOperation() {
		
	}

}
