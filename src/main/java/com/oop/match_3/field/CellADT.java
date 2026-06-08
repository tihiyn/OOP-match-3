package com.oop.match_3.field;

public abstract class CellADT {
    public static final int PRINT_OK = 1; // последний print() отработал нормально
    public static final int PRINT_EMPTY = 2; // ячейка пуста

    // конструктор
    // постусловие: создана ячейка с координатами `coords` и элементом `element`
    public CellADT(final CoordsADT coords, final Element element) {}

    //----------------запросы----------------

    public abstract boolean hasSameElementAs(final CellADT other);

    public abstract boolean isAt(final CoordsADT coords);

    public abstract boolean sharesRowWith(final CellADT other);

    // предусловие: ячейка не содержит элемент Element.NONE
    public abstract String print();

    //----------------команды----------------

    // постусловие: значения текущей ячейки и `other` обменялись
    public abstract void swap(final CellADT other);

    // постусловие: значение ячейки заменено на `element`
    public abstract void assignElement(final Element element);

    //----------------дополнительные запросы----------------
    public abstract int getPrintStatus(); // возвращает значение PRINT_*
}
