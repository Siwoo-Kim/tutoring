package problem.algorithm.math;

import java.util.HashMap;
import java.util.Map;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/12899
 *  나누기의 그룹화 속성과 나머지의 그룹 번호.
 *  
 */
public class 일이사나라의숫자 {

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i=1; i<=10; i++)
            System.out.println(solution.solution(i));
    }
    
    static class Solution {
        static final Map<Integer, Integer> map = new HashMap<>();
        
        static {
            map.put(0, 4);
            map.put(1, 1);
            map.put(2, 2);
        }
        
        public String solution(int n) {
            StringBuilder sb = new StringBuilder();
            while (n > 0) {
                int d = n % 3;
                sb.append(map.get(d));
                n /= 3;
                if (d == 0)
                    n--;
            }
            return sb.reverse().toString();
        }
    }
    
}
