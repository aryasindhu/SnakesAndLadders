package com.aryasindhu.games.snl.core.bo;

import com.aryasindhu.games.snl.core.constants.ActionType;

public class SnakeAction extends Action {

	@Override
	public ActionType getActionType() {
		return ActionType.SNAKE;
	}

	@Override
	public void performAction(Player player) {
		super.performAction(player);
		System.out.println("Player :" + player.getPlayerName() + " DOWN => " + player.getScore());
	}

}
