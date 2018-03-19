
public class LongestPalindromeSubstring {
	/*
	 * 求解字符串的最长回文子串
	 * 思路一：中心扩展法
	 * 注意考虑奇偶两种情况即可
	 * 时间复杂度O(n^2)，空间复杂度O(1)
	 */
	public static String longestPalindrome1(String s) {
		int len = s.length();
		if (s == null || len <= 1)
			return s;
		int start = 0;
		int longestLen = 0;
		// 当回文串的长度为奇数时
		for (int i = 1; i < s.length(); i++) {
			int j = i - 1, k = i + 1;
			while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
				if (longestLen < k - j + 1) {
					longestLen = k - j + 1;
					start = j;// 记录下最长子回文串的起始点
				}
				j--;
				k++;
			}
		}
		// 当回文串的长度为偶数时
		for (int i = 0; i < s.length(); i++) {
			int j = i, k = i + 1;
			while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
				if (longestLen < k - j + 1) {
					longestLen = k - j + 1;
					start = j;// 记录下最长子回文串的起始点
				}
				j--;
				k++;
			}
		}
		System.out.println(start + " " + longestLen);
        if (start == 0 && longestLen == 0)
			return s.charAt(0) + "";// 如果没有回文子串，则返回第一个字符
		return s.substring(start, start + longestLen);// 截取[start,end-1]
	}

	/*
	 * 思路二：DP
	 * P[i][j]是记录i到j的子串是不是回文串
	 * P(i,j)={true,if the substring Si…Sj is a palindrome;false,
	 * if the substring Si…Sj is not a palindrome}
	 * 那么可以得到：P(i,j)=(P(i+1,j−1) && Si==Sj)
	 * 时间复杂度O(n^2)，空间复杂度O(n^2)
	 */
	public static String longestPalindrome2(String s) {
		int len = s.length();
		if (s == null || len <= 1)
			return s;
		boolean dp[][] = new boolean[len][len];
		int maxLen = 0, start = 0, end = 0;
		for(int i = 0; i < len; i++){
			for(int j = 0; j < i; j++){
				if(s.charAt(i) == s.charAt(j) && (i - j <= 2 || dp[j + 1][i - 1])){
					dp[j][i] = true;
					if(i - j + 1 > maxLen){
						maxLen = i - j + 1;
						start = j;
						end = i;
					}
				}
			}
		}
		if (start == end)
			return s.charAt(0) + "";// 如果没有回文子串，则返回第一个字符
		return s.substring(start, end + 1);// 截取[start,end-1]
	}
	
	/*
	 * 思路三：Manacher算法
	 * 时间复杂度O(n)，空间复杂度O(n)
	 * 由于时间关系，先不学了！！
	 */
	public static void main(String[] args) {
		String src = "EABCDCBA";
		System.out.println(longestPalindrome1(src));
		System.out.println(longestPalindrome2(src));
	}
}
