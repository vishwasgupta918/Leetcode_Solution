class Solution {
    public int[] getConcatenation(int[] nums) {
        int[] merged = new int[nums.length + nums.length];

        int index = 0;
        for (int item : nums) {
            merged[index++] = item;
        }
        for (int item : nums) {
            merged[index++] = item;
        }
        return merged;
    }
}