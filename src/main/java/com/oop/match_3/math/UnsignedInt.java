package com.oop.match_3.math;

public class UnsignedInt extends UnsignedIntADT {
    private final Integer value;

    public UnsignedInt(final Integer value) {
        super(value);
        this.value = Math.abs(value);
    }

    @Override
    public boolean eq(final UnsignedIntADT other) {
        return value.equals(raw(other));
    }

    @Override
    public UnsignedIntADT add(final UnsignedIntADT augend) {
        return new UnsignedInt(value + raw(augend));
    }

    @Override
    public UnsignedIntADT subtract(final UnsignedIntADT subtrahend) {
        return new UnsignedInt(value - raw(subtrahend));
    }

    @Override
    public UnsignedIntADT multiply(final UnsignedIntADT multiplicand) {
        return new UnsignedInt(value * raw(multiplicand));
    }

    @Override
    public int compare(final UnsignedIntADT other) {
        return value.compareTo(raw(other));
    }

    @Override
    public Integer toInt() {
        return value;
    }

    private Integer raw(final UnsignedIntADT other) {
        return ((UnsignedInt) other).value;
    }
}
