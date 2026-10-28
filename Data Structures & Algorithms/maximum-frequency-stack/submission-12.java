class FreqStack {

    Map<Integer, Integer> countMap;
    Map<Integer, Stack<Integer>> freqMap;
    int maxFreq;

    public FreqStack() {
        this.countMap = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.maxFreq = 0;
    }
    
    public void push(int val) {
        
        int freq = countMap.getOrDefault(val, 0) + 1;
        countMap.put(val, freq);
        if (freq > maxFreq) {
            maxFreq = freq;
            freqMap.put(freq, new Stack<>());
        }
        freqMap.get(freq).push(val);

    }
    
    public int pop() {
        
        int res = freqMap.get(maxFreq).pop();
        countMap.put(res, countMap.get(res) - 1);
        if (freqMap.get(maxFreq).isEmpty()) maxFreq--;
        return res;

    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */