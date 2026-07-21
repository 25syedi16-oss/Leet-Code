class Solution {
    public int fib(int n) {
        // Base cases for 0 and 1
        if (n <= 1) return n;
        
        int a = 0; // Represents F(n-2)
        int b = 1; // Represents F(n-1)
        
        for (int i = 2; i <= n; i++) {
            int next = a + b;
            a = b;
            b = next;
        }
        
        return b;
    }
}