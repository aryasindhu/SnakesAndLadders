package com.aryasindhu.games.snl.core.bo;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.aryasindhu.games.snl.core.constants.GameStatus;
import com.google.gson.Gson;

/**
 * 
 * @author aryasindhusahu@gmail.com
 * 
 */
public class GamePlay {

	private String gameId = null;
	private GameStatus status = GameStatus.READY;
	private int winningScore = 100;
	private Set<Player> players = null;
	private Set<Action> actions = null;
	private Set<Integer> actionPoints = null;

	public GamePlay(Set<Player> players, Set<Action> actions) {
		super();
		this.gameId = UUID.randomUUID().toString();
		this.players = players;
		this.actions = actions;

		actionPoints = new HashSet<Integer>(players.size());
		for (Action action : actions) {
			actionPoints.add(action.getSourceScore());
		}
	}

	public Set<Integer> getActionPoints() {
		return actionPoints;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public GameStatus getStatus() {
		return status;
	}

	public void setStatus(GameStatus status) {
		this.status = status;
	}

	public int getWinningScore() {
		return winningScore;
	}

	public void setWinningScore(int winningScore) {
		this.winningScore = winningScore;
	}

	public Set<Player> getPlayers() {
		return players;
	}

	public void setPlayers(Set<Player> players) {
		this.players = players;
	}

	public Set<Action> getActions() {
		return actions;
	}

	public void setActions(Set<Action> actions) {
		this.actions = actions;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("GameId :" + gameId + "\n");
		builder.append("Game Status :" + status + "\n");
		builder.append("Winning Score :" + winningScore + "\n");
		builder.append("Players :" + new Gson().toJson(players) + "\n");
		builder.append("Actions :" + new Gson().toJson(actions) + "\n");
		return builder.toString();
	}

}
