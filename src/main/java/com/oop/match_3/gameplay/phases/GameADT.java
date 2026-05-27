package com.oop.match_3.gameplay.phases;

import com.oop.match_3.field.Combo;
import com.oop.match_3.field.CoordsADT;
import com.oop.match_3.gameplay.steps.Step;

public abstract class GameADT {
    // конструктор
    // постусловие: создана новая игра - Grid и Stats инициализированы, текущая фаза - StartPhase
    public GameADT() {}

    //----------------запросы----------------

    public abstract boolean isOver();

    public abstract Combo[] combos();

    public abstract boolean hasMoves();

    public abstract String print();

    //----------------команды----------------

    // постусловие: accept делегирован текущей фазе
    public abstract void accept(final Step step);

    // постусловие: advance делегирован текущей фазе
    public abstract void advance();

    // постусловие: состояние игры сброшено к начальному: Grid и Stats инициализированы, текущая фаза - StartPhase
    public abstract void reset();

    // постусловие: текущая фаза заменена на `phase`
    public abstract void setPhase(final Phase phase);



    // постусловие: swap делегирован Grid
    public abstract void swap(final CoordsADT coords1, final CoordsADT coords2);

    // постусловие: resolve делегирован Grid
    public abstract void resolve(final Combo[] combos);

    // постусловие: gravity делегирован Grid
    public abstract void gravity();

    // постусловие: refill делегирован Grid
    public abstract void refill();


    // постусловие: очки за все `combos` начислены в Stats
    public abstract void scoreCombos(final Combo[] combos);

    // постусловие: `step` записан в историю Stats
    public abstract void recordStep(final Step step);
}
