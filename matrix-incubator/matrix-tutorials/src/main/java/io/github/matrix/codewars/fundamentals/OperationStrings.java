package io.github.matrix.codewars.fundamentals;

import java.util.function.Function;

/**
 * @author Noa Swartz
 * @date 2020/12/13
 */
public class OperationStrings {


    /**
     * Moves in squared strings (II)
     *
     * @param str
     * @return
     */
    public static String rot(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    public static String selfieAndRot(String str) {
        String dots = ".".repeat(Math.max(0, str.indexOf("\n")));
        return str.replace("\n", dots + "\n") + dots  + "\n" + dots + rot(str).replace("\n","\n" + dots);
    }

    public static String operation(Function<String, String> function, String s) {
        return function.apply(s);
    }

}
