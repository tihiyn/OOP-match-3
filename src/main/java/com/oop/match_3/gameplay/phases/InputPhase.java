package com.oop.match_3.gameplay.phases;

import com.oop.match_3.gameplay.steps.Step;

public class InputPhase extends Phase {

    public InputPhase Phase(Game game) {

    }

    // постусловие: без эффекта
    public void advance() {

    }

    // постусловие: `step` выполнен (step.execute(game)),
    // Game переведён в следующую фазу согласно типу Step,
    // статус ACCEPT_OK
    public void accept(Step step) {

    }

    public int getAcceptStatus(){

    }
}
