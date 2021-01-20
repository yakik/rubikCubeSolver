using System
using System.Collections.Generic
using System.Linq
using System.Text
using System.Threading.Tasks

namespace utils
{

    class DirectionFactory
    {
        static Direction getDirectionByInt(intValue):
            switch (intValue)
            {
                case 0:
                    return Direction.CW
                case 1:
                    return Direction.CCW
                default:
                    return Direction.CW
            }
        }
    }

}