package com.oop.match_3.gameplay.phases;

import com.oop.match_3.gameplay.steps.Step;

public class FindCombosPhase extends Phase {

    public FindCombosPhase Phase(Game game) {

    }

    // постусловие: если на Grid есть комбинации - Game переведён в RemoveCombosPhase с этими комбинациями,
    // иначе если есть возможные ходы - Game переведён в InputPhase,
    // иначе - Game переведён в EndPhase
    public void advance() {

    }

    // постусловие: статус ACCEPT_WRONG_PHASE
    public void accept(Step step) {

    }

    public int getAcceptStatus(){

    }
}
