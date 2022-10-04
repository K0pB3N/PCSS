import java.util.Scanner;

public class Practice_One {

    private static final Scanner in = new Scanner(System.in);
    static int num = 0;

    public static void main(String[] args) {
        System.out.println("Какая задача вас интересует? Доступны: 3, 6, 9, 27, 30");
        try {
            int num2 = in.nextInt(), x, y;
            double z;
            switch (num2) {
                case 3 -> {
                    System.out.println("3. Даны действительные положительные числа А,В,С. Выяснить, пройдет ли кирпич с ребрами А, В, С в прямоугольное отверстие со сторонами x, y");
                    System.out.println("Введите сторону x");
                    x = in.nextInt();
                    System.out.println("Введите сторону y");
                    y = in.nextInt();
                    System.out.println("Введите сторону А");
                    int a = in.nextInt();
                    System.out.println("Введите сторону В");
                    int b = in.nextInt();
                    System.out.println("Введите сторону С");
                    int c = in.nextInt();
                    if (a <= x && b <= y || a <= y && b <= x || a <= x && c <= y || a <= y && c <= x || b <= x && c <= y || b <= y && c <= x) {
                        System.out.println("Кирпич пройдет");
                    } else {
                        System.out.println("Кирпич не пройдет");
                    }
                    
                } 
                case 6 -> {
                    System.out.println("6. Даны действительные числа А, В, С. Проверить выполняются ли неравенства А < В < С, если да, то присвоить А = В+С иначе А = С-В");
                    System.out.println("Введите число А");
                    int a = in.nextInt();
                    System.out.println("Введите число В");
                    int b = in.nextInt();
                    System.out.println("Введите число С");
                    int c = in.nextInt();
                    if (a < b && b < c) {
                        a = b + c;
                        System.out.println("A (B+C)= " + a);
                    } else {
                        a = c - b;
                        System.out.println("A (C-B)= " + a);
                    }
                }
                case 9 -> {
                    System.out.println("9. Даны круг радиуса R и квадрат со стороной А. Определить их взаимное положение");
                    System.out.println("Введите радиус круга");
                    int r = in.nextInt();
                    System.out.println("Введите сторону квадрата");
                    int a = in.nextInt();
                    if (r * 2 <= a) {
                        System.out.println("Круг вписан в квадрат");
                    } else if (r * 2 > a) {
                        System.out.println("Круг не вписан в квадрат");
                    }
        
                }               
                case 27 -> {
                    System.out.println(
                            "27. Даны действительные числа x, y, z. Получить максимальное из них по модулю");
                    System.out.println("Введите числа");
                    x = in.nextInt();
                    y = in.nextInt();
                    z = in.nextInt();
                    System.out.println("Максимальное число по модулю: " + Math.max(Math.max(Math.abs(x), Math.abs(y)), Math.abs(z)));
                    
                }
                case 30 -> {
                    System.out.println("30. Лежат ли обе точки D (a1;b1) и C (a2;b2) внутри круга радиуса R с центром в начале координат? Если такой точки нет, выдать соответствующее сообщение");
                    System.out.println("Введите радиус");
                    int r = in.nextInt();
                    System.out.println("Введите координаты точки D");
                    int a1 = in.nextInt();
                    int b1 = in.nextInt();
                    System.out.println("Введите координаты точки C");
                    int a2 = in.nextInt();
                    int b2 = in.nextInt();
                    if (Math.sqrt(a1 * a1 + b1 * b1) <= r && Math.sqrt(a2 * a2 + b2 * b2) <= r) {
                        System.out.println("Точки лежат внутри круга");
                    } else {
                        System.out.println("Точки не лежат внутри круга");
                    }
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

}
