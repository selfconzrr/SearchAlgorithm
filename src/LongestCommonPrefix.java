import java.util.Arrays;

public class LongestCommonPrefix {

	/*
	 * 思路一：
	 * 既然是公共前缀，所以第一个子串中定有，所以假设第一个字符串为前缀，然后依次和后面的字符串进行比较即可
	 * 时间复杂度O(mn)，空间复杂度O(1)
	 */
	public static String longestCommonPrefix(String[] strs) {
		if(strs == null)
			return null;
		if(strs.length == 0)
			return "";
		String word = strs[0];
		int prefixLen = word.length();
		for(int i = 1; i < strs.length; i++){
			String nextWord = strs[i];
			prefixLen = Math.min(prefixLen, nextWord.length());
			for(int j = 0; j < prefixLen; j++){
				if(word.charAt(j) != nextWord.charAt(j)){
					prefixLen = j;
					break;
				}
			}
		}
		return word.substring(0,prefixLen);
		
	}
	/*
	 * 思路二：
	 * 先将字符数组进行排序，这样我们就可以直接比较第一个和最后一个字符串，取他们的最长公共子串即可。
	 * 时间复杂度O(nlogn)，空间复杂度O(m)
	 */
	public static String longestCommonPrefix2(String[] strs) {
		if(strs == null)
			return null;
		if(strs.length == 0)
			return "";
		int len = strs.length;
		Arrays.sort(strs);
		int prefixLen = Math.min(strs[0].length(), strs[len - 1].length());
		for(int i = 0; i < prefixLen; i++){
			if(strs[0].charAt(i) != strs[len - 1].charAt(i)){
				return strs[0].substring(0,i);
			}
		}
		return strs[0].substring(0, prefixLen);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String strs[] = {"abcd","abcfg","abcdg","aba"};
		System.out.print(longestCommonPrefix2(strs));
	}

}
