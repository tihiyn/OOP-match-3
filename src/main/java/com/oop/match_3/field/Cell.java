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

    public boolean hasSameElementAs(final CellADT other) {
        return element == rawElement(other);
    }

    public boolean isAt(final CoordsADT target) {
        return coords.eq(target);
    }

    public boolean sharesRowWith(final CellADT other) {
        return coords.sameRow(rawCoords(other));
    }

    public String print() {
        printStatus = PRINT_OK;
        if (element == Element.NONE) {
            printStatus = PRINT_EMPTY;
        }
        return element.name();
    }

    public void swap(final CellADT other) {
        Element mine = element;
        assignElement(rawElement(other));
        other.assignElement(mine);
    }

    public void assignElement(final Element replacement) {
        element = replacement;
    }

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
