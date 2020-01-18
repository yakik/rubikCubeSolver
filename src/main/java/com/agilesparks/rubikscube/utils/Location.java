package com.agilesparks.rubikscube.utils;

public class Location {
    boolean c_isEdge;
    private Face c_face0;
    private Face c_face1;
    private Face c_face2;

    Location() {
    }

    public boolean containsFace(Face p_face) {
        if (p_face == c_face0 || p_face == c_face1 || (!c_isEdge && (p_face == c_face2)))
            return true;
        else
            return false;
    }

    public Location getCopy() {
        if (isEdge())
            return new Location(c_face0, c_face1);
        else
            return new Location(c_face0, c_face1, c_face2);
    }

    public Location(Face p_face0, Face p_face1, Face p_face2) {
        Face l_tmp;
        c_isEdge = false;
        c_face0 = p_face0;
        c_face1 = p_face1;
        c_face2 = p_face2;
// bubble sort to keep order within faces		
        if (c_face0.getInt() > c_face1.getInt()) {
            l_tmp = c_face1;
            c_face1 = c_face0;
            c_face0 = l_tmp;
        }
        if (c_face1.getInt() > c_face2.getInt()) {
            l_tmp = c_face2;
            c_face2 = c_face1;
            c_face1 = l_tmp;
        }
        if (c_face0.getInt() > c_face1.getInt()) {
            l_tmp = c_face1;
            c_face1 = c_face0;
            c_face0 = l_tmp;
        }

    }

    public Location(Face p_face0, Face p_face1) {
        c_isEdge = true;
        //       c_face2 = Face.NOTDEFINED;
        c_face0 = p_face0;
        c_face1 = p_face1;
        if (p_face0.getInt() > p_face1.getInt()) {
            c_face1 = p_face0;
            c_face0 = p_face1;
        } else {
            c_face0 = p_face0;
            c_face1 = p_face1;
        }
    }

    public boolean isEdge() {
        return c_isEdge;
    }

    public Face getFace0() {
        return c_face0;
    }

    public Face getFace1() {
        return c_face1;
    }

    public int getFloor() {
        if (this.equals(new Location(Face.TOP, Face.LEFT, Face.FRONT))) return 3;
        if (this.equals(new Location(Face.TOP, Face.LEFT, Face.BACK))) return 3;
        if (this.equals(new Location(Face.TOP, Face.RIGHT, Face.FRONT))) return 3;
        if (this.equals(new Location(Face.TOP, Face.RIGHT, Face.BACK))) return 3;
        if (this.equals(new Location(Face.BOTTOM, Face.LEFT, Face.FRONT))) return 1;
        if (this.equals(new Location(Face.BOTTOM, Face.LEFT, Face.BACK))) return 1;
        if (this.equals(new Location(Face.BOTTOM, Face.RIGHT, Face.FRONT))) return 1;
        if (this.equals(new Location(Face.BOTTOM, Face.RIGHT, Face.BACK))) return 1;

        if (this.equals(new Location(Face.TOP, Face.FRONT))) return 3;
        if (this.equals(new Location(Face.TOP, Face.BACK))) return 3;
        if (this.equals(new Location(Face.TOP, Face.LEFT))) return 3;
        if (this.equals(new Location(Face.TOP, Face.RIGHT))) return 3;

        if (this.equals(new Location(Face.FRONT, Face.LEFT))) return 2;
        if (this.equals(new Location(Face.FRONT, Face.RIGHT))) return 2;
        if (this.equals(new Location(Face.BACK, Face.LEFT))) return 2;
        if (this.equals(new Location(Face.BACK, Face.RIGHT))) return 2;

        if (this.equals(new Location(Face.BOTTOM, Face.LEFT))) return 1;
        if (this.equals(new Location(Face.BOTTOM, Face.RIGHT))) return 1;
        if (this.equals(new Location(Face.FRONT, Face.BOTTOM))) return 1;
        if (this.equals(new Location(Face.BACK, Face.BOTTOM))) return 1;
        return 0;
    }

    public Face getFace2() {
//        if (isEdge())
//            return Face.NOTDEFINED;
//        else
        return c_face2;
    }

//	int getValue() {
//		return (getFace0() * 1 + getFace1() * 6 + getFace2() * 36 + isEdge() * 216);
//	}

    public boolean equals(Location p_location) {
        return ((c_face0 == p_location.c_face0) &&
                (c_face1 == p_location.c_face1) &&
                (c_face2 == p_location.c_face2) &&
                (c_isEdge == p_location.c_isEdge));
    }


    public String getString() {
        if (c_isEdge)
            return String.format("%c, %c", c_face0.getIntOfChar(), c_face1.getIntOfChar());
        else {
            return String.format("%c, %c, %c", c_face0.getIntOfChar(), c_face1.getIntOfChar(), c_face2.getIntOfChar());
        }
    }

}