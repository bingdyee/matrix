package io.matrix.agent;

import java.lang.instrument.Instrumentation;

/**
 * java Instrumentation API
 *
 *
 * @author Noa Swartz
 * @date 2020/09/15
 */
public class MatrixAgent {

    /**
     * JVM启动时加载
     *
     * @param agentArgs
     * @param inst
     */
    public static void premain(String agentArgs, Instrumentation inst) {
        System.err.println("[premain]: Hello, Java Agent.");
    }

    /**
     * JVM运行时加载
     *
     * @param agentArgs
     * @param inst
     */
    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.err.println("[agentmain]: Hai, Java Agent.");
    }

}
