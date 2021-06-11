package solutions;

import java.util.HashMap;
import java.util.Map;

public class TwoSums1 {

	// My naive method O(n^2)
	public static int[] twoSum(int[] nums, int target) {
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {

					return new int[] { i, j };
				}
			}
		}
		return null;
	}

	//leetcode solution O(n)
	public static int[] twoSumHashMap(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}
		return null;
	}

	public static void main(String args[]) {
		int[] arr = new int[1000];
		for (int i = 0; i < 998; i++) {
			arr[i] = i;
		}
		arr[999] = 10000;
		long start = System.currentTimeMillis();
		int[] result = twoSumHashMap(arr, 10998);
		System.out.println("" + start + " " + System.currentTimeMillis());

	}
}
