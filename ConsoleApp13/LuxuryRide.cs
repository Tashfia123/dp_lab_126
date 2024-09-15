using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp13
{
    public class LuxuryRide : RideType
    {
        public override double CalculateFare(double distance, TimeOfDay timeOfDay)
        {
            // Premium fare calculation
            double baseFare = 3.0;
            return distance * baseFare;
        }
    }
}
