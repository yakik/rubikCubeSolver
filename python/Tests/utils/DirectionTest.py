using System
using System.Collections.Generic
using System.Linq
using System.Text
using System.Threading.Tasks
using CSharpRubikSolver
using Microsoft.VisualStudio.TestTools.UnitTesting
using utils

namespace CSharpRubikSolverUTests



    [TestClass]
    class DirectionTest
    
        [TestMethod]
        testDirectionGetIntGetChar():
            Direction myDirection = Direction.CW
            Assert.AreEqual(0, (int)myDirection)
            Assert.AreEqual("CW", myDirection.getString())
            myDirection = Direction.CCW
            Assert.AreEqual(1,(int) myDirection)
            Assert.AreEqual("CCW", myDirection.getString())
        

        [TestMethod]
        testDirectionEquals():
            Direction myDirection = Direction.CW
            Assert.AreEqual(Direction.CW, myDirection)
            Assert.AreEqual(true, myDirection == Direction.CW)
        
        [TestMethod]
        DirectionOpposite():
            Direction myDirection = Direction.CW
            Assert.AreEqual(Direction.CCW, DirectionHandler.getOpposite(myDirection))
            myDirection = Direction.CCW
            Assert.AreEqual(Direction.CW, DirectionHandler.getOpposite(myDirection))
        

    
