package com.oop.match_3.field;

import com.oop.match_3.statistics.Bonus;

public abstract class Combo {

    // конструктор
    // предусловие: `cells` содержит не менее 3 ячеек, все ячейки имеют одинаковое значение Element, среди ячеек нет дубликатов
    // постусловие: создана комбинация, инкапсулирующая заданный набор ячеек как множество
    public abstract Combo Combo(Cell... cells);

    //----------------запросы----------------

    public abstract Integer score();

    public abstract boolean hasBonus();

    // предусловие: hasBonus()
    public abstract Bonus bonus();

    //----------------команды----------------

    // постусловие: на сетке `grid` все ячейки данной комбинации имеют значение Element.NONE
    public abstract void removeFromGrid(Grid grid);
}
