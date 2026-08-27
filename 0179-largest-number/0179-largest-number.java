import java.util.Arrays;

class Solution {
    public String largestNumber(int[] nums) {
        String[] strNums = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strNums[i] = String.valueOf(nums[i]);
        }

        // Custom comparator: compare (b + a) with (a + b) for descending order
        Arrays.sort(strNums, (a, b) -> (b + a).compareTo(a + b));

        // Edge case: if the highest value number is "0", the entire result is "0"
        if (strNums[0].equals("0")) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        for (String s : strNums) {
            sb.append(s);
        }

        return sb.toString();
    }
}