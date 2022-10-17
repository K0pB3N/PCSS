package Pr2;

import java.io.*;
import java.net.*;
import java.util.Arrays;

public class Server extends Thread {
    ServerSocket serverSocket;

    public Server() {
        try {
            serverSocket = new ServerSocket(1001);
            System.out.println(serverSocket.toString());
        } catch (IOException e) {
            fail(e, "Не удается создать серверный сокет");
        }
        System.out.println("Сервер запущен.");
        this.start();
    }

    public static void fail(Exception e, String str) {
        System.out.println(str + "." + e);
    }

    public void run() {
        try {
            while (true) {
                Socket client = serverSocket.accept();
                Connection con = new Connection(client);
            }
        } catch (IOException e) {
            fail(e, "Не удается принять соединение");
        }
    }

    public static void main(String args[]) {
        new Server();
    }
}

class Connection extends Thread {
    protected Socket netClient;
    protected BufferedReader fromClient;
    protected PrintStream toClient;

    public Connection(Socket client) {
        netClient = client;
        try {
            fromClient = new BufferedReader(new InputStreamReader(netClient.getInputStream()));
            toClient = new PrintStream(netClient.getOutputStream());
        } catch (IOException e) {
            try {
                netClient.close();
            } catch (IOException e1) {
                System.err.println("Невозможно настроить потоки" + e1);
                return;
            }
        }
        this.start();
        System.out.println("подключение к " + netClient);
    }

    public void run() {
        String message, garbage;
        double a, b;
        int n;
        int[] array;
        try {
            while (true) {
                toClient.print("Введите номер задания, которое хотите вывести на экран (доступны: 3, 6, 9, 27, 30): \n");
                message = fromClient.readLine();
                if (message.equals("9")) {
                    toClient.print("9. Найти площадь пятиугольника, кооpдинаты веpшин котоpого заданы.\n Опpеделить пpоцедуpу вычисления pасстояния между двумя точками, заданными своими кооpдинатами, и пpоцедуpу вычисления площади тpеугольника по тpем стоpонам. \n Описать функции с соответствующими формальными параметрами.\n");
                    toClient.print("Введите координаты вершин пятиугольника: \n");
                    message = fromClient.readLine();
                    String[] str = message.split(" ");
                    double[] arr = new double[str.length];
                    for (int i = 0; i < str.length; i++) {
                        arr[i] = Double.parseDouble(str[i]);
                    }
                    double s = 0;
                    for (int i = 0; i < arr.length; i += 2) {
                        s += arr[i] * arr[i + 3] - arr[i + 1] * arr[i + 2];
                    }
                    s = Math.abs(s) / 2;
                    toClient.print("Площадь пятиугольника: " + s + " | Введите что-нибудь, чтобы продолжить...");
                    garbage = fromClient.readLine();
                }
                if (message.equals("27")) {
                    toClient.print("27. Вычислить количество простых чисел, не превосходящих заданного N. Описать функцию логического типа, возвращающую значение true, если число простое и false в противном случае.\n");
                    toClient.print("Введите число N: \n");
                    message = fromClient.readLine();
                    n = Integer.parseInt(message);
                    int count = 0;
                    for (int i = 2; i <= n; i++) { //перебираем все числа от 2 до n
                        if (isPrime(i)) { 
                            count++;
                        }
                    }
                    toClient.print("Количество простых чисел: " + count + " | Введите что-нибудь, чтобы продолжить..."); 
                    garbage = fromClient.readLine();
                }
                if (message.equals("30")) {
                    toClient.print("30. Даны числа S, T. Получить с использованием функции пользователя G(12,S)+G(T, S)-G(2S-1, S*T) где G(A, B) = (2*A+B*B)/(A*B*2+B*5).\n");
                    toClient.print("Введите числа S и T через Enter: \n");
                    a = Double.parseDouble(fromClient.readLine());
                    b = Double.parseDouble(fromClient.readLine());
                    toClient.print("Результат: " + task30(a, b) + " | Введите что-нибудь, чтобы продолжить...");
                    garbage = fromClient.readLine();
                    
                }
                if (message.equals("3")) {
                    toClient.print("Даны числа S, T. Получить с использованием функции пользователя F(T,-2S,1.17)+F(2.2,T,S-T) где F(A, B, C) = (2A-B-sin(C))/(5+C)\n");
                    toClient.print("S: \n");
                    a = Double.parseDouble(fromClient.readLine());
                    toClient.print("T: \n");
                    b = Double.parseDouble(fromClient.readLine());
                    toClient.println("Результат: " + task3(a, b) + " | Введите что-нибудь, чтобы продолжить...");
                    garbage = fromClient.readLine();
                    
                }
                if (message.equals("6")) {
                    toClient.println("6. Составить пpогpамму для pасчета значений гипотенузы тpеугольника, опpеделив функцию, выполняющую этот pасчет. Катеты передаются в качестве параметров");
                    toClient.println("Введите катеты через Enter: ");
                    a = Double.parseDouble(fromClient.readLine());
                    b = Double.parseDouble(fromClient.readLine());
                    toClient.println("Гипотенуза: " + task6(a, b) + " | Введите что-нибудь, чтобы продолжить...");
                }
                if (message == null || message.equals("0")) {
                    System.out.println("Exit");
                    break;
                }
            }
        } catch (IOException e) {
        } finally {
            try {
                netClient.close();
            } catch (IOException e) {
            }
        }
    }

    

    private double task6(double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    private double task30(double s, double t) {
        return taskG(12, s) + taskG(t, s) - taskG(2 * s - 1, s * t);
    }

    private double taskG(double a, double b) {
        return ((2*a + b*b) / (a*b*2 + b*5));
    }

    private boolean isPrime(int i) { // функция, возвращающая true, если число простое и false в противном случае
        for (int j = 2; j < i; j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    private String task3(double a, double b) { // функция, вычисляющая значение функции
        return String.valueOf(taskF(b, -2 * a, 1.17) + taskF(2.2, b, a - b)); 
    }

    private int taskF(double b, double d, double e) { 
        return (int) ((2 * b - d - Math.sin(e)) / (5 + e));
    }

} 
