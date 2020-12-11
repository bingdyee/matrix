package io.github.matrix.codewars.others;

import java.util.Arrays;

/**
 *
 * KMP Substring Search
 *
 * @author Noa Swartz
 * @date 2020/12/11
 */
public class SubStringSearch {

    private static int[] next(String dest) {
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); ++i) {
            j = search(dest, dest, next, i, j);
            next[i] = j;
        }
        return next;
    }

    private static int search(String text, String pattern, int[] next, int i, int j) {
        while(j > 0 && text.charAt(i) != pattern.charAt(j)){
            j = next[j - 1];
        }
        if(text.charAt(i) == pattern.charAt(j)){
            ++j;
        }
        return j;
    }

    public static int KMP(String text, String pattern) {
        int[] next = next(pattern);
        System.err.println("NEXT Array: " + Arrays.toString(next));
        for(int i = 0, j = 0; i < text.length(); ++i){
            j = search(text, pattern, next, i, j);
            if(j == pattern.length()){
                return i - j + 1;
            }
        }
        return -1;
    }

}
