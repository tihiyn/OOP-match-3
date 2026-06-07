package com.oop.match_3.field;

import com.oop.match_3.math.UnsignedIntADT;

public class Coords extends CoordsADT {
    public Coords(final UnsignedIntADT col, final UnsignedIntADT row) {
        super(col, row);
    }

    public boolean isNeighbour(final CoordsADT other) {
        return false;
    }

    public boolean eq(final CoordsADT other) {
        return false;
    }
}
