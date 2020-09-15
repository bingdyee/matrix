package io.matrix.agent;

import io.matrix.agent.intercept.MatrixInterceptor;
import net.bytebuddy.agent.builder.AgentBuilder;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.utility.JavaModule;

import java.lang.instrument.Instrumentation;

/**
 * java Instrumentation API
 *
 *
 * @author Noa Swartz
 * @date 2020/09/15
 */
public class MatrixAgentMain {

   private static final String ATTACH_PACKAGE = "com.project.attachable";

    /**
     * JVM启动时加载
     *
     * @param agentArgs 探针配置：-javaagent:**-agent.jar=[<optional>=<value>, ...]
     * @param inst 动态改变和操作类的定义
     */
    public static void premain(String agentArgs, Instrumentation inst) {
        AgentBuilder.Transformer transformer = new AgentBuilder.Transformer() {
            public DynamicType.Builder<?> transform(DynamicType.Builder<?> builder, TypeDescription typeDescription, ClassLoader classLoader, JavaModule javaModule) {
                return builder.method(ElementMatchers.<MethodDescription>any())
                        .intercept(MethodDelegation.to(MatrixInterceptor.class));
            }
        };
        new AgentBuilder.Default()
                .type(ElementMatchers.<TypeDescription>nameStartsWith(ATTACH_PACKAGE))
                .transform(transformer)
                .installOn(inst);
    }

    /**
     * JVM运行时加载
     *
     * @param agentArgs String
     * @param inst Instrumentation
     */
    public static void agentmain(String agentArgs, Instrumentation inst) {
        System.err.println("[agentmain]: Hello, Java Agent.");
    }

}
