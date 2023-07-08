/**
 * 
 */
package dev.atanu.ds.java.dp.lcs;

/**
 * https://www.geeksforgeeks.org/minimum-number-deletions-insertions-transform-one-string-another/
 * 
 * @author Atanu Bhowmick
 *
 */
public class InsertDeleteIdenticalString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		InsertDeleteIdenticalString identicalString = new InsertDeleteIdenticalString();
		System.out.println(identicalString.minInsertDeleteIdenticalString("heap", "pea"));
	}

	/**
	 * 
	 * @param text1
	 * @param text2
	 * @return
	 */
	public int minInsertDeleteIdenticalString(String text1, String text2) {
		LongestCommonSubsequence lcs = new LongestCommonSubsequence();
		int lcsLen = lcs.lcsBottomUp(text1, text2);
		return (text1.length() - lcsLen) + (text2.length() - lcsLen);
	}
}
