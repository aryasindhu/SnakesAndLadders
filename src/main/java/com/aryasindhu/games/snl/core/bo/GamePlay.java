package com.aryasindhu.games.snl.core.bo;

import java.util.List;
import java.util.UUID;

import com.aryasindhu.games.snl.core.constants.GameStatus;

public class GamePlay {

	private String gameId = null;
	private GameStatus status = GameStatus.READY;
	private int winningScore = 100;
	private List<Player> players = null;
	private List<Action> actions = null;

	public GamePlay(int winningScore, List<Player> players,
			List<Action> actions) {
		super();
		this.gameId = UUID.randomUUID().toString();
		this.winningScore = winningScore;
		this.players = players;
		this.actions = actions;
	}

	public String getGameId() {
		return gameId;
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

	public List<Player> getPlayers() {
		return players;
	}

	public void setPlayers(List<Player> players) {
		this.players = players;
	}

	public List<Action> getActions() {
		return actions;
	}

	public void setActions(List<Action> actions) {
		this.actions = actions;
	}

}
