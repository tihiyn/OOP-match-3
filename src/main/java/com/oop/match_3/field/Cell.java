package com.oop.match_3.field;

public class Cell extends CellADT {
    public Cell(final CoordsADT coords, final Element element) {
        super(coords, element);
    }

    public boolean hasSameElementAs(final CellADT other) {
        return false;
    }

    public boolean isAt(final CoordsADT coords) {
        return false;
    }

    public String print() {
        return "";
    }

    public void swap(final CellADT other) {
    }

    public void assignElement(final Element element) {
    }

    public int getPrintStatus() {
        return PRINT_EMPTY;
    }
}
