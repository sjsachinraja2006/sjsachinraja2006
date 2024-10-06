1 Implementation OF DEQUE
  CODING :
  
class Solution {

    public boolean areSentencesSimilar(String s1, String s2) {
        Deque<String> deque1 = new ArrayDeque<>(Arrays.asList(s1.split(" ")));
        Deque<String> deque2 = new ArrayDeque<>(Arrays.asList(s2.split(" ")));
        //Compare the prefixes or beginning of the strings.
        while (
            !deque1.isEmpty() &&
            !deque2.isEmpty() &&
            deque1.peek().equals(deque2.peek())
        ) {
            deque1.poll();
            deque2.poll();
        }
        // Compare the suffixes or ending of the strings.
        while (
            !deque1.isEmpty() &&
            !deque2.isEmpty() &&
            deque1.peekLast().equals(deque2.peekLast())
        ) {
            deque1.pollLast();
            deque2.pollLast();
        }
        return deque1.isEmpty() || deque2.isEmpty();
    }
}

2 Implementation OF TWO POINTER
CODING:

class Solution {

    public boolean areSentencesSimilar(String s1, String s2) {
        String[] s1Words = s1.split(" "), s2Words = s2.split(" ");
        int start = 0, ends1 = s1Words.length - 1, ends2 =
            s2Words.length - 1, s1WordsLength = s1Words.length, s2WordsLength =
            s2Words.length;
        if (s1WordsLength > s2WordsLength) {
            return areSentencesSimilar(s2, s1);
        }
        while (start < s1WordsLength && s1Words[start].equals(s2Words[start])) {
            ++start;
        }
        while (ends1 >= 0 && s1Words[ends1].equals(s2Words[ends2])) {
            --ends1;
            --ends2;
        }
        return ends1 < start;
    }
}

3 https://leetcode.com/problems/count-nice-pairs-in-an-array/

import java.util.HashMap;

public class NicePairsCounter {
    private static final int MOD = 1000000007;
    private static int rev(int x) {
        int reversed = 0;
        while (x > 0) {
            reversed = reversed * 10 + x % 10;
            x /= 10;
        }
        return reversed;
    }

    public static int countNicePairs(int[] nums) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        long nicePairCount = 0;
        for (int num : nums) {
            int value = num - rev(num);
            countMap.put(value, countMap.getOrDefault(value, 0) + 1);
        }
        for (int count : countMap.values()) {
            if (count > 1) {
                nicePairCount = (nicePairCount + (long) count * (count - 1) / 2) % MOD;
            }
        }

        return (int) nicePairCount;
    }
    public static void main(String[] args) {
        int[] nums = {123, 321, 120, 210};
        System.out.println(countNicePairs(nums)); 
    }
}

















