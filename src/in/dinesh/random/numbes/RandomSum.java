package in.dinesh.random.numbes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RandomSum {

	public static void main(String[] args) {
		randomNumbersSum(100, 5);
	}

	/**
	 * Random numbers sum
	 * 
	 * @param targetSum
	 * @param numberOfDraws
	 */
	public static void randomNumbersSum(int targetSum, int numberOfDraws) {
		Random r = new Random();

		List<Integer> load = new ArrayList<>();

		// random numbers
		int sum = 0;
		for (int i = 0; i < numberOfDraws; i++) {
			int next = r.nextInt(targetSum) + 1;
			load.add(next);
			sum += next;
		}

		// scale to the desired target sum
		double scale = 1d * targetSum / sum;
		sum = 0;
		for (int i = 0; i < numberOfDraws; i++) {
			load.set(i, (int) (load.get(i) * scale));
			sum += load.get(i);
		}

		// take rounding issues into account
		while (sum++ < targetSum) {
			int i = r.nextInt(numberOfDraws);
			load.set(i, load.get(i) + 1);
		}

		System.out.println("Random arraylist " + load);
		System.out.println("Sum is " + (sum - 1));
	}

}
