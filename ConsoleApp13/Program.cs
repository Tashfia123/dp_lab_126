using ConsoleApp13;
using System.Collections.Generic;
using System;

class Program
{
    static void Main(string[] args)
    {
        INotificationService notificationService = new NotificationService();
        List<Driver> drivers = new List<Driver>
        {
            new Driver { Id = "D1", Name = "John", VehicleType = "Carpool", Location = "Downtown", Availability = true },
            new Driver { Id = "D2", Name = "Jane", VehicleType = "LuxuryRide", Location = "Uptown", Availability = true }
        };
        RideRequestProcess rideRequestProcess = new RideRequestProcess(notificationService, drivers);

        // Create a rider
        Rider rider = new Rider
        {
            Id = "R1",
            Name = "Alice",
            Location = "Midtown",
            Rating = 4.5,
            PreferredPaymentMethod = new CreditCard() // Example payment method
        };

        Console.WriteLine("Welcome to the Ride-Sharing Application!");

        while (true)
        {
            Console.WriteLine("\nOptions:");
            Console.WriteLine("1. Request a Ride");
            Console.WriteLine("2. Exit");

            string choice = Console.ReadLine();
            if (choice == "1")
            {
                Console.WriteLine("Enter pickup location:");
                string pickupLocation = Console.ReadLine();

                Console.WriteLine("Enter drop-off location:");
                string dropOffLocation = Console.ReadLine();

                Console.WriteLine("Choose ride type (Carpool, LuxuryRide, BikeRide):");
                string rideTypeInput = Console.ReadLine();
                RideType rideType = GetRideType(rideTypeInput);

                rider.RequestRide(pickupLocation, dropOffLocation, rideType, rideRequestProcess);
            }
            else if (choice == "2")
            {
                break;
            }
            else
            {
                Console.WriteLine("Invalid option. Please try again.");
            }
        }
    }

    static RideType GetRideType(string type)
    {
        switch (type)
        {
            case "Carpool":
                return new Carpool();
            case "LuxuryRide":
                return new LuxuryRide();
            case "BikeRide":
                return new BikeRide();
            default:
                throw new ArgumentException("Invalid ride type");
        }
    }
}
