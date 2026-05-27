package com.oop.match_3.gameplay.phases;

import com.oop.match_3.gameplay.steps.Step;

public abstract class Phase {
    public static final int ADVANCE_OK = 1;          // последняя advance() отработала нормально
    public static final int ADVANCE_WRONG_PHASE = 2; // фаза не автоматическая
    public static final int ACCEPT_OK = 1;          // последняя accept() обработала Step
    public static final int ACCEPT_WRONG_PHASE = 2; // фаза не интерактивная, Step отвергнут

    // конструктор
    // постусловие: фаза привязана к игре `game`
    public Phase(final GameADT game) {}

    //----------------команды----------------

    // предусловие: автоматическая фаза
    // постусловие: работа выполнена, Game переведён в следующую фазу,
    public abstract void advance();

    //предусловие - интерактивная фаза
    // постусловие: `step` выполнен, Game переведён в следующую фазу согласно типу Step
    public abstract void accept(final Step step);

    //----------------дополнительные запросы----------------

    public abstract int getAdvanceStatus(); // возвращает значение ADVANCE_*
    public abstract int getAcceptStatus(); // возвращает значение ACCEPT_*
}
