package problem.algorithm;

import java.util.*;

public class 다리를지나는트럭 {

    public static void main(String[] args) {
        int length = 2, weight = 10;
        int[] trucks = {7, 4, 5, 6};
        Solution solution = new Solution();
        int x = solution.solution(length, weight, trucks);
        System.out.println(x);
    }

    static class Solution {
        public int solution(int L, int W, int[] T) {
            int k = 0, time = 0, current = 0;
            Queue<Integer> q = new LinkedList<>();
            for (int i=0; i<T.length; i++) {
                if (q.isEmpty()) {  // enter
                    q.add(T[i]);
                    current += T[i];
                    time++;
                } else {
                    while (true) {
                        if (q.size() == L) {    // bridge is full
                            current -= q.poll();
                        } else {
                            if (current + T[i] > W) {   // no capacity on bridge
                                time++;
                                q.add(0);   // dummy
                            } else {
                                q.add(T[i]);    // add truck on bridge
                                current += T[i];
                                time++;
                                break;
                            }
                        }
                    }
                }
            }
            return time + L;
        }
    }
}
