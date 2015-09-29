package com.aryasindhu.games.snl.starter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import com.aryasindhu.games.snl.core.ConsoleBasedGame;
import com.aryasindhu.games.snl.core.GameInterface;
import com.aryasindhu.games.snl.core.bo.GamePlay;
import com.aryasindhu.games.snl.core.bo.Player;
import com.aryasindhu.games.snl.core.constants.GameStatus;
import com.aryasindhu.games.snl.core.controller.GameController;

/**
 * 
 * @author aryasindhusahu@gmail.com
 * 
 */
public class GameStarter {

	
	public static void main(String[] args) {
		try {
			BufferedReader bufferRead = new BufferedReader(
					new InputStreamReader(System.in));
			System.out.print("How many Players :");
			int noOfPlayers = Integer.parseInt(bufferRead.readLine());
			System.out.println();
			System.out.println("Enter Name of Players");
			System.out.println("========================");
			Set<String> playerNames = new HashSet<String>(noOfPlayers);
			for (int index = 1; index <= noOfPlayers; index++) {
				System.out.print("Player " + index + " : ");
				playerNames.add(bufferRead.readLine());
				System.out.println();
			}

			GameInterface consoleGame = new ConsoleBasedGame();

			// Create players
			Set<Player> players = consoleGame.createPlayers(playerNames);
			String gameId = consoleGame.initializeGame(players);

			// get game details
			GamePlay thisGame = consoleGame.getGameStatus(gameId);

			System.out
					.println("***********************************************");
			System.out.println(thisGame);
			System.out
					.println("***********************************************");

			Iterator<Player> playersItr = players.iterator();
			while (thisGame.getStatus() != GameStatus.COMPLETE) {
				Player currentPlayer = playersItr.next();
				if (!playersItr.hasNext()) {
					playersItr = players.iterator();
				}
				if (thisGame.getCompletedPlayers().contains(
						currentPlayer.getPlayerId())) {
					continue;
				}
				GameController.rollDice(gameId, currentPlayer);
				if (!thisGame.getCompletedPlayers().isEmpty()) {
					System.out.println("Completed Players :");
					for (String playerId : thisGame.getCompletedPlayers()) {
						System.out.println(GameController.getPlayer(gameId,
								playerId));
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
