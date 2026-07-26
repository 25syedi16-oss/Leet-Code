class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        boolean[] isJewel = new boolean[128];
        for (char j : jewels.toCharArray()) {
            isJewel[j] = true;
        }
        
        int count = 0;
        for (char s : stones.toCharArray()) {
            if (isJewel[s]) {
                count++;
            }
        }
        return count;
    }
}