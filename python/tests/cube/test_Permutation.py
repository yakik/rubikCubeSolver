import unittest
from production.cube.cube import Cube

class PermutationTest(unittest.TestCase):

    def test_getValue(self):
        myRubik = Cube()
        myRubik.rotate_face("FRONT", "CW")
        myPermutation = Cube(myRubik)
        self.assertEqual(10, Cube.get_value(myPermutation, 1), "first floor")
        self.assertEqual(14, Cube.get_value(
            myPermutation, 2), "second floor")
        self.assertEqual(24, Cube.get_value(myPermutation, 3), "third floor")

    def test_getValueFull(self):
        myRubik = Cube()
        myPermutation = Cube(myRubik)
        self.assertEqual(40, Cube.get_value(myPermutation, 3))
