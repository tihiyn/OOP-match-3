package com.oop.match_3.gameplay.phases;

import com.oop.match_3.gameplay.steps.Step;

public abstract class Phase {

    public static final int ACCEPT_OK = 1;          // последняя accept() обработала Step
    public static final int ACCEPT_WRONG_PHASE = 2; // фаза не интерактивная, Step отвергнут

    // конструктор
    // постусловие: фаза привязана к игре `game`
    public abstract Phase Phase(Game game);

    //----------------команды----------------

    // постусловие: для автоматической фазы - работа выполнена, Game переведён в следующую фазу,
    // для интерактивной фазы - без эффекта (ожидание ввода)
    public abstract void advance();

    // постусловие: для интерактивной фазы - `step` выполнен, Game переведён в следующую фазу,
    // для неинтерактивной - статус ACCEPT_WRONG_PHASE
    public abstract void accept(Step step);

    //----------------дополнительные запросы----------------

    public abstract int getAcceptStatus(); // возвращает значение ACCEPT_*
}
