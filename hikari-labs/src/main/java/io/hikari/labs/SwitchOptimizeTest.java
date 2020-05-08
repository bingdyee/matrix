package io.hikari.labs;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Fork;
import org.openjdk.jmh.annotations.Measurement;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.annotations.Scope;
import org.openjdk.jmh.annotations.State;
import org.openjdk.jmh.annotations.Warmup;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author Noa Swartz
 */
@BenchmarkMode(Mode.AverageTime)
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@Warmup(iterations = 2, time = 1, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 5, time = 1, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Thread)
public class SwitchOptimizeTest {

    static Integer NUM = 9;

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(SwitchOptimizeTest.class.getSimpleName())
                .output("E:/jmh-switch.log")
                .build();
        new Runner(opt).run();
    }

    @Benchmark
    public void testSwitch() {
        int num;
        switch (NUM) {
            case 1:
                num = 1;
                break;
            case 3:
                num = 3;
                break;
            case 5:
                num = 5;
                break;
            case 7:
                num = 7;
                break;
            case 9:
                num = 9;
                break;
            default:
                num = -1;
                break;
        }
        System.err.println(num);
    }

    @Benchmark
    public void testIf() {
        int num;
        if (NUM == 1) {
            num = 1;
        } else if (NUM == 3) {
            num = 3;
        } else if (NUM == 5) {
            num = 5;
        } else if (NUM == 7) {
            num = 7;
        } else if (NUM == 9) {
            num = 9;
        } else {
            num = -1;
        }
        System.err.println(num);
    }

}
