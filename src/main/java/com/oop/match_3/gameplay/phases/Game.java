package com.oop.match_3.gameplay.phases;

import com.oop.match_3.field.Combo;
import com.oop.match_3.field.CoordsADT;
import com.oop.match_3.gameplay.steps.Step;

public class Game extends GameADT {
    public Game() {
        super();
    }

    public boolean isOver() {
        return false;
    }

    public Combo[] combos() {
        return new Combo[0];
    }

    public boolean hasMoves() {
        return true;
    }

    public String print() {
        return "";
    }

    public void accept(final Step step) {
    }

    public void advance() {
    }

    public void reset() {
    }

    public void setPhase(final Phase phase) {
    }

    public void swap(final CoordsADT coords1, final CoordsADT coords2) {
    }

    public void resolve(final Combo[] combos) {
    }

    public void gravity() {
    }

    public void refill() {
    }

    public void scoreCombos(final Combo[] combos) {
    }

    public void recordStep(final Step step) {
    }

    Phase currentPhase() {
        return null;
    }
}
