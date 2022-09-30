import java.util.Scanner;

public class Practice_One {

    private static final Scanner in = new Scanner(System.in);
    static int num = 0;

    public static void main(String[] args) {
        System.out.println("Какая задача вас интересует? Доступны: 2, 7, 12, 17, 27");
        try {
            int num2 = in.nextInt(), x, y;
            double z;
            switch (num2) {
                case 2 -> {
                    System.out.println("2. Даны действительные числа x, y, z. Найти минимальное из них");
                    System.out.println("Введите числа");
                    x = in.nextInt();
                    y = in.nextInt();
                    z = in.nextInt();
                    System.out.println("Минимальное число: " + Math.min(Math.min(x, y), z));
                    
                } 
                case 7 -> {
                    System.out.println("7. Даны действительные числа x,y. Вычислить значение функции z=log(x-y)-x/y");
                    System.out.println("Введите числа");
                    x = in.nextInt();
                    y = in.nextInt();
                    z = Math.log(x - y) - x / y;
                    System.out.println("Значение функции: " + z);
                }
                case 12 -> {
                    System.out.println("12. Даны действительные числа А, В. Если они оба отрицательные, то заменить каждое из них его квадратом, иначе положительные из них увеличить в два pаза");
                    System.out.println("Введите числа");
                    int a = in.nextInt();
                    int b = in.nextInt();
                    if (a < 0 && b < 0) {
                        System.out.println("Квадрат чисел: " + a * a + " " + b * b);
                    } else {
                        System.out.println("Увеличение чисел в два раза: " + a * 2 + " " + b * 2);
                    }
        
                }               
                case 17 -> {
                    System.out.println(
                            "17. На плоскости расположена окружность радиуса R с центром в начале координат. Определить, лежат ли точки А (x1,y1) и B (x2,y2) на окружности");
                    System.out.println("Введите радиус");
                    int r = in.nextInt();
                    System.out.println("Введите координаты точки А");
                    int x1 = in.nextInt();
                    int y1 = in.nextInt();
                    System.out.println("Введите координаты точки B");
                    int x2 = in.nextInt();
                    int y2 = in.nextInt();
                    if (Math.sqrt(x1 * x1 + y1 * y1) == r && Math.sqrt(x2 * x2 + y2 * y2) == r) {
                        System.out.println("Точки лежат на окружности");
                    } else {
                        System.out.println("Точки не лежат на окружности");
                    }
                }
                case 27 -> {
                    System.out.println("27. Даны действительные числа x, y, z. Получить максимальное из них по модулю.");
                    System.out.println("Введите числа");
                    x = in.nextInt();
                    y = in.nextInt();
                    z = in.nextInt();
                    System.out.println("Максимальное число по модулю: " + Math.max(Math.max(Math.abs(x), Math.abs(y)), Math.abs(z)));
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
