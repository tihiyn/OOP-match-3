package com.oop.match_3.math;

public class UnsignedInt extends UnsignedIntADT {
    private final Integer value;

    public UnsignedInt(final Integer value) {
        super(value);
        this.value = Math.abs(value);
    }

    public boolean eq(final UnsignedIntADT other) {
        return value.equals(raw(other));
    }

    public UnsignedIntADT add(final UnsignedIntADT augend) {
        return new UnsignedInt(value + raw(augend));
    }

    public UnsignedIntADT subtract(final UnsignedIntADT subtrahend) {
        return new UnsignedInt(value - raw(subtrahend));
    }

    public UnsignedIntADT multiply(final UnsignedIntADT multiplicand) {
        return new UnsignedInt(value * raw(multiplicand));
    }

    public int compare(final UnsignedIntADT other) {
        return value.compareTo(raw(other));
    }

    private Integer raw(final UnsignedIntADT other) {
        return ((UnsignedInt) other).value;
    }
}
