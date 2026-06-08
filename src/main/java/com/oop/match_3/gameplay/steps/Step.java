package com.oop.match_3.gameplay.steps;

import com.oop.match_3.gameplay.phases.GameADT;
import com.oop.match_3.gameplay.phases.Phase;

public abstract class Step {
    // конструктор
    // постусловие: создан Step
    public Step() {}

    //----------------запросы----------------

    public abstract String print();

    //----------------команды----------------

    // постусловие: ход выполнен в контексте `game`, `game` переведена в следующую фазу согласно типу хода
    public void execute(final GameADT game) {
        game.accept(this);
    }

    // постусловие: на `phase` вызван метод-обработчик, соответствующий конкретному типу Step (двойная диспетчеризация)
    public abstract void dispatchOn(final Phase phase);
}
