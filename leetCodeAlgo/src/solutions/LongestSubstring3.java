package solutions;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring3 {

	public static void main(String[] args) {
		// wxyzxabcde - 8
		// aaaaaaaaaa - 1
		// ababababab - 2
		System.out.println(lengthOfLongestSubstringSlidingWindow("wxyzxabcde"));
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
	
	
	 public static int lengthOfLongestSubstringSlidingWindow(String s) {
	        int[] chars = new int[128];

	        int left = 0;
	        int right = 0;

	        int res = 0;
	        while (right < s.length()) {
	            char r = s.charAt(right);
	            chars[r]++;

	            while (chars[r] > 1) {
	                char l = s.charAt(left);
	                chars[l]--;
	                left++;
	            }

	            res = Math.max(res, right - left + 1);

	            right++;
	        }
	        return res;
	    }
}
