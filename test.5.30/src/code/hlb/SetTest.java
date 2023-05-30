package code.hlb;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    public static void main(String[] args) {
        /*
         *  Set是一个不允许重复元素的集合。Set中的元素没有特定的顺序。常见的Set实现包括HashSet和TreeSet。
         */
        // 创建一个HashSet对象
        Set<String> set = new HashSet<String>();

        // 添加元素到集合中  -- 这里是随机插入，并没有顺序
        set.add("Java");
        set.add("Python");
        set.add("C++");
        // Set 不允许重复元素，因此此处不会再插入
//        set.add("Java");

        // 获取集合大小
        System.out.println("Set size: " + set.size());

        // 遍历集合
        System.out.println("Previous set:" + set);
//        for (String item : set) {
//            System.out.println(item);
//        }

        // 检查元素是否存在于集合中
        boolean contains = set.contains("Java");
        System.out.println("Contains Java: " + contains);

        // 删除元素
        set.remove("Python");
        System.out.println("After remove: " + set);
    }
}
