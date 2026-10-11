class FreqStack {

    Map<Integer, Integer> countMap;
    Map<Integer, Stack<Integer>> groupsMap;
    int maxCount;

    public FreqStack() {
        this.countMap = new HashMap<>();
        this.groupsMap = new HashMap<>();
        this.maxCount = 0;
    }
    
    public void push(int val) {
        int count = countMap.getOrDefault(val, 0) + 1;
        countMap.put(val, count);
        if (count > maxCount) {
            maxCount = count;
            groupsMap.putIfAbsent(count, new Stack<>());
        }
        groupsMap.get(count).push(val);
    }
    
    public int pop() {
        int res = groupsMap.get(maxCount).pop();
        countMap.put(res, countMap.get(res) - 1);
        if (groupsMap.get(maxCount).isEmpty()) maxCount--;
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */