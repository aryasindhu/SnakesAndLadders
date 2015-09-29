package com.aryasindhu.games.snl.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import com.aryasindhu.games.snl.core.bo.Action;
import com.aryasindhu.games.snl.core.bo.LadderAction;
import com.aryasindhu.games.snl.core.bo.SnakeAction;

public class GameUtil {

	private static Random randomDiceValObj = new Random();
	
	public static List<Action> generateSnakesAndLadders() {
		List<Action> allActions = null;
		//generate random actions
		
		int snakeCount = new Random().nextInt(10) + 1;
		int ladderCount = new Random().nextInt(10) + 1;
		
		allActions = new ArrayList<Action>(snakeCount + ladderCount);
		
		for(int index=0; index<snakeCount; index++) {
			allActions.add(new SnakeAction());
		}

		for(int index=0; index<ladderCount; index++) {
			allActions.add(new LadderAction());
		}
		
		return allActions;
	}

	public static int rollDice() {
		//generate random dice value
		return randomDiceValObj.nextInt(6 - 1) + 1;
	}

	private static Set<Integer> generateRandomActionNumbers(int quantity) {
		Set<Integer> randomActionNos = new HashSet<Integer>();
		//generate unique nos
		Random randomObj = new Random();
		for(int index=0; index<quantity; index++) {
			Integer randomActionNo = randomObj.nextInt(99 - 2) + 2;
			while(randomActionNos.contains(randomActionNo)) {
				randomActionNo = randomObj.nextInt(99 - 2) + 2;
			}
			randomActionNos.add(randomActionNo);
		}
		return randomActionNos;
	}

}
