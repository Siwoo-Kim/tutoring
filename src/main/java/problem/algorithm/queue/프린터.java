package problem.algorithm.queue;

import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/42587
 */
public class 프린터 {

    public static void main(String[] args) {
        int[] priorities = {2, 1, 3, 2};
        Solution solution = new Solution();
        int x = solution.solution(priorities, 2);
        System.out.println(x);
        priorities = new int[]{1, 1, 9, 1, 1, 1};
        x = solution.solution(priorities, 0);
        System.out.println(x);
    }
    
    static class Solution {
        private static class Element {
            private int p, i;

            public Element(int p, int i) {
                this.p = p;
                this.i = i;
            }
        }
        
        public int solution(int[] priorities, int location) {
            int N = priorities.length;
            Queue<Element> q = new LinkedList<>();
            for (int i=0; i<N; i++)
                q.add(new Element(priorities[i], i));
            int cnt = 1;
            while (!q.isEmpty()) {
                boolean canAdd = true;
                Element v = q.poll();
                for (Element w: q) {
                    if (v.p < w.p) {
                        canAdd = false;
                        break;
                    }
                }
                if (canAdd && v.i == location)
                    return cnt;
                if (canAdd)
                    cnt++;
                else
                    q.add(v);
            }
            throw new IllegalArgumentException();
        }
    }
}
