package com.oop.match_3.field;

public class Cell extends CellADT {
    private final CoordsADT coords;
    private Element element;
    private int printStatus;

    public Cell(final CoordsADT coords, final Element element) {
        super(coords, element);
        this.coords = coords;
        this.element = element;
    }

    @Override
    public boolean hasSameElementAs(final CellADT other) {
        return element == rawElement(other);
    }

    @Override
    public boolean isAt(final CoordsADT target) {
        return coords.eq(target);
    }

    @Override
    public boolean hasSameRowWith(final CellADT other) {
        return coords.sameRow(rawCoords(other));
    }

    @Override
    public String print() {
        if (element == Element.NONE) {
            printStatus = PRINT_EMPTY;
            return element.name();
        }
        printStatus = PRINT_OK;
        return element.name();
    }

    @Override
    public void swap(final CellADT other) {
        Element origin = element;
        assignElement(rawElement(other));
        other.assignElement(origin);
    }

    @Override
    public void assignElement(final Element replacement) {
        element = replacement;
    }

    @Override
    public int getPrintStatus() {
        return printStatus;
    }

    private Element rawElement(final CellADT other) {
        return ((Cell) other).element;
    }

    private CoordsADT rawCoords(final CellADT other) {
        return ((Cell) other).coords;
    }
}
