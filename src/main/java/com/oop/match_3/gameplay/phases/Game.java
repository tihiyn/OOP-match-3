package com.oop.match_3.gameplay.phases;

import com.oop.match_3.field.Combo;
import com.oop.match_3.field.CoordsADT;
import com.oop.match_3.field.ElementsFactory;
import com.oop.match_3.field.Grid;
import com.oop.match_3.field.GridADT;
import com.oop.match_3.gameplay.steps.Step;
import com.oop.match_3.statistics.Stats;
import com.oop.match_3.statistics.StatsADT;

import java.util.Arrays;

public class Game extends GameADT {
    private GridADT grid;
    private StatsADT stats;
    private Phase phase;

    public Game() {
        super();
        reset();
    }

    public boolean isOver() {
        return phase.isTerminal();
    }

    public Combo[] combos() {
        return grid.combos();
    }

    public boolean hasMoves() {
        return grid.hasMoves();
    }

    public String print() {
        return grid.print() + "\n" + stats.print();
    }

    public void accept(final Step step) {
        phase.accept(step);
    }

    public void advance() {
        phase.advance();
    }

    public void reset() {
        this.grid = new Grid(ElementsFactory.instance());
        this.stats = new Stats();
        this.phase = new StartPhase(this);
    }

    public void setPhase(final Phase phase) {
        this.phase = phase;
    }

    public void swap(final CoordsADT coords1, final CoordsADT coords2) {
        grid.swap(coords1, coords2);
    }

    public void resolve(final Combo[] combos) {
        grid.resolve(combos);
    }

    public void gravity() {
        grid.gravity();
    }

    public void refill() {
        grid.refill();
    }

    public void scoreCombos(final Combo[] combos) {
        Arrays.stream(combos).forEach(this::scoreCombo);
    }

    private void scoreCombo(final Combo combo) {
        stats.increment(combo.score());
    }

    public void recordStep(final Step step) {
        stats.recordStep(step);
    }

    public Phase currentPhase() {
        return phase;
    }
}
