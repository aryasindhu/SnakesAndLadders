package com.aryasindhu.games.snl.core.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.aryasindhu.games.snl.core.bo.Action;
import com.aryasindhu.games.snl.core.bo.GamePlay;
import com.aryasindhu.games.snl.core.bo.Player;
import com.aryasindhu.games.snl.core.constants.GameStatus;
import com.aryasindhu.games.snl.core.util.GameUtil;

/**
 * 
 * @author aryasindhusahu@gmail.com
 * 
 */
public class GameController {

	private static Map<String, GamePlay> runningGames = new HashMap<String, GamePlay>();

	public static String initializeGame(Set<Player> players) {
		// initialize game play, store gameId
		Set<Action> actions = GameUtil.generateSnakesAndLadders();
		GamePlay gamePlay = new GamePlay(players, actions);
		String gameId = gamePlay.getGameId();
		runningGames.put(gameId, gamePlay);
		return gameId;
	}

	public static Player createPlayer(String playerName) {
		return new Player(playerName);
	}

	public static void rollDice(String gameId, Player player) {
		int randomDiceValue = GameUtil.rollDice();
		int oldScore = player.getScore();
		int newScore = oldScore;
		GamePlay game = getGameStatus(gameId);

		if (player.getScore() + randomDiceValue > 100) {
			System.out.println("Player :" + player
					+ " : Going beyond 100. Not Moving ahead.");
		} else if (game.getPointActionMap().containsKey(
				Integer.valueOf(player.getScore() + randomDiceValue))) {
			Action action = game.getPointActionMap().get(
					Integer.valueOf(player.getScore() + randomDiceValue));
			action.performAction(player);
		} else {
			newScore = player.getScore() + randomDiceValue;
			player.setScore(newScore);
		}
		if (player.getScore() == 100) {
			game.getCompletedPlayers().add(player.getPlayerId());
			if (game.getCompletedPlayers().size() < game.getPlayers().size()) {
				game.setStatus(GameStatus.PARTIALLY_COMPLETE);
			} else if (game.getCompletedPlayers().size() == game.getPlayers()
					.size()) {
				game.setStatus(GameStatus.COMPLETE);
			}
		}
		System.out.println("Player :" + player.getPlayerName()
				+ "["+oldScore+"], Dice Value :" + randomDiceValue + ", New Score :" + player.getScore());
		
		if(player.getScore() == 100) {
			System.out.println("Completed for Player :" + player);
		}
		
	}

	public static GamePlay getGameStatus(String gameId) {
		return runningGames.get(gameId);
	}

	public static Player getPlayer(String gameId, String playerId) {
		return runningGames.get(gameId).getPlayerIdPlayerMap().get(playerId);
	}

}
