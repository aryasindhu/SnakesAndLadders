package com.aryasindhu.games.snl.core.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import com.aryasindhu.games.snl.core.bo.Action;
import com.aryasindhu.games.snl.core.bo.LadderAction;
import com.aryasindhu.games.snl.core.bo.SnakeAction;

/**
 * 
 * @author aryasindhusahu@gmail.com
 * 
 */
public class GameUtil {

	private static Random randomDiceValObj = new Random();

	public static Set<Action> generateSnakesAndLadders() {
		Set<Action> allActions = null;
		// generate random actions

		int snakeCount = new Random().nextInt(10) + 1;
		int ladderCount = new Random().nextInt(10) + 1;

		allActions = new HashSet<Action>(snakeCount + ladderCount);

		Set<Integer> allActionNos = generateRandomActionNumbers(2 * (snakeCount + ladderCount));
		Map<Integer, Integer> actionNoPairs = createActionNoPairs(allActionNos);

		List<Integer> actionsKeyList = new ArrayList<Integer>(
				actionNoPairs.size());
		for (Integer key : actionNoPairs.keySet()) {
			actionsKeyList.add(key);
		}

		SnakeAction snakeAction = null;
		for (int index = 0; index < snakeCount; index++) {
			int sourceScore = actionsKeyList.get(index);
			int targetScore = actionNoPairs.get(sourceScore);
			snakeAction = new SnakeAction(targetScore, sourceScore);
			allActions.add(snakeAction);
		}

		LadderAction ladderAction = null;
		for (int index = 0; index < ladderCount; index++) {
			int sourceScore = actionsKeyList.get(index + snakeCount);
			int targetScore = actionNoPairs.get(sourceScore);
			ladderAction = new LadderAction(sourceScore, targetScore);
			allActions.add(ladderAction);
		}

		return allActions;
	}

	public static int rollDice() {
		// generate random dice value
		return randomDiceValObj.nextInt(6) + 1;
	}

	private static Set<Integer> generateRandomActionNumbers(int quantity) {
		Set<Integer> randomActionNos = new HashSet<Integer>();
		// generate unique nos
		Random randomObj = new Random();
		for (int index = 0; index < quantity; index++) {
			Integer randomActionNo = randomObj.nextInt(99 - 2) + 2;
			while (randomActionNos.contains(randomActionNo)) {
				randomActionNo = randomObj.nextInt(99 - 2) + 2;
			}
			randomActionNos.add(randomActionNo);
		}
		return randomActionNos;
	}

	/**
	 * returns a pair of actionNo : actionNo in a Map
	 * 
	 * @param allActionNos
	 * @return Map<Integer, Integer>
	 */
	private static Map<Integer, Integer> createActionNoPairs(
			Set<Integer> allActionNos) {
		int totalActionSets = allActionNos.size() / 2;
		Map<Integer, Integer> pairs = new HashMap<Integer, Integer>(
				totalActionSets);
		Object[] actionNosObj = allActionNos.toArray();
		Arrays.sort(actionNosObj);
		for (int index = 0; index < totalActionSets; index++) {
			pairs.put(Integer.parseInt(actionNosObj[index].toString()), Integer
					.parseInt(actionNosObj[index + totalActionSets].toString()));
		}
		return pairs;
	}

}
