package com.aryasindhu.games.snl.core.constants;

public enum GameStatus {

	READY(1),

	IN_PROGRESS(2),

	PARTIALLY_COMPLETE(3),

	COMPLETE(4);

	private final int status;

	private GameStatus(int status) {
		this.status = status;
	}

	public int getStatus() {
		return status;
	}

}
