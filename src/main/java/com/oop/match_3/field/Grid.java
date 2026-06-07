package com.oop.match_3.field;

public class Grid extends GridADT {
    public Grid(final ElementsFactoryADT factory) {
        super(factory);
    }

    public Combo[] combos() {
        return new Combo[0];
    }

    public boolean isStable() {
        return true;
    }

    public boolean hasMoves() {
        return true;
    }

    public String print() {
        return "";
    }

    public void swap(final CoordsADT first, final CoordsADT second) {
    }

    public void resolve(final Combo[] combos) {
    }

    public void gravity() {
    }

    public void refill() {
    }

    public int getSwapStatus() {
        return SWAP_OK;
    }

    public int getAtStatus() {
        return AT_OK;
    }
}
