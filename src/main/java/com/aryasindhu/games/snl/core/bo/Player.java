package com.aryasindhu.games.snl.core.bo;

import java.util.UUID;

/**
 * 
 * @author aryasindhusahu@gmail.com
 *
 */
public class Player {

	private String playerId = null;
	private String playerName = null;
	private int score = 1;

	public Player(String playerName) {
		super();
		this.playerId = UUID.randomUUID().toString();
		this.playerName = playerName;
	}

	public String getPlayerId() {
		return playerId;
	}

	public void setPlayerId(String playerId) {
		this.playerId = playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
