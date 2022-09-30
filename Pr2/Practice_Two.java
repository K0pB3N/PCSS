package Pr2;

import java.util.Scanner;

public class Practice_Two {
    private static final Scanner in = new Scanner(System.in);
    static int num = 0;

    public static void main(String[] args) {
        System.out.println("Какая задача вас интересует? Доступны: 2, 7, 12, 17, 27");
        try {
            int num2 = in.nextInt(), x, y;
            switch (num2){

                case 2 -> {
                    System.out.println("Составить пpогpамму для нахождения суммы элементов каждого из тpех массивов, введенных с клавиатуpы, опpеделив функцию, выполняющую это действие, и передавая массивы в качестве параметра.");
                    System.out.println("Введите размер массива 1");
                    num = in.nextInt();
                    System.out.println("Введите размер массива 2");
                    x = in.nextInt();
                    System.out.println("Введите размер массива 3");
                    y = in.nextInt();
                    int[] arr = new int[num];
                    int[] arr1 = new int[x];
                    int[] arr2 = new int[y];
                    System.out.println("Введите элементы массива 1");
                    for (int i = 0; i < num; i++) {
                        arr[i] = in.nextInt();
                    }
                    System.out.println("Введите элементы массива 2");
                    for (int j = 0; j < x; j++) {
                        arr1[j] = in.nextInt();
                    }
                    System.out.println("Введите элементы массива 3");
                    for (int q = 0; q < y; q++) {
                        arr2[q] = in.nextInt();
                    }
                    System.out.println("Сумма элементов массива 1: " + sum(arr));
                    System.out.println("Сумма элементов массива 2: " + sum(arr1));
                    System.out.println("Сумма элементов массива 3: " + sum(arr2));
                }
                
                case 7 -> {
                    System.out.println("Найти пеpиметp десятиугольника, кооpдинаты веpшин котоpого заданы. Опpеделить пpоцедуpу вычисления pасстояния между двумя точками, заданными своими кооpдинатами, которые передаются функции в качестве параметров из основной программы.");
                    System.out.println("Введите координаты вершин десятиугольника");
                    int[][] arr = new int[10][2];
                    for (int i = 0; i < 10; i++) {
                        for (int j = 0; j < 2; j++) {
                            arr[i][j] = in.nextInt();
                        }
                    }
                    System.out.println("Периметр десятиугольника: " + perimetr(arr));
                }

                case 12 -> {
                    System.out.println("Используя подпpогpамму - функцию, составить пpогpамму для печати знаков тpех чисел, введенных с клавиатуpы и передаваемых функции в качестве параметра.");
                    System.out.println("Введите три числа");
                    int a = in.nextInt(), b = in.nextInt(), c = in.nextInt();
                    System.out.println("Знаки чисел: " + sign(a, b, c));
                }

                case 17 -> {
                    System.out.println("Найти пеpиметp восьмиугольника, кооpдинаты веpшин котоpого заданы. Опpеделить функцию вычисления pасстояния между двумя точками, заданными своими кооpдинатами. Координаты передать функции в качестве параметров.");
                    System.out.println("Введите координаты вершин восьмиугольника");
                    int[][] arr = new int[8][2];
                    for (int i = 0; i < 8; i++) {
                        for (int j = 0; j < 2; j++) {
                            arr[i][j] = in.nextInt();
                        }
                    }
                    System.out.println("Периметр восьмиугольника: " + perimetr(arr));

                }
                
                case 27 -> {
                    System.out.println("Вычислить количество простых чисел, не превосходящих заданного N. Описать функцию логического типа, возвращающую значение true, если число простое и false в противном случае.");
                    System.out.println("Введите число");
                    int a = in.nextInt();
                    System.out.println("Количество простых чисел: " + count(a));
                                    }
            }
                

        
    } catch (Exception e) {
        System.out.println("Производится выход из программы");
        in.close();
    }
}

    

    private static String count(int a) {
        int count = 0;
        for (int i = 2; i <= a; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return String.valueOf(count);
    }



    private static boolean isPrime(int i) {
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }



    private static String sign(int a, int b, int c) {
        String s = "";
        if (a > 0) {
            s += "+";
        } else if (a < 0) {
            s += "-";
        } else {
            s += "0";
        }
        if (b > 0) {
            s += "+";
        } else if (b < 0) {
            s += "-";
        } else {
            s += "0";
        }
        if (c > 0) {
            s += "+";
        } else if (c < 0) {
            s += "-";
        } else {
            s += "0";
        }
        return s;
    }



    private static String perimetr(int[][] arr) {
        double sum = 0;
        for (int i = 0; i < 9; i++) {
            sum += distance(arr[i][0], arr[i][1], arr[i + 1][0], arr[i + 1][1]);
        }
        sum += distance(arr[0][0], arr[0][1], arr[9][0], arr[9][1]);
        return String.valueOf(sum);
        
    }



    private static double distance(int i, int j, int k, int l) {
        return Math.sqrt(Math.pow(i - k, 2) + Math.pow(j - l, 2));
    }



    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < num; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
