/**
 * 
 */
package dev.atanu.ds.java.dp.lcs;

/**
 * https://leetcode.com/problems/shortest-common-supersequence
 * 
 * @author Atanu Bhowmick
 *
 */
public class ShortestCommonSupersequencePrinter {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ShortestCommonSupersequencePrinter scs = new ShortestCommonSupersequencePrinter();
		String text1 = "acdk";
		String text2 = "abced";
		System.out.println(scs.sscPrint(text1, text2));
	}

	/**
	 * 
	 * @param text1
	 * @param text2
	 * @return
	 */
	public String sscPrint(String text1, String text2) {
		LongestCommonSubsequencePrinter lcsPrinter = new LongestCommonSubsequencePrinter();
		String lcs = lcsPrinter.lcsPrintBottomUp(text1, text2);

		int i = 0, j = 0, k = 0;
		int m = text1.length();
		int n = text2.length();
		int len = lcs.length();

		StringBuffer sb = new StringBuffer();

		while (i < m && j < n) {
			char ch1 = text1.charAt(i);
			char ch2 = text2.charAt(j);
			if (k >= len) {
				sb.append(ch1);
				sb.append(ch2);
				i++;
				j++;
			} else if (lcs.charAt(k) == ch1 && lcs.charAt(k) == ch2) {
				sb.append(lcs.charAt(k));
				i++;
				j++;
				k++;
			} else if (lcs.charAt(k) != ch1 && lcs.charAt(k) == ch2) {
				sb.append(ch1);
				i++;
			} else {
				sb.append(ch2);
				j++;
			}
		}
		
		while (i < m) {
			sb.append(text1.charAt(i++));
		}
		
		while (j < n) {
			sb.append(text2.charAt(j++));
		}
		
		return sb.toString();
	}
}
