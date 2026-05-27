package com.oop.match_3.gameplay.steps;

import com.oop.match_3.gameplay.phases.GameADT;

public abstract class Step {
    // конструктор
    // постусловие: создан Step
    public Step() {}

    //----------------запросы----------------

    public abstract String print();

    //----------------команды----------------

    // постусловие: ход выполнен в контексте `game`, `game` переведена в следующую фазу согласно типу хода
    public abstract void execute(final GameADT game);
}
