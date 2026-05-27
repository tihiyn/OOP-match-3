package com.oop.match_3.math;

public abstract class UnsignedIntADT {
    // конструктор
    // постусловие: создано целое неотрицательное число со значением `value`, если `value` >= 0, иначе -`value`
    public UnsignedIntADT(Integer value) {}

    //----------------запросы----------------

    public abstract boolean eq(UnsignedIntADT other);

    public abstract UnsignedIntADT add(UnsignedIntADT augend);

    public abstract UnsignedIntADT subtract(UnsignedIntADT subtrahend);

    public abstract UnsignedIntADT multiply(UnsignedIntADT multiplicand);

    public abstract int compare(UnsignedIntADT other);
}
