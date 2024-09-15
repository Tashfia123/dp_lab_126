using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp13
{
    public class NotificationService : INotificationService
    {
        public void SendNotification(string message, NotificationType type, string recipient)
        {
            Console.WriteLine($"Sent {type} notification to {recipient}: {message}");
        }
    }
}
