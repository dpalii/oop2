using System;
using System.Collections.Generic;

namespace ProxyExample
{
    class Program
    {
        static void Main(string[] args)
        {
            AdminNotificator adminNotificator = new AdminNotificator();
            var random = new Random();
            var users = new List<User>();
            for (int i = 1; i <= 10; i++)
            {
                var user = new User() { admin = Convert.ToBoolean(i % 2), username = "user" + i, };
                users.Add(user);
            }
            adminNotificator.SendToAll(users, "Admin eyes only");
            Console.ReadKey();
        }
    }

    class User
    {
        public string username;
        public bool admin;
    }
    abstract class Abst_Notificator
    {
        public abstract void SendMessage(User u, string message);
    }
    //realsubject
    class Notificator : Abst_Notificator
    {
        public override void SendMessage(User u, string message)
        {
            Console.WriteLine("New message for {0}: {1}", u.username, message);
        }
    }
    //proxy
    class AdminNotificator : Abst_Notificator
    {
        Notificator notificator = new Notificator();
        public override void SendMessage(User u, string message)
        {
            if (u.admin)
                notificator.SendMessage(u, message);
            else
                Console.WriteLine("{0} has no access to this message", u.username);
        }
        public void SendToAll(List<User> users, string message)
        {
            foreach (User u in users)
            {
                SendMessage(u, message);
            }
        }
    }
}
