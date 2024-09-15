using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp13
{
    public class Carpool : RideType
    {
        public override double CalculateFare(double distance, TimeOfDay timeOfDay)
        {
            // Example calculation, consider peak hours for dynamic fare
            double baseFare = 1.5;
            return distance * baseFare;
        }
    }
}
