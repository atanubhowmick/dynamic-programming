/**
 * 
 */
package dev.atanu.ds.java.dp.knapsack;

/**
 * https://leetcode.com/problems/partition-array-into-two-arrays-to-minimize-sum-difference/submissions/
 * 
 * @author Atanu Bhowmick
 *
 */
public class MinimumDiffSubsetsSumSolution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 4, 7 };
		MinimumDiffSubsetsSumSolution solution = new MinimumDiffSubsetsSumSolution();
		System.out.println(solution.minimumDifference(nums));
	}

	/**
	 * Not working for negative input
	 * 
	 * @param nums
	 * @return
	 */
	public int minimumDifference(int[] nums) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		return minDiffSubsetSum(nums, sum, nums.length);
	}

	private int minDiffSubsetSum(int[] nums, int sum, int n) {
		int halfSum = sum / 2;
		boolean[][] dp = new boolean[n + 1][halfSum + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= halfSum; j++) {
				if (j == 0) {
					dp[i][j] = true;
				} else if (i == 0) {
					dp[i][j] = false;
				} else if (nums[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}

		int diff = sum;
		for (int j = halfSum; j >= 0; j--) {
			if (dp[n][j]) {
				diff = sum - 2 * j;
				break;
			}
		}
		return diff;
	}

}
