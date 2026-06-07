package com.oop.match_3.statistics;

import com.oop.match_3.gameplay.steps.Step;
import com.oop.match_3.math.UnsignedInt;
import com.oop.match_3.math.UnsignedIntADT;

public class Stats extends StatsADT {
    public Stats() {
        super();
    }

    public UnsignedIntADT score() {
        return new UnsignedInt(0);
    }

    public UnsignedIntADT movesCount() {
        return new UnsignedInt(0);
    }

    public String print() {
        return "";
    }

    public void increment(final UnsignedIntADT points) {
    }

    public void recordStep(final Step step) {
    }
}
