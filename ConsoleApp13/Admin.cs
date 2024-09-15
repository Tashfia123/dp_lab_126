using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp13
{
    public class Admin
    {
        public string Id { get; set; }
        public string Name { get; set; }
        public string Role { get; set; }

        public void ManageDriver(Driver driver, bool isActive)
        {
            driver.Availability = isActive;
            Console.WriteLine($"Admin {Name} set driver {driver.Id} availability to {isActive}.");
        }

        public void ManageRider(Rider rider, bool isActive)
        {
            // Logic to manage rider
            Console.WriteLine($"Admin {Name} managed rider {rider.Id}.");
        }

        public void ViewTripHistory()
        {
            // Logic to view trip history
            Console.WriteLine("Admin viewed trip history.");
        }

        public void HandleDispute(string tripId)
        {
            // Logic to handle disputes
            Console.WriteLine($"Admin handled dispute for trip {tripId}.");
        }
    }
}
