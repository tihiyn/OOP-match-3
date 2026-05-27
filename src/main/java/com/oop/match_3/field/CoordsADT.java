package com.oop.match_3.field;

import com.oop.match_3.math.UnsignedIntADT;

public abstract class CoordsADT {
    // конструктор
    // постусловие: создана координата, у которой строка равна `row` и столбец равен `col`
    public CoordsADT(final UnsignedIntADT col, final UnsignedIntADT row) {}

    //----------------запросы----------------

    public abstract boolean isNeighbour(final CoordsADT other);

    public abstract boolean eq(final CoordsADT other);
}
