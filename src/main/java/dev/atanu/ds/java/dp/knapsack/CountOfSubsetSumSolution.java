/**
 * 
 */
package dev.atanu.ds.java.dp.knapsack;

/**
 * https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
 * 
 * @author Atanu Bhowmick
 *
 */
public class CountOfSubsetSumSolution {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 3, 3, 5 };
		CountOfSubsetSumSolution solution = new CountOfSubsetSumSolution();
		System.out.println(solution.getSubsetCount(nums, 10, nums.length));
	}

	/**
	 * 
	 * @param nums
	 * @param sum
	 * @param n
	 * @return
	 */
	public int getSubsetCount(int[] nums, int sum, int n) {
		int[][] dp = new int[n + 1][sum + 1];
		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= sum; j++) {
				if (j == 0) {
					dp[i][j] = 1;
				} else if (i == 0) {
					dp[i][j] = 0;
				} else if (nums[i - 1] <= j) {
					dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
				} else {
					dp[i][j] = dp[i - 1][j];
				}
			}
		}
		return dp[n][sum];
	}

}
