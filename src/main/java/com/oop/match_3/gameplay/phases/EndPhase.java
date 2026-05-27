package com.oop.match_3.gameplay.phases;

import com.oop.match_3.gameplay.steps.Step;

public class EndPhase extends Phase {

    public EndPhase(GameADT game) {
        super(game);
    }

    public void advance() {}

    // постусловие: из родительского класса + если RestartStep - Game переведена в StartPhase,
    // иначе если FinishStep - Game завершена
    public void accept(Step step) {}

    public int getAdvanceStatus() {}

    public int getAcceptStatus() {}
}
