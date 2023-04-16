package code.hlb;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class Test {
    // 作业
    public static void main(String[] args) {
//        int Number1 = 0;
//        int Number2 = 0;
//        int[] Array1 = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
//
//        for (int Ctr : Array1) {
//            if (Ctr % 2 == 1) {
//                Number1++;
//            } else {
//                Number2++;
//                System.out.print(Ctr);
//            }
//        }

//        String s1 = "hello";
//        String s2 = "hello";
//        System.out.println(s1.equals(s2));
//        System.out.println(s1.compareTo(s2));

        LocalDateTime dat = LocalDateTime.now();
        System.out.println(dat);

        LocalDateTime dat2 = LocalDateTime.now().plusDays(1);
        System.out.println(dat);
    }
}
