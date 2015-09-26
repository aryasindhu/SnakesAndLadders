package com.aryasindhu.games.snl.core.bo;

import com.aryasindhu.games.snl.core.constants.ActionType;

public abstract class Action {

	private int targetScore;

	public int getTargetScore() {
		return targetScore;
	}

	public void setTargetScore(int targetScore) {
		this.targetScore = targetScore;
	}

	public abstract ActionType getActionType();

	public void performAction(Player player) {
		player.setScore(this.targetScore);
	}

}
