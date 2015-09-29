package com.aryasindhu.games.snl.core.constants;

/**
 * 
 * @author aryasindhusahu@gmail.com
 *
 */
public enum ActionType {

	SNAKE(1),

	LADDER(2);

	private final int type;

	ActionType(int type) {
		this.type = type;
	}

	public int getType() {
		return type;
	}
	
}
