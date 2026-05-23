package com.oop.match_3.field;

public abstract class Coords {
    // конструктор
    // предусловие: `row` >= 0, `col` >= 0
    // постусловие: создана координата, у которой строка равна `row` и столбец равен `col`
    public abstract Coords Coords(Integer row, Integer col);

    //----------------запросы----------------

    public abstract boolean isNeighbour(Coords other);

    public abstract boolean equalsTo(Coords other);
    
}
