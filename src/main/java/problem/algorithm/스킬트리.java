package problem.algorithm;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * https://programmers.co.kr/learn/courses/30/lessons/49993
 */
public class 스킬트리 {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("./src/main/resources/스킬트리.txt");
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path.toFile())));
        String s = reader.readLine();
        String[] trees = new String[Integer.parseInt(reader.readLine())];
        for (int i=0; i<trees.length; i++)
            trees[i] = reader.readLine();
        Solution solution = new Solution();
        int x = solution.solution(s, trees);
        System.out.println(x);
    }

    static class Solution {
        public int solution(String skill, String[] trees) {
            int cnt = 0;
            for (String tree: trees) {
                Queue<Character> q = new LinkedList<>();
                for (char c: tree.toCharArray())
                    if (skill.contains(Character.toString(c)))
                        q.add(c);
                Character[] chars = q.toArray(new Character[0]);
                boolean ok = true;
                for (int i=0; i<chars.length; i++)
                    if (chars[i] != skill.charAt(i)) {
                        ok = false;
                        break;
                    }
                cnt += ok ? 1: 0;
            }
            return cnt;
        }
    }
}
