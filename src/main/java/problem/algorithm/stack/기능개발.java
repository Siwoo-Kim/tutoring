package problem.algorithm.stack;

import java.util.*;

public class 기능개발 {

    public static void main(String[] args) {
        int[] pg = {93, 90, 55},
                sp = {1, 30, 5};
        Solution solution = new Solution();
        int[] r = solution.solution(pg, sp);
        System.out.println(Arrays.toString(r));
        pg = new int[]{95, 90, 99, 99, 80, 99};
        sp = new int[]{1, 1, 1, 1, 1, 1};
        r = solution.solution(pg, sp);
        System.out.println(Arrays.toString(r));
    }
    
    static class Solution {
        private int[] pg, sp;
        
        public int[] solution(int[] pg, int[] sp) {
            this.pg = pg;
            this.sp = sp;
            int N = pg.length;
            Map<Integer, Integer> map = new HashMap<>();
            Stack<Integer> stack = new Stack<>();
            for (int i=0; i<N; i++) {
                if (stack.isEmpty()) {
                    stack.push(i);
                    map.put(i, 1);
                } else if (calc(stack.peek()) >= calc(i))
                    map.put(stack.peek(), map.get(stack.peek()) + 1);
                else {
                    stack.pop();
                    stack.push(i);
                    map.put(i, 1);
                }
            }
            return map.keySet().stream()
                    .sorted()
                    .map(map::get)
                    .mapToInt(v -> v)
                    .toArray();
        }

        private int calc(int i) {
            return (int) Math.ceil ((100 - pg[i]) / (double) sp[i]);
        }
    }
}
