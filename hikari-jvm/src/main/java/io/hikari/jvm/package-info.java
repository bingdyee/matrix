/*
* JDK1.8 default Garbage Collector:
*       ParallelGC: Parallel Scavenge(Young) & Parallel Old(Old)
* @see java -XX:+PrintCommandLineFlags -version
* Young + Old: Serial + Serial Old | ParNew + CMS | Parallel Scavenge + Parallel Old
*
* GC Log:
*   -Xloggc:/xxx/logs/xxx-gc-%t.log -XX:+UseGCLogFileRotation -XX:NumberOfGCLogFiles=5
*   -XX:GCLogFileSize=20M -XX:+PrintGCDetails -XX:+PrintGCDateStamps -XX:+PrintGCCause
*
* -XX:+HeapDumpOnOutOfMemoryError
*/

/**
 *
 *
 *
 */
package io.hikari.jvm;