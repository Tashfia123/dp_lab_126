using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ConsoleApp13
{
    public abstract class RideType
    {
        public abstract double CalculateFare(double distance, TimeOfDay timeOfDay);
    }

}
