package com.oop.match_3.statistics;

import com.oop.match_3.field.GridADT;

public abstract class Bonus {
    // конструктор
    // постусловие: создан бонус
    public Bonus() {}

    //----------------запросы----------------

    public abstract String print();

    //----------------команды----------------

    // постусловие: бонус применён к `grid`
    public abstract void apply(final GridADT grid);
}
