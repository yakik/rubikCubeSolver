
using utils




    [TestClass]
    class DirectionTest
    
        [TestMethod]
        def testDirectionGetIntGetChar():
            Direction myDirection = Direction.CW
            Assert.AreEqual(0, (int)myDirection)
            Assert.AreEqual("CW", myDirection.getString())
            myDirection = Direction.CCW
            Assert.AreEqual(1,(int) myDirection)
            Assert.AreEqual("CCW", myDirection.getString())
        

        [TestMethod]
        def testDirectionEquals():
            Direction myDirection = Direction.CW
            Assert.AreEqual(Direction.CW, myDirection)
            Assert.AreEqual(true, myDirection == Direction.CW)
        
        [TestMethod]
        def DirectionOpposite():
            Direction myDirection = Direction.CW
            Assert.AreEqual(Direction.CCW, DirectionHandler.getOpposite(myDirection))
            myDirection = Direction.CCW
            Assert.AreEqual(Direction.CW, DirectionHandler.getOpposite(myDirection))
        

    