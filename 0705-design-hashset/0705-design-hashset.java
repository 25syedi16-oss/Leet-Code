class MyHashSet {
    // Array to hold the presence of keys
    boolean[] set;

    public MyHashSet() {
        // Size is 1,000,001 to accommodate the maximum possible key (1,000,000)
        set = new boolean[1000001]; 
    }
    
    public void add(int key) {
        set[key] = true;
    }
    
    public void remove(int key) {
        set[key] = false;
    }
    
    public boolean contains(int key) {
        return set[key];
    }
}