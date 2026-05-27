package com.oop.match_3.math;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

class UnsignedIntTest {

    @Test
    void given_sameValue_when_eq_then_true() {
        UnsignedInt a = new UnsignedInt(5);
        UnsignedInt b = new UnsignedInt(5);
        assertThat(a.eq(b), is(true));
    }

    @Test
    void given_differentValue_when_eq_then_false() {
        UnsignedInt a = new UnsignedInt(5);
        UnsignedInt b = new UnsignedInt(6);
        assertThat(a.eq(b), is(false));
    }

    @Test
    void given_negativeInput_when_constructed_then_absoluteValueStored() {
        UnsignedInt a = new UnsignedInt(-5);
        UnsignedInt expected = new UnsignedInt(5);
        assertThat(a.eq(expected), is(true));
    }

    @Test
    void given_twoValues_when_add_then_sumReturned() {
        UnsignedInt a = new UnsignedInt(3);
        UnsignedInt b = new UnsignedInt(4);
        UnsignedIntADT result = a.add(b);
        assertThat(result.eq(new UnsignedInt(7)), is(true));
    }

    @Test
    void given_twoValues_when_subtract_then_differenceReturned() {
        UnsignedInt a = new UnsignedInt(10);
        UnsignedInt b = new UnsignedInt(3);
        UnsignedIntADT result = a.subtract(b);
        assertThat(result.eq(new UnsignedInt(7)), is(true));
    }

    @Test
    void given_twoValues_when_multiply_then_productReturned() {
        UnsignedInt a = new UnsignedInt(3);
        UnsignedInt b = new UnsignedInt(4);
        UnsignedIntADT result = a.multiply(b);
        assertThat(result.eq(new UnsignedInt(12)), is(true));
    }

    @Test
    void given_sameValue_when_compare_then_zero() {
        UnsignedInt a = new UnsignedInt(5);
        UnsignedInt b = new UnsignedInt(5);
        assertThat(a.compare(b), is(0));
    }

    @Test
    void given_lesserValue_when_compare_then_negative() {
        UnsignedInt a = new UnsignedInt(3);
        UnsignedInt b = new UnsignedInt(5);
        assertThat(a.compare(b), lessThan(0));
    }

    @Test
    void given_greaterValue_when_compare_then_positive() {
        UnsignedInt a = new UnsignedInt(7);
        UnsignedInt b = new UnsignedInt(5);
        assertThat(a.compare(b), greaterThan(0));
    }
}
