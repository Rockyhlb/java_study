package code;

public class hlb {
    public static void main(String[] args) {
        //字符串的创建
        //String 创建的字符串存储在公共池中，而 new 创建的字符串对象在堆上：
        String s1 = new String("hello world");
        System.out.println(s1);
        s1 = "hello work";
        System.out.println(s1);

        //访问器方法的使用
        // String 类的一个访问器方法是 length() 方法，它返回字符串对象包含的字符数
        System.out.println("s1的长度：" + s1.length());
        // isEmpty() 方法用于判断字符串是否为空。
        System.out.println("s1是否为空：" + s1.isEmpty());
        //indexOf(int ch): 返回指定字符在字符串中第一次出现处的索引，如果没有这样的字符，则返回 -1。
        // indexOf(int ch, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引;
        // indexOf(String str): 返回指定字符在字符串中第一次出现处的索引，如果没有这样的字符，则返回 -1;
        // indexOf(String str, int fromIndex): 返回从 fromIndex 位置开始查找指定字符在字符串中第一次出现处的索引;
        int index = s1.indexOf('o');
        System.out.println(index);
        int index1 = s1.indexOf('o',5);
        System.out.println(index1);

        //String builder 和 String buffer
        //和 String 类不同的是，StringBuffer 和 StringBuilder 类的对象能够被多次的修改，并且不产生新的未使用对象。
        // StringBuilder 类在 Java 5 中被提出，它和 StringBuffer 之间的最大不同在于 StringBuilder 的方法不是线程安全的（不能同步访问）。
        // 由于 StringBuilder 相较于 StringBuffer 有速度优势，所以多数情况下建议使用 StringBuilder 类。
//        StringBuilder sb1 =  new StringBuilder("hello");
//        sb1.append(" code.hlb");//将指定的字符串追加到此字符序列
//        System.out.println(sb1);
//        sb1.insert(3,'f');//在原字符串第3+1个位置插入字符'f'
//        System.out.println(sb1);
//        sb1.delete(3,5);
//        System.out.println(sb1);

        //然而在应用程序要求线程安全的情况下，则必须使用 StringBuffer 类
        StringBuffer sb2 = new StringBuffer("hello world：");
        sb2.append("你好");
        sb2.append(".2.23");
        System.out.println(sb2);
    }
}
