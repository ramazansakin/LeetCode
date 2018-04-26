import java.util.HashMap;
import java.util.Map;

public class LeetCode_LongestSubstring {
	public static int lengthOfLongestSubstring(String s) {

		if (s == null || s.isEmpty()) {
			return 0;
		}

		int maxLen = -1, first = 0, last = 0;
		Map<Character, Integer> m = new HashMap<Character, Integer>();

		for (int i = 0; i < s.length(); i++) {
			if (m.containsKey(s.charAt(i))) {
				Integer value = m.get(s.charAt(i));
				m.clear();
				if (maxLen < (last - first)) {
					maxLen = last - first;
				}
				first = value + 1;
				i = first - 1;
			} else {
				m.put(s.charAt(i), i);
				last = i;
			}
		}

		if (maxLen < (last - first)) {
			maxLen = last - first;
		}

		return maxLen + 1;
	}
}
