package com.oop.match_3.statistics;

import com.oop.match_3.gameplay.steps.Step;

public abstract class Stats {

    // конструктор
    // постусловие: создана статистика с нулевым счётом и пустой историей ходов
    public abstract Stats Stats();

    //----------------запросы----------------

    public abstract Integer score();

    public abstract Integer movesCount();

    public abstract String print();

    //----------------команды----------------

    // постусловие: количество очков увеличено на `points`
    public abstract void increment(Integer points);

    // постусловие: `step` добавлен в историю ходов
    public abstract void recordStep(Step step);
}
