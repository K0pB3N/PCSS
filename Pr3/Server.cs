using System;
using System.Text;
using System.Net;
using System.Net.Sockets;

namespace SocketServer
{
    class Program
    {

        static void Main(string[] args)
        {
            int i = 1;
            // Устанавливаем для сокета локальную конечную точку
            IPHostEntry ipHost = Dns.GetHostEntry("localhost");
            IPAddress ipAddr = ipHost.AddressList[0];
            IPEndPoint ipEndPoint = new IPEndPoint(ipAddr, 11000);

            // Создаем сокет Tcp/Ip
            Socket sListener = new Socket(ipAddr.AddressFamily, SocketType.Stream, ProtocolType.Tcp);

            // Назначаем сокет локальной конечной точке и слушаем входящие сокеты
            try
            {
                sListener.Bind(ipEndPoint);
                sListener.Listen(10);

                // Начинаем слушать соединения
                while (true)
                {
                    Console.WriteLine("Ожидаем соединение через порт {0}", ipEndPoint);

                    // Программа приостанавливается, ожидая входящее соединение
                    Socket handler = sListener.Accept();
                    string? data = null;

                    // Мы дождались клиента, пытающегося с нами соединиться

                    byte[] bytes = new byte[1024];
                    int bytesRec = handler.Receive(bytes);

                    data += Encoding.UTF8.GetString(bytes, 0, bytesRec);


                    // Показываем данные на консоли
                    Console.Write("Полученный текст: " + data + "\n\n");

                    // Отправляем ответ клиенту\
                    if (i == 1)
                    {
                        string reply = "Задание 25. Ответ: " + func1(data);
                        byte[] msg = Encoding.UTF8.GetBytes(reply);
                        handler.Send(msg);
                        i++;
                        
                    }
                    else if (i == 2)
                    {
                        string reply = "Задание 28. Ответ: " + func2();
                        byte[] msg = Encoding.UTF8.GetBytes(reply);
                        handler.Send(msg);
                        i++;
                    }
                    else if (i == 3)
                    {
                        string reply = "Задание 1. Ответ: " + func3();
                        byte[] msg = Encoding.UTF8.GetBytes(reply);
                        handler.Send(msg);
                        i++;
                    }
                    else if (i == 4)
                    {
                        string reply = "Задание 4. Ответ: " + func4();
                        byte[] msg = Encoding.UTF8.GetBytes(reply);
                        handler.Send(msg);
                        i++;
                    }
                    else if (i == 5)
                    {
                        if (!func5(data).Equals("false"))
                        {
                            string reply = "Задание 7. Ответ: " + func5(data);
                            byte[] msg = Encoding.UTF8.GetBytes(reply);
                            handler.Send(msg);
                        }

                        else
                        {
                            string reply = "Введеное число не входит в область определения";
                            byte[] msg = Encoding.UTF8.GetBytes(reply);
                            handler.Send(msg);
                            i++;
                        }

                    }

                    if (data.IndexOf("<TheEnd>") > -1)
                    {
                        Console.WriteLine("Сервер завершил соединение с клиентом.");
                        break;
                    }

                    handler.Shutdown(SocketShutdown.Both);
                    handler.Close();
                }
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
        static string func1(string A)
        {
            double a = Convert.ToDouble(A);
            double x, z;
            String otv = "";
            for (x = -2; x <= 8; x += 0.75)
            {
                z = (4 * x - 3 * x + Math.Tan(x)) / a;
                otv += z.ToString() + " ";

            }


            return otv;
        }
        static string func2()
        {
            double x, z;
            String otv = "";
            for (x = -5; x <= 12; x += 1.2)
            {
                z = Math.Sin(x) - 5 * Math.Cos(x - 2);
                if (z > 0)
                {
                    otv += z.ToString() + " ";

                }
            }


            return otv;
        }
        static string func3()
        {
            double x, z;
            String otv = "";
            for (x = -5; x <= 12; x += 1.2)
            {
                z = Math.Sin(x) + 5 * Math.Cos(x - 2);
                if (z > 0)
                {
                    otv += z.ToString() + " | ";

                }
            }
            return otv;
        }
        static string func4()
        {
            double x, z;
            String otv = "";
            for (x = 3; x <= 8; x += 0.9)
            {
                z = Math.Log(x) + Math.Tan(2 * x);
                if (z > 1)
                {
                    otv += z.ToString() + " | ";

                }
            }
            return otv;
        }
        static string func5(string X)
        {
            String otv = "";
            double x = Convert.ToDouble(X);
            double y = Math.Log(x - (1 / x));
            if (y > 0 && x > 1)
            {
                otv += y.ToString() + " | ";
            }
            else
            {
                otv = "false";
            }
            return otv;
        }

    }
}
