/**
 * 
 */
package dev.atanu.ds.java.dp.knapsack;

/**
 * https://leetcode.com/problems/closest-subsequence-sum/
 * 
 * @author Atanu Bhowmick
 *
 */
public class ClosestSubsetSumSolution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4, 7 };
		ClosestSubsetSumSolution solution = new ClosestSubsetSumSolution();
		System.out.println(solution.minAbsDifference(nums, 10));
	}

	public int minAbsDifference(int[] nums, int goal) {
		return 0;
	}
}
