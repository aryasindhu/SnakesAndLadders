package com.aryasindhu.games.snl.core.bo;

import com.aryasindhu.games.snl.core.constants.ActionType;

/**
 * 
 * @author aryasindhusahu@gmail.com
 *
 */
public class LadderAction extends Action {

	@Override
	public ActionType getActionType() {
		return ActionType.LADDER;
	}

	@Override
	public void performAction(Player player) {
		super.performAction(player);
		System.out.println("Player :" + player.getPlayerName() + " UP => " + player.getScore());
	}
}
