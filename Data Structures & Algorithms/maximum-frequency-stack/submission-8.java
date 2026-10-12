class FreqStack {

    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> groupMap;
    int maxFreq;

    public FreqStack() {
        this.freqMap = new HashMap<>();
        this.groupMap = new HashMap<>();
        this.maxFreq = 0;
    }
    
    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) + 1;
        freqMap.put(val, freq);
        if (freq > maxFreq) {
            maxFreq = freq;
            groupMap.putIfAbsent(freq, new Stack<>());
        }
        groupMap.get(freq).push(val);
    }
    
    public int pop() {
        int res = groupMap.get(maxFreq).pop();
        freqMap.put(res, freqMap.get(res) - 1);
        if (groupMap.get(maxFreq).isEmpty()) maxFreq--;
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */