using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp13
{
    public class Driver
    {
        public string Id { get; set; }
        public string Name { get; set; }
        public string VehicleType { get; set; }
        public string Location { get; set; }
        public double Rating { get; set; }
        public bool Availability { get; set; }

        public void AcceptRide(Trip trip)
        {
            Console.WriteLine($"Driver {Id} accepted trip {trip.Id}.");
            trip.Status = "Accepted";
        }

        public void RateRider(string riderId, double rating)
        {
            Console.WriteLine($"Driver {Id} rated rider {riderId} with {rating} stars.");
            Rating = rating;
        }

        public void UpdateLocation(string newLocation)
        {
            Location = newLocation;
            Console.WriteLine($"Driver {Id} updated location to {newLocation}.");
        }

        public void StartTrip()
        {
            Console.WriteLine($"Driver {Id} started the trip.");
        }
    }
}
