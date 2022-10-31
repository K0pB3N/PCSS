using System;
using System.Text;
using System.Net;
using System.Net.Sockets;

namespace SocketClient
{
    class Program
    {
        static void Main(string[] args)
        {
            int i = 1;
            try
            {
                SendMessageFromSocket(11000, i);
            }
            catch (Exception ex)
            {
                Console.WriteLine(ex.ToString());
            }
            finally
            {
                Console.ReadLine();
            }
        }

        static void SendMessageFromSocket(int port, int i)
        {
            // Буфер для входящих данных
            byte[] bytes = new byte[1024];

            // Соединяемся с удаленным устройством

            // Устанавливаем удаленную точку для сокета
            IPHostEntry ipHost = Dns.GetHostEntry("localhost");
            IPAddress ipAddr = ipHost.AddressList[0];
            IPEndPoint ipEndPoint = new IPEndPoint(ipAddr, port);

            Socket sender = new Socket(ipAddr.AddressFamily, SocketType.Stream, ProtocolType.Tcp);

            // Соединяем сокет с удаленной точкой
            sender.Connect(ipEndPoint);

            if (i == 1)
            {
                Console.Write("Задание 25.Для x из интервала (-2;8) с шагом 0,75 вычислить y=(4x-3x+tg(x))/А, где А вводится с клавиатуры.\nВведите число А\n");
                string message = Console.ReadLine();


                byte[] msg = Encoding.UTF8.GetBytes(message);

                // Отправляем данные через сокет
                int bytesSent = sender.Send(msg);

                // Получаем ответ от сервера
                int bytesRec = sender.Receive(bytes);

                Console.WriteLine("\nОтвет от сервера: {0}\n\n", Encoding.UTF8.GetString(bytes, 0, bytesRec));
                i++;
                // Используем рекурсию для неоднократного вызова SendMessageFromSocket()
                if (message.IndexOf("<TheEnd>") == -1)
                    SendMessageFromSocket(port, i);

            }
            if (i == 2)
            {

                Console.Write("Задание 28.Вывести на печать положительные значения функции z=sin(x)-5cos(x-2) для x изменяющегося на отрезке [5,-12] с шагом 1,2.\nВведите любой символ\n");
                string message = Console.ReadLine();


                byte[] msg = Encoding.UTF8.GetBytes(message);

                // Отправляем данные через сокет
                int bytesSent = sender.Send(msg);

                // Получаем ответ от сервера
                int bytesRec = sender.Receive(bytes);

                Console.WriteLine("\nОтвет от сервера: {0}\n\n", Encoding.UTF8.GetString(bytes, 0, bytesRec));
                i++;
                // Используем рекурсию для неоднократного вызова SendMessageFromSocket()
                if (message.IndexOf("<TheEnd>") == -1)
                    SendMessageFromSocket(port, i);


            }
            if (i == 3)
            {

                Console.Write("Задание 1.Вывести на печать положительные значения функции z=sin(x)+5cos(x-2) для x изменяющегося на отрезке [5,-12] с шагом 1,2.\nВведите любой символ\n");
                string message = Console.ReadLine();


                byte[] msg = Encoding.UTF8.GetBytes(message);

                // Отправляем данные через сокет
                int bytesSent = sender.Send(msg);

                // Получаем ответ от сервера
                int bytesRec = sender.Receive(bytes);

                Console.WriteLine("\nОтвет от сервера: {0}\n\n", Encoding.UTF8.GetString(bytes, 0, bytesRec));
                i++;
                // Используем рекурсию для неоднократного вызова SendMessageFromSocket()
                if (message.IndexOf("<TheEnd>") == -1)
                    SendMessageFromSocket(port, i);

            }

            if (i == 4)
            {
                Console.Write("Задание 4.Вывести на печать значения функции z=ln(x)+tg(2x), большие 1, для x изменяющегося на отрезке [3, 8] с шагом 0,9.\nВведите любой символ\n");
                string message = Console.ReadLine();


                byte[] msg = Encoding.UTF8.GetBytes(message);

                // Отправляем данные через сокет
                int bytesSent = sender.Send(msg);

                // Получаем ответ от сервера
                int bytesRec = sender.Receive(bytes);

                Console.WriteLine("\nОтвет от сервера: {0}\n\n", Encoding.UTF8.GetString(bytes, 0, bytesRec));
                i++;
                // Используем рекурсию для неоднократного вызова SendMessageFromSocket()
                if (message.IndexOf("<TheEnd>") == -1)
                {
                    SendMessageFromSocket(port, i);
                }

            }

            if (i == 5)
            {

                Console.Write("Задание 7.Напечатать значения функции y=ln(x-1/x),где значения x вводятся с клавиатуры. При вводе числа,не входящего в область определения функции, вычисления прекратить.\nВведите число\n");
                string message = Console.ReadLine();


                byte[] msg = Encoding.UTF8.GetBytes(message);

                // Отправляем данные через сокет
                int bytesSent = sender.Send(msg);

                // Получаем ответ от сервера
                int bytesRec = sender.Receive(bytes);
                if (!Encoding.UTF8.GetString(bytes, 0, bytesRec).Equals("Введеное число не входит в область определения"))
                {
                    Console.WriteLine("\nОтвет от сервера: {0}\n\n", Encoding.UTF8.GetString(bytes, 0, bytesRec));
                    // Используем рекурсию для неоднократного вызова SendMessageFromSocket()
                    if (message.IndexOf("<TheEnd>") == -1)
                        SendMessageFromSocket(port, i);
                }
                else
                {
                    Console.WriteLine("\nОтвет от сервера: {0}\n\n", Encoding.UTF8.GetString(bytes, 0, bytesRec));
                    // Используем рекурсию для неоднократного вызова SendMessageFromSocket()
                    i++;
                    if (message.IndexOf("<TheEnd>") == -1)
                        SendMessageFromSocket(port, i);
                }
            }

            if (i == 6)
            {
                Console.WriteLine("\nКонец программы");
                sender.Shutdown(SocketShutdown.Both);
                sender.Close();
            }
            sender.Shutdown(SocketShutdown.Both);
            sender.Close();
        }
    }
}
