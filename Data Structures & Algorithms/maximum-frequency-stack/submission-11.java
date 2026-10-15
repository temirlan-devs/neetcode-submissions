class FreqStack {

    Map<Integer, Integer> freqMap;
    Map<Integer, Stack<Integer>> groupMap;
    int maxFreq;

    public FreqStack() {
        this.freqMap = new HashMap<>();
        this.groupMap = new HashMap<>();
        this.maxFreq = 0;
    }
    
    // O(1)
    public void push(int val) {
        int freq = freqMap.getOrDefault(val, 0) + 1; // O(1)
        freqMap.put(val, freq); // O(1)
        if (freq > maxFreq) {
            maxFreq = freq;
            groupMap.putIfAbsent(freq, new Stack<>()); // O(1)
        }
        groupMap.get(freq).push(val); // O(1)
    }
    
    // O(1)
    public int pop() {
        int res = groupMap.get(maxFreq).pop(); // O(1)
        freqMap.put(res, freqMap.get(res) - 1); // O(1)
        if (groupMap.get(maxFreq).isEmpty()) maxFreq--; // O(1)
        return res;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */

 /*
 
 Time complexity: O(1) - push/pop operation

 Space complexity: O(n), where n is the number of numbers pushed
freqMap can go up to n entries if each number is unique
groupMap stores less than n entries, however values of all entries (values are stacks) store n numbers in total
 
 */

 /*

Test:

push(1)
freq = 1
freqMap: 1: 1
if 1 > 0
maxFreq = 1
groupMap: 1: [1]

push(2)
freq = 1
freqMap: 1: 1, 2: 1
groupMap: 1: [1, 2]

push(3)
freq = 1
freqMap: 1: 1, 2: 1, 3: 1
groupMap: 1: [1, 2, 3]

pop()
res = 3; groupMap: 1: [1, 2]
freqMap: 1: 1, 2: 1, 3: 0
return 3

pop()
res = 2; groupMap: 1: [1]
freqMap: 1: 1, 2: 0, 3: 0
return 2

pop()
res = 1; groupMap: 1: []
freqMap: 1: 0, 2: 0, 3: 0
maxFreq -> 0
return 1

push(4)
freq = 1
freqMap: 4: 1
if 1 > 0
maxFreq = 1
groupMap: 1: [4]

push(5)
freq = 1
freqMap: 4: 1, 5: 1
groupMap: 1: [4, 5]

push(4)
freq = 2
freqMap: 4: 2, 5: 1
if 2 > 1
maxFreq = 2
groupMap: 1: [4, 5], 2: [4]

pop()
int res = 4; groupMap: 1: [4, 5], 2: []
freqMap: 4: 1, 5: 1
maxFreq -> 1
return 4

push(4)
freq = 2
freqMap: 4: 2, 5: 1
if 2 > 1
maxFreq = 2
groupMap: 1: [4, 5], 2: [4]

push(5)
freq = 2
freqMap: 4: 2, 5: 2
groupMap: 1: [4, 5], 2: [4, 5]

pop()
res = 5;  groupMap: 1: [4, 5], 2: [4]
freqMap: 4: 2, 5: 1
return 5

push(5)
freq = 2
freqMap: 4: 2, 5: 2
groupMap: 1: [4, 5], 2: [4, 5]

push(9)
freq = 1
freqMap: 4: 2, 5: 2, 9: 1
groupMap: 1: [4, 5, 9], 2: [4, 5]

pop()
res = 5; groupMap: 1: [4, 5, 9], 2: [4]
freqMap: 4: 2, 5: 1, 9: 1
return 5

pop()
res = 4; groupMap: 1: [4, 5, 9], 2: []
freqMap: 4: 1, 5: 1, 9: 1
maxFreq -> 1

pop()
res = 9; groupMap: 1: [4, 5], 2: []
freqMap: 4: 1, 5: 1, 9: 0
return 9

pop()
res = 5; groupMap: 1: [4], 2: []
freqMap: 4: 1, 5: 0, 9: 0
return 5

pop()
res = 4; groupMap: 1: [], 2: []
freqMap: 4: 0, 5: 0, 9: 0
maxFreq -> 0
return 4


*/