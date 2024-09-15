using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp13
{
    public class BikeRide : RideType
    {
        public override double CalculateFare(double distance, TimeOfDay timeOfDay)
        {
            // Affordable fare calculation
            double baseFare = 1.0;
            return distance * baseFare;
        }
    }
}
