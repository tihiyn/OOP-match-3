package com.oop.match_3.gameplay.phases;

import com.oop.match_3.gameplay.steps.Step;

public class GravityPhase extends Phase {

    public GravityPhase Phase(Game game) {

    }

    // постусловие: на Grid выполнена гравитация (Element.NONE в верхних позициях каждого столбца), Game переведён в RefillPhase
    public void advance() {

    }

    // постусловие: статус ACCEPT_WRONG_PHASE
    public void accept(Step step) {

    }

    public int getAcceptStatus(){

    }
}
