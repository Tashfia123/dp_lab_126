using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp13
{
    public class Trip
    {
        public string Id { get; set; }
        public string PickupLocation { get; set; }
        public string DropOffLocation { get; set; }
        public RideType RideType { get; set; }
        public string Status { get; set; }
        public double Fare { get; set; }
        public double Distance { get; set; }
        public Driver Driver { get; private set; }

        public void CalculateFare()
        {
            Fare = RideType.CalculateFare(Distance, TimeOfDay.Now);
            Console.WriteLine($"Fare for trip {Id} is {Fare:C}.");
        }

        public void AssignDriver(Driver driver)
        {
            Driver = driver;
            driver.AcceptRide(this);
        }

        public void CompleteTrip()
        {
            Status = "Completed";
            Console.WriteLine($"Trip {Id} is completed.");
        }
    }
}
