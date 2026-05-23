package com.oop.match_3.gameplay.phases;

import com.oop.match_3.field.Combo;
import com.oop.match_3.field.Coords;
import com.oop.match_3.gameplay.steps.Step;
import com.oop.match_3.statistics.Bonus;

public abstract class Game {

    // конструктор
    // постусловие: создана новая игра - Grid и Stats инициализированы, текущая фаза - StartPhase
    public abstract Game Game();

    //----------------запросы----------------

    public abstract boolean isOver();

    public abstract Combo[] combos();

    public abstract boolean hasMoves();

    //----------------команды----------------

    // главный приём ввода: делегирует currentPhase.accept(`step`)
    public abstract void accept(Step step);

    // тик авто-фазы: делегирует currentPhase.advance()
    public abstract void advance();

    // постусловие: текущая фаза заменена на `phase`
    public abstract void setPhase(Phase phase);

    // постусловие: состояние игры сброшено к начальному
    public abstract void reset();

    // постусловие: значения в ячейках `coords1` и `coords2` обменялись на Grid
    public abstract void swap(Coords coords1, Coords coords2);

    // постусловие: ячейки указанных `combos` очищены на Grid
    public abstract void removeCombos(Combo[] combos);

    // постусловие: на Grid выполнена applyGravity()
    public abstract void applyGravity();

    // постусловие: пустые ячейки Grid заполнены новыми элементами
    public abstract void refill();

    // постусловие: очки за `combo` начислены в Stats
    public abstract void scoreCombo(Combo combo);

    // постусловие: `bonus` применён в Stats игрока
    public abstract void applyBonus(Bonus bonus);

    // постусловие: `step` записан в историю Stats
    public abstract void recordStep(Step step);
}
