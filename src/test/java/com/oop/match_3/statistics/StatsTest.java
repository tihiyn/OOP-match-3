package com.oop.match_3.statistics;

import com.oop.match_3.gameplay.steps.RestartStep;
import com.oop.match_3.math.UnsignedInt;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

class StatsTest {

    @Test
    void given_freshStats_when_score_then_zero() {
        Stats stats = new Stats();
        assertThat(stats.score().eq(new UnsignedInt(0)), is(true));
    }

    @Test
    void given_freshStats_when_movesCount_then_zero() {
        Stats stats = new Stats();
        assertThat(stats.movesCount().eq(new UnsignedInt(0)), is(true));
    }

    @Test
    void given_stats_when_increment_then_scoreIncreased() {
        Stats stats = new Stats();
        stats.increment(new UnsignedInt(30));
        assertThat(stats.score().eq(new UnsignedInt(30)), is(true));
    }

    @Test
    void given_stats_when_incrementTwice_then_scoreIsSum() {
        Stats stats = new Stats();
        stats.increment(new UnsignedInt(30));
        stats.increment(new UnsignedInt(60));
        assertThat(stats.score().eq(new UnsignedInt(90)), is(true));
    }

    @Test
    void given_stats_when_recordStep_then_movesCountIsOne() {
        Stats stats = new Stats();
        stats.recordStep(new RestartStep());
        assertThat(stats.movesCount().eq(new UnsignedInt(1)), is(true));
    }

    @Test
    void given_stats_when_recordStepTwice_then_movesCountIsTwo() {
        Stats stats = new Stats();
        stats.recordStep(new RestartStep());
        stats.recordStep(new RestartStep());
        assertThat(stats.movesCount().eq(new UnsignedInt(2)), is(true));
    }

    @Test
    void given_stats_when_incrementDoesNotChangeMovesCount() {
        Stats stats = new Stats();
        stats.increment(new UnsignedInt(50));
        assertThat(stats.movesCount().eq(new UnsignedInt(0)), is(true));
    }

    @Test
    void given_stats_when_recordStepDoesNotChangeScore() {
        Stats stats = new Stats();
        stats.recordStep(new RestartStep());
        assertThat(stats.score().eq(new UnsignedInt(0)), is(true));
    }

    @Test
    void given_freshStats_when_print_then_notNull() {
        Stats stats = new Stats();
        assertThat(stats.print(), notNullValue());
    }
}
