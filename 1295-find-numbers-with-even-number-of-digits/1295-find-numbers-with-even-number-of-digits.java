class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        
        for (int num : nums) {
            // Math.log10(num) + 1 gives the exact number of digits
            int digits = (int) Math.log10(num) + 1;
            
            if (digits % 2 == 0) {
                count++;
            }
        }
        
        return count;
    }
}