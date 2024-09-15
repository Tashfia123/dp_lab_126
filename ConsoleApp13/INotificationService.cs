using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp13
{
    public interface INotificationService
    {
        void SendNotification(string message, NotificationType type, string recipient);
    }

    public enum NotificationType
    {
        SMS,
        Email,
        InApp
    }
}
