package problem.algorithm.stack;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Stack;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/64061
 */
public class 크레인인형뽑기 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./src/main/resources/크레인인형뽑기.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path.toFile())));
        int N = Integer.parseInt(reader.readLine());
        int[][] board = new int[N][N];
        for (int i=0; i<N; i++)
            board[i] = Arrays.stream(reader.readLine().split(","))
                    .mapToInt(Integer::parseInt)
                    .toArray();
        N = Integer.parseInt(reader.readLine());
        int[] moves = Arrays.stream(reader.readLine().split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
        Solution solution = new Solution();
        int x = solution.solution(board, moves);
        System.out.println(x);
    }
    
    static class Solution {
        private Stack<Integer>[] baskets;
        private Stack<Integer> goal = new Stack<>();
        private static int N;
        
        public int solution(int[][] board, int[] moves) {
            N = board.length;
            baskets = new Stack[N];
            for (int i=0; i<N; i++)
                baskets[i] = new Stack<>();
            for (int i=N-1; i>=0; i--) {
                for (int j=0; j<N; j++) {
                    if (board[i][j] != 0)
                        baskets[j].push(board[i][j]);
                }
            }
            int cnt = 0;
            for (int i=0; i<moves.length; i++) {
                int k = moves[i]-1;
                if (!baskets[k].isEmpty()) {
                    if (!goal.isEmpty() 
                            && goal.peek().equals(baskets[k].peek())) {
                        cnt+=2;
                        goal.pop();
                    } else {
                        goal.push(baskets[k].peek());
                    }
                    baskets[k].pop();
                }
            }
            return cnt;
        }
    }
}
