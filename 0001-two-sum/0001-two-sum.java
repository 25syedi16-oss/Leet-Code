class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Look through every possible pair
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] {i, j}; // Return the indices as an array
                }
            }
        }
        // Return an empty array if no solution is found
        return new int[] {}; 
    }
}