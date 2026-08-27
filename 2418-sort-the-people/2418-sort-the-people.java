import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Map<Integer, String> map = new HashMap<>();

        // Store height as key and name as value since all heights are distinct
        for (int i = 0; i < n; i++) {
            map.put(heights[i], names[i]);
        }

        // Sort heights in ascending order
        Arrays.sort(heights);

        String[] result = new String[n];
        // Populate result array in descending order of heights
        for (int i = 0; i < n; i++) {
            result[i] = map.get(heights[n - 1 - i]);
        }

        return result;
    }
}