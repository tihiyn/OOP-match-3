package com.oop.match_3.field;

public abstract class Cell {
    // конструктор
    // постусловие: создана ячейка с координатами `coords` и значением `value`
    public abstract Cell Cell(Coords coords, Element value);

    //----------------запросы----------------

    public abstract boolean hasSameValueAs(Cell other);

    public abstract boolean isAt(Coords coords);

    // предусловие: ячейка не содержит элемент Element.NONE
    public abstract String print();

    //----------------команды----------------

    // постусловие: значения текущей ячейки и `other` обменялись
    public abstract void swap(Cell other);

    // постусловие: значение ячейки заменено на `value`
    public abstract void assignValue(Element value);
}
