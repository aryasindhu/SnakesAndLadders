package com.aryasindhu.games.snl.core.bo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
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
	private Map<String, Player> playerIdPlayerMap = null;
	private Set<Action> actions = null;
	private Map<Integer, Action> pointActionMap = null;
	private List<String> completedPlayers = null;

	public GamePlay(Set<Player> players, Set<Action> actions) {
		super();
		this.gameId = UUID.randomUUID().toString();
		this.players = players;
		this.actions = actions;

		completedPlayers = new ArrayList<String>(players.size());
		playerIdPlayerMap = new HashMap<String, Player>(players.size());
		for (Player player : players) {
			playerIdPlayerMap.put(player.getPlayerId(), player);
		}

		pointActionMap = new HashMap<Integer, Action>(actions.size());
		for (Action action : actions) {
			pointActionMap.put(action.getSourceScore(), action);
		}
	}

	public Map<String, Player> getPlayerIdPlayerMap() {
		return playerIdPlayerMap;
	}

	public List<String> getCompletedPlayers() {
		return completedPlayers;
	}

	public Map<Integer, Action> getPointActionMap() {
		return pointActionMap;
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
