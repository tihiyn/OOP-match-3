package com.oop.match_3.statistics;

import com.oop.match_3.field.Grid;

public abstract class Bonus {

    // конструктор
    // постусловие: создан бонус
    public abstract Bonus Bonus();

    //----------------запросы----------------
    public abstract String print();

    //----------------команды----------------

    // постусловие: бонус применён к `grid`
    public abstract void apply(Grid grid);
}
