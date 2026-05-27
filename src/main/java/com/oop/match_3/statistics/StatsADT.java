package com.oop.match_3.statistics;

import com.oop.match_3.gameplay.steps.Step;
import com.oop.match_3.math.UnsignedIntADT;

public abstract class StatsADT {
    // конструктор
    // постусловие: создана статистика с нулевым счётом и пустой историей ходов
    public StatsADT() {}

    //----------------запросы----------------

    public abstract UnsignedIntADT score();

    public abstract UnsignedIntADT movesCount();

    public abstract String print();

    //----------------команды----------------

    // постусловие: количество очков увеличено на `points`
    public abstract void increment(final UnsignedIntADT points);

    // постусловие: `step` добавлен в историю ходов
    public abstract void recordStep(final Step step);
}
