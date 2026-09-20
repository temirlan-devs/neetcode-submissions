class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Integer> maps = new HashMap<>();
        Map<Character, Integer> mapt = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            maps.put(s.charAt(i), maps.getOrDefault(s.charAt(i), 0) + 1);
            mapt.put(t.charAt(i), mapt.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (char c : t.toCharArray()) {
            if (!(maps.containsKey(c) && maps.get(c).equals(mapt.get(c)))) return false;
        }

        return true;
    }
}

/*
Time, space complexity: O(n)

Test

Case 1:
car
rac

maps: c->1, a->1, r->1
mapt: r->1, a->1, c->1

return true

Case 2:
car
rae

maps: c->1, a->1, r->1
mapt: r->1, a->1, e->1

maps doesn't contain e -> return false

Case 3:
car
ract
return false





*/