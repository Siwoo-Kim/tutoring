package problem.algorithm.stack;

import java.util.Arrays;
import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 */
public class 주식가격 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] a = {1, 2, 3, 2, 3};
        System.out.println(Arrays.toString(solution.solution(a)));
        a = new int[]{1, 2, 5, 4, 2, 3, 4};
        System.out.println(Arrays.toString(solution.solution(a)));
    }
    
    static class Solution {
        public int[] solution(int[] prices) {
            Stack<Integer> stack = new Stack<>();
            int[] answer = new int[prices.length];
            for (int i = 0; i < prices.length; i++) {
                while (!stack.isEmpty() &&
                        prices[stack.peek()] > prices[i])
                    answer[stack.peek()] = i - stack.pop();
                stack.push(i);
            }
            while (!stack.isEmpty()) {
                int p = stack.pop();
                answer[p] = prices.length - 1 - p;
            }
            answer[prices.length - 1] = 0;
            return answer;
        }
    }
}
