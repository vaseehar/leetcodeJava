package solutions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring3 {

	public static void main(String[] args) {
		// wxyzxabcde - 8
		// aaaaaaaaaa - 1
		// ababababab - 2
		System.out.println(lengthOfLongestSubstring("ababababab"));
	}

	//my naive solution
	public static int lengthOfLongestSubstring(String s) {
		Map<Character, Integer> charMap = new HashMap<>();
		int count = 0;
		int currMax = 0;
		for (int i = 0; i < s.length(); i++) {
			if (!charMap.containsKey(s.charAt(i))) {
				charMap.put(s.charAt(i), i);
				count++;
			} else {
				if (count > currMax) {
					currMax = count;
				}
				i = charMap.get(s.charAt(i));
				charMap.clear();
				count = 0;
			}
			if (currMax < count) {
				currMax = count;
			}
		}
		return currMax;

	}
}
