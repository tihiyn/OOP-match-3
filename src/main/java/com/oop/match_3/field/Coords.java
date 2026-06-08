package com.oop.match_3.field;

import com.oop.match_3.math.UnsignedInt;
import com.oop.match_3.math.UnsignedIntADT;

public class Coords extends CoordsADT {
    private static final UnsignedIntADT ONE = new UnsignedInt(1);

    private final UnsignedIntADT col;
    private final UnsignedIntADT row;

    public Coords(final UnsignedIntADT col, final UnsignedIntADT row) {
        super(col, row);
        this.col = col;
        this.row = row;
    }

    public boolean isNeighbour(final CoordsADT other) {
        UnsignedIntADT colDistance = col.subtract(rawCol(other));
        UnsignedIntADT rowDistance = row.subtract(rawRow(other));
        UnsignedIntADT distance = colDistance.add(rowDistance);
        return distance.eq(ONE);
    }

    public boolean eq(final CoordsADT other) {
        boolean sameCol = col.eq(rawCol(other));
        boolean sameRow = row.eq(rawRow(other));
        return sameCol && sameRow;
    }

    public boolean sameRow(final CoordsADT other) {
        return row.eq(rawRow(other));
    }

    private UnsignedIntADT rawCol(final CoordsADT other) {
        return ((Coords) other).col;
    }

    private UnsignedIntADT rawRow(final CoordsADT other) {
        return ((Coords) other).row;
    }
}
