package com.oop.match_3.gameplay.phases;

import com.oop.match_3.gameplay.steps.FinishStep;
import com.oop.match_3.gameplay.steps.RestartStep;
import com.oop.match_3.gameplay.steps.Step;
import com.oop.match_3.gameplay.steps.SwapStep;

public abstract class Phase {
    public static final int ADVANCE_OK = 1;          // последняя advance() отработала нормально
    public static final int ADVANCE_WRONG_PHASE = 2; // фаза не автоматическая
    public static final int ACCEPT_OK = 1;          // последняя accept() обработала Step
    public static final int ACCEPT_WRONG_PHASE = 2; // фаза не интерактивная, Step отвергнут

    protected final GameADT game;
    protected int advanceStatus;
    protected int acceptStatus;

    // конструктор
    // постусловие: фаза привязана к игре `game`
    public Phase(final GameADT game) {
        this.game = game;
        this.advanceStatus = ADVANCE_OK;
        this.acceptStatus = ACCEPT_OK;
    }

    //----------------команды----------------

    // предусловие: автоматическая фаза
    // постусловие: работа выполнена, Game переведён в следующую фазу,
    public abstract void advance();

    //предусловие - интерактивная фаза
    // постусловие: `step` выполнен, Game переведён в следующую фазу согласно типу Step
    public void accept(final Step step) {
        step.dispatchOn(this);
    }

    // постусловие: по умолчанию ставит acceptStatus = ACCEPT_WRONG_PHASE; переопределяется в фазе, принимающей SwapStep
    public void onSwap(final SwapStep step) {
        acceptStatus = ACCEPT_WRONG_PHASE;
    }

    // постусловие: по умолчанию ставит acceptStatus = ACCEPT_WRONG_PHASE; переопределяется в фазе, принимающей FinishStep
    public void onFinish(final FinishStep step) {
        acceptStatus = ACCEPT_WRONG_PHASE;
    }

    // постусловие: по умолчанию ставит acceptStatus = ACCEPT_WRONG_PHASE; переопределяется в фазе, принимающей RestartStep
    public void onRestart(final RestartStep step) {
        acceptStatus = ACCEPT_WRONG_PHASE;
    }

    //----------------дополнительные запросы----------------

    public int getAdvanceStatus() { // возвращает значение ADVANCE_*
        return advanceStatus;
    }

    public int getAcceptStatus() { // возвращает значение ACCEPT_*
        return acceptStatus;
    }

    // возвращает true только для терминальной фазы (EndPhase)
    public boolean isTerminal() {
        return false;
    }

    // возвращает true для интерактивной фазы (InputPhase, EndPhase) — ждёт Step, а не advance()
    public boolean isInteractive() {
        return false;
    }
}
