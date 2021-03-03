/*
1、加载
 1）通过一个类的全限定名来获取定义此类的二进制字节流。
 2）将这个字节流所代表的静态存储结构转化为方法区的运行时数据结构。
 3）在内存中生成一个代表这个类的java.lang.Class对象，作为方法区这个类的各种数据的访问入口。

2、链接
 1）验证
    - 确保Class文件的字节流中包含的信息符合《Java虚拟机规范》的全部约束要求，
    保证这些信息被当作代码运行后不会危害虚拟机自身的安全。
    - 文件格式验证、元数据验证、字节码验证、符号引用验证。
 2）准备
    - 正式为类中定义的变量（即静态变量，被static修饰的变量）分配内存并设置类变量初始值的阶段。
    - final在编译时就已经分配了，所以不包含final修饰的static
    - 不会为实例变量分配初始化
 3）解析：将常量池内的符号引用替换为直接引用的过程。


3、初始化


 */

package io.github.matrix.jvm;

/**
 *
 * @author Bing D. Yee
 * @since v1.0.0 2021/03/01
 */
public class JVM_ClassLoader {

    private static int num = 1;


    static {
        num = 2;
        number = 3;
        // 报错：非法的前向引用
        // System.err.println(number);
    }

    /** link-prepare: number=0 --> initial: number = 20 => 10 */
    private static int number = 10;

    public static void main(String[] args) {
        // 2
        System.err.println(num);
        // 10
        System.err.println(number);
    }


}
