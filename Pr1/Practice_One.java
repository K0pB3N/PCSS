import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Practice_One {

    private static final Scanner in = new Scanner(System.in);
    static int num = 0;

    public static void main(String[] args) {
        System.out.println("Какая задача вас интересует? Доступны: 17, 20, 23, 26, 29");
        try {
            int num2 = in.nextInt(), x, y;
            double z;
            switch (num2) {
                case 17 -> {
                    System.out.println(
                            "17. На плоскости расположена окруж-ность радиуса R с центром в начале координат. Определить, лежат ли точки А(x1,y1) и B(x2,y2) на окружности");
                    System.out.println("Введите радиус");
                    num = in.nextInt();
                    prin("x1", "y1");
                    prin("x2", "y2");
                }
                case 20 -> {
                    System.out.println("20. Вывести на печать переменные А,В,С в порядке их убывания");
                    System.out.println("Введите А,В,С");
                    int a = in.nextInt();
                    int b = in.nextInt();
                    int c = in.nextInt();
                    Integer[] arr = { a, b, c };
                    Arrays.sort(arr, Collections.reverseOrder());
                    System.out.println(Arrays.toString(arr));
                }
                case 23 -> {
                    System.out.println("Даны действительные числа x,y. Вычис-лить значение функции z=ln(x)-x/y");
                    System.out.println("Введите x, y");
                    x = in.nextInt();
                    y = in.nextInt();
                    System.out.println("z = ");
                    z = Math.log10(x) - (double) x / y;
                    System.out.print(z);
                }
                case 26 -> {
                    System.out.println("Даны действительные числа x,y. Вычис-лить значение функции z=arcsin(x)-y");
                    System.out.println("Введите x, y");
                    x = in.nextInt();
                    y = in.nextInt();
                    System.out.println("z = ");
                    System.out.print(Math.asin(x) - y);
                }
                case 29 -> {
                    System.out.println("На каком из интервалов (-oo;k1),(k1;k2),(k2;+oo) лежит точка x? Где k1, k2,\n"
                            + "x – вводимые произ-вольные числа, причем k1<k2");
                    System.out.println("Введите x, k1, k2");
                    x = in.nextInt();
                    y = in.nextInt();
                    z = in.nextInt();
                    if (x < y)
                        System.out.println("Точка х принадлежит интервалу (-oo;k1)");
                    if (x > y && x < z)
                        System.out.println("Точка х принадлежит интервалу (k1;k2)");
                    if (x > z)
                        System.out.println("Точка х принадлежит интервалу (k2;+oo)");
                }
                default -> {
                    System.out.println("Производится выход из программы");
                    in.close();
                }
            }
        } catch (Exception e) {
            System.out.println("Производится выход из программы");
            in.close();
        }
    }

    private static void prin(String xs, String ys) {
        System.out.println("Введите " + xs);
        int x = in.nextInt();
        System.out.println("Введите " + ys);
        int y = in.nextInt();
        double num1 = Math.sqrt(x * x + y * y);
        if (num1 > num) {
            System.out.println("Точка не принадлежит к кругу");
        } else {
            System.out.println("Точка принадлежит к кругу");
        }
    }
}
