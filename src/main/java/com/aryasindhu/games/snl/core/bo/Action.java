package com.aryasindhu.games.snl.core.bo;

import com.aryasindhu.games.snl.core.constants.ActionType;

/**
 * 
 * @author aryasindhusahu@gmail.com
 * 
 */
public abstract class Action {

	private int sourceScore;
	private int targetScore;

	public abstract ActionType getActionType();

	public Action(int sourceScore, int targetScore) {
		setSourceScore(sourceScore);
		setTargetScore(targetScore);
	}

	public int getSourceScore() {
		return sourceScore;
	}

	public void setSourceScore(int sourceScore) {
		this.sourceScore = sourceScore;
	}

	public int getTargetScore() {
		return targetScore;
	}

	public void setTargetScore(int targetScore) {
		this.targetScore = targetScore;
	}

	public void performAction(Player player) {
		System.out.print("Action Performed : OLD["+player.getScore()+"]");
		player.setScore(this.targetScore);
		System.out.print(" NEW[" + player.getScore() + "]");
	}

}
