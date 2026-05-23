package com.oop.match_3.gameplay.phases;

import com.oop.match_3.gameplay.steps.Step;

public class EndPhase extends Phase {

    public EndPhase Phase(Game game) {

    }

    // постусловие: без эффекта
    public void advance() {

    }

    // постусловие: если `step` - RestartStep, Game переведён в StartPhase,
    // иначе если `step` - FinishStep, игра завершена,
    // иначе - статус ACCEPT_WRONG_PHASE
    public void accept(Step step) {

    }

    public int getAcceptStatus(){

    }
}
