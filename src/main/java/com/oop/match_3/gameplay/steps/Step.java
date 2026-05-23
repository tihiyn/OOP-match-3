package com.oop.match_3.gameplay.steps;

import com.oop.match_3.gameplay.phases.Game;

public abstract class Step {
    // конструктор
    // постусловие: создан Step
    public abstract Step Step();

    //----------------запросы----------------
    public abstract String print();

    //----------------команды----------------

    // постусловие: ход выполнен в контексте `game`, `game` переведён в подходящую следующую фазу согласно типу хода
    public abstract void execute(Game game);
}
