package com.agilesparks.rubikscube.solver;

import com.agilesparks.rubikscube.cube.Rubik;
import com.agilesparks.rubikscube.cube.RubikFileReader;
import com.agilesparks.rubikscube.utils.Direction;
import com.agilesparks.rubikscube.utils.Face;
import com.agilesparks.rubikscube.utils.Rotation;

public class Main {

    public static void main(String[] args) {
        long beginningTime = System.nanoTime();
        Rubik myRubik = new Rubik();
        myRubik.rotateFace(new Rotation(Face.R, Direction.CW));
      myRubik.rotateFace(new Rotation(Face.B, Direction.CW));
              myRubik.rotateFace(new Rotation(Face.R, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.B, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.L, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.F, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.R, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.B, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.R, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.B, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.L, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.F, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.R, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.B, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.R, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.B, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.L, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.F, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.R, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.B, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.R, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.B, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.L, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.F, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.R, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.B, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.R, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.B, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.L, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.F, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.R, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.B, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.R, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.B, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.L, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.F, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.R, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.B, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.R, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.B, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.L, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.F, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.R, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.B, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.R, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.B, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.L, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.F, Direction.CW));
        myRubik.rotateFace(new Rotation(Face.R, Direction.CW));
       Solver mySolver = new Solver();
        RotationTree firstFloorTree = new RotationTree();
        RotationTree secondFloorTree = new RotationTree();
        RotationTree thirdFloorTree = new RotationTree();
        RubikFileReader readFirstFloor = new RubikFileReader("FirstFloor.txt");
        RubikFileReader readSecondFloor = new RubikFileReader("SecondFloor.txt");
        RubikFileReader readThirdFloor = new RubikFileReader("ThirdFloor.txt");
        RotationTreeLoader.loadRotationTreeFromFile(readFirstFloor,firstFloorTree);
        RotationTreeLoader.loadRotationTreeFromFile(readSecondFloor, secondFloorTree);
        RotationTreeLoader.loadRotationTreeFromFile(readThirdFloor,thirdFloorTree);

        Solution mySolution = mySolver.solve(myRubik,firstFloorTree, secondFloorTree, thirdFloorTree);
        mySolution.applyToRubik(myRubik);
        mySolution.print();
        long endTime = System.nanoTime();
        System.out.format("Elapsed Time=%d seconds", ((endTime - beginningTime) / 1000000000));
//27-12-2017: started 11:39 PM, Failed
        myRubik.getPermutation().print();
    }
}
