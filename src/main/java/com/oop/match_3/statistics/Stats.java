package com.oop.match_3.statistics;

import com.oop.match_3.gameplay.steps.Step;
import com.oop.match_3.math.UnsignedInt;
import com.oop.match_3.math.UnsignedIntADT;

import java.util.ArrayList;
import java.util.List;

public class Stats extends StatsADT {
    private UnsignedIntADT score;
    private final List<Step> history;

    public Stats() {
        super();
        this.score = new UnsignedInt(0);
        this.history = new ArrayList<>();
    }

    @Override
    public UnsignedIntADT score() {
        return score;
    }

    @Override
    public UnsignedIntADT movesCount() {
        return new UnsignedInt(history.size());
    }

    @Override
    public String print() {
        return "Score: %d, Moves: %d".formatted(score.toInt(), movesCount().toInt());
    }

    @Override
    public void increment(final UnsignedIntADT points) {
        score = score.add(points);
    }

    @Override
    public void recordStep(final Step step) {
        history.add(step);
    }
}
