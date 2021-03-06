package com.agilesparks.rubikscube.solver;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
//import java.io.IOException;

import com.agilesparks.rubikscube.cube.Cube;
import com.agilesparks.rubikscube.cube.RubikFileReader;
import com.agilesparks.rubikscube.cube.RubikFileWriter;
import com.agilesparks.rubikscube.utils.Direction;
import com.agilesparks.rubikscube.utils.Face;
import com.agilesparks.rubikscube.utils.Rotation;

public class RotationSequence {

    private ArrayList<Rotation> c_array = new ArrayList<Rotation>();

    public RotationSequence() {
        c_array.clear();
    }


    private  RotationSequence(ArrayList<Rotation> p_arrayList) {
        c_array = p_arrayList;

    }

    void print() {
        ListIterator<Rotation> l_itr = null;
        l_itr=c_array.listIterator();
         while(l_itr.hasNext())
            l_itr.next().print();
        System.out.format("\n");
    }

    public void addRotation(Rotation p_rotation) {
        c_array.add(p_rotation);
    }

    public void removeRotation() {
        c_array.remove(c_array.size()-1);
    }

    public boolean isRedundant(Rotation p_rotation) {
        boolean l_returnValue = false;

        Face l_lastFace;
        Direction l_lastDirection;
        if (c_array.size() > 0) {
            l_lastFace = c_array.get(c_array.size()-1).getFace();
            l_lastDirection = c_array.get(c_array.size()-1).getDirection();
            // new rotation is opposite to previous
            if (c_array.get(c_array.size()-1).getReverse().equals(p_rotation))
                l_returnValue = true;
            // previous face was opposite and previous face greater then current face
            if ((p_rotation.getFace() == l_lastFace.getOpposite()) && (l_lastFace.getInt() > p_rotation.getFace().getInt()))
                l_returnValue = true;
            // two clockwise rotation of same face
            if ((p_rotation.getFace() == l_lastFace) && (l_lastDirection == Direction.CW) &&
                    (p_rotation.getDirection() == Direction.CW))
                l_returnValue = true;
            //no three counter clockwise rotations
            if (c_array.size()>1) {
                if ((p_rotation.getFace() == l_lastFace) && (l_lastDirection == Direction.CCW) &&
                        (p_rotation.getDirection() == Direction.CCW) &&
                        (c_array.get(c_array.size()-2).getFace() == l_lastFace) && (l_lastDirection == Direction.CCW) &&
                        (c_array.get(c_array.size()-2).getDirection() == Direction.CCW))
                    l_returnValue = true;
            }
        } else
            l_returnValue = false;
        return l_returnValue;

    }

    public void writeToFile(RubikFileWriter p_writer){
        ListIterator<Rotation> l_itr = null;
        l_itr=c_array.listIterator();
        while(l_itr.hasNext())
            l_itr.next().writeToFile(p_writer);
        p_writer.write("\n");


    }
    public boolean readFromFile(RubikFileReader p_reader) {
        Rotation l_rotation = new Rotation();

        c_array.clear();
        while (l_rotation.readFromFile(p_reader))
            c_array.add((new Rotation(l_rotation.getFace(),l_rotation.getDirection())));
        return !(c_array.size()==0);
    }

    RotationSequence getSubRotationLinkedList() {
        return new RotationSequence(new ArrayList<>(c_array.subList(1, c_array.size())));
    }

    int size(){
        return c_array.size();
    }

    Rotation getFirstRotation() {
        return c_array.get(0);
    }
public Rotation getRotation(int p_index){
        return c_array.get(p_index);
}
    boolean isNotEmpty() {

        return (c_array.size()>0);
    }

    RotationSequence getCopy() {
        RotationSequence l_rotationLinkedList = new RotationSequence();
        ListIterator<Rotation> l_itr=c_array.listIterator();

        while(l_itr.hasNext())
            l_rotationLinkedList.addRotation(l_itr.next());

        return l_rotationLinkedList;
    }

    void applyToRubik(Cube p_rubik) {
        ListIterator<Rotation> l_itr=c_array.listIterator();

        while(l_itr.hasNext()) {
        	Rotation nextRotation = l_itr.next();

            p_rubik.rotateFace(nextRotation.getFace(), nextRotation.getDirection());
        }

    }
}

