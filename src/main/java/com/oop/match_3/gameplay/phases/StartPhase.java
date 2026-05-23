package com.oop.match_3.gameplay.phases;

import com.oop.match_3.gameplay.steps.Step;

public class StartPhase extends Phase {

    public StartPhase Phase(Game game) {

    }

    // постусловие: Grid инициализирован случайными элементами, Game переведён в InputPhase
    public void advance() {

    }

    // постусловие: статус ACCEPT_WRONG_PHASE
    public void accept(Step step) {

    }

    public int getAcceptStatus(){

    }
}
