class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            // Prevents integer overflow compared to (left + right) / 2
            int mid = left + (right - left) / 2; 
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        // If not found, 'left' points to the correct insertion index
        return left;
    }
}