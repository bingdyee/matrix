package io.hikari.jvm;

import org.openjdk.jol.info.ClassLayout;

/**
 * 1.8 default Garbage Collector: ParallelGC: Parallel Scavenge(Young) & Parallel Old(Old)
 *      java -XX:+PrintCommandLineFlags -version
 *      Serial + Serial Old | ParNew + CMS | Parallel Scavenge + Parallel Old
 *
 * @author Noa Swartz
 * @date 2020-04-14
 */
public class Main {

    public static void main(String[] args) {
        Object obj = new Object();
        System.err.println(ClassLayout.parseInstance(obj).toPrintable());
        synchronized (obj) {
            System.err.println(ClassLayout.parseInstance(obj).toPrintable());
        }
    }

}
