using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp13
{
    public class Rider
    {
        public string Id { get; set; }
        public string Name { get; set; }
        public string Location { get; set; }
        public double Rating { get; set; }
        public IPaymentMethod PreferredPaymentMethod { get; set; }

        public void RequestRide(string pickupLocation, string dropOffLocation, RideType rideType, RideRequestProcess rideRequestProcess)
        {
            rideRequestProcess.RequestRide(this, pickupLocation, dropOffLocation, rideType);
        }

        public void RateDriver(string driverId, double rating)
        {
            Console.WriteLine($"Rider {Id} rated driver {driverId} with {rating} stars.");
            Rating = rating;
        }




        public void MakePayment(double amount)
        {
            PreferredPaymentMethod?.ProcessPayment(amount);
        }
    }
}

