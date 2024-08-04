package review;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public String decodeString(String s) {
        char[] sToChar = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        Deque<Character> stk = new ArrayDeque<>();
        for (Character i : sToChar) {
            if (i == ']') {
                List<Character> tmp = new ArrayList<>();
                while (!stk.isEmpty() && stk.peek() != '[') {
                    tmp.add(stk.pop());
                }
                stk.pop();
                int count = 0;
                int carry = 1;
                while (!stk.isEmpty() && stk.peek() <= '9' && stk.peek() >= '0') {
                    count += carry * (stk.pop() - '0');
                    carry *= 10;
                }
                while (count > 0) {
                    for (int j = tmp.size(); j > 0; j--) {
                        stk.push(tmp.get(j - 1));
                    }
                    count--;
                }
            } else {
                stk.push(i);
            }
        }
        while (!stk.isEmpty()) {
            sb.append(stk.pop());
        }
        return sb.reverse().toString();
    }
}
