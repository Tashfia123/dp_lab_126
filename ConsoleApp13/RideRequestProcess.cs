using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp13
{
    public class RideRequestProcess
    {
        private INotificationService _notificationService;
        private List<Driver> _drivers;

        public RideRequestProcess(INotificationService notificationService, List<Driver> drivers)
        {
            _notificationService = notificationService;
            _drivers = drivers;
        }

        public void RequestRide(Rider rider, string pickupLocation, string dropOffLocation, RideType rideType)
        {
            // Find the closest available driver based on pickupLocation and rideType
            Driver driver = FindAvailableDriver(pickupLocation, rideType);
            if (driver == null)
            {
                Console.WriteLine("No driver available.");
                return;
            }

            // Create and assign a new trip
            Trip trip = new Trip
            {
                Id = Guid.NewGuid().ToString(),
                PickupLocation = pickupLocation,
                DropOffLocation = dropOffLocation,
                RideType = rideType,
                Status = "Requested",
                Distance = 10.0 // Example distance
            };
            trip.CalculateFare();
            trip.AssignDriver(driver);

            // Notify rider and driver
            _notificationService.SendNotification("Ride confirmed", NotificationType.InApp, rider.Id);
            _notificationService.SendNotification("New ride request", NotificationType.InApp, driver.Id);

            // Simulate trip start and completion
            driver.StartTrip();
            trip.CompleteTrip();
            rider.MakePayment(trip.Fare);
            Console.WriteLine("Trip completed.");
        }

        private Driver FindAvailableDriver(string pickupLocation, RideType rideType)
        {
            // Find the closest driver with the appropriate vehicle type and availability
            // For simplicity, we will just pick the first available driver with the matching vehicle type
            return _drivers
                .Where(d => d.Availability && d.VehicleType == rideType.GetType().Name)
                .OrderBy(d => GetDistance(d.Location, pickupLocation)) // Simulated distance calculation
                .FirstOrDefault();
        }

        private double GetDistance(string location1, string location2)
        {
            // For simplicity, assume a fixed distance
            return 10.0;
        }
    }
}
