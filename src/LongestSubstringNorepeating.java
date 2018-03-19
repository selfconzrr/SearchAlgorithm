import java.util.HashMap;

public class LongestSubstringNorepeating {

	public static int lengthOfLongestSubstring(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int len = s.length();
		int max = 0, leftBound = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < len; i++) {
			char c = s.charAt(i);
			int tempBound = map.containsKey(c) ? map.get(c) + 1 : 0;
			leftBound = Math.max(leftBound, tempBound);
			max = Math.max(max, i - leftBound + 1);
			map.put(c, i);
		}
		return max;
	}

	public static void main(String[] args) {
		String s = "abcabcde";
		System.out.print(lengthOfLongestSubstring(s));
	}

}
