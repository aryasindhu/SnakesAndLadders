package com.aryasindhu.games.snl.core.bo;

public class Player {

	public Player(String playerName) {
		super();
		this.playerName = playerName;
	}

	private String playerName = null;
	private int score = 1;

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
