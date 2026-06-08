package com.oop.match_3.field;

public abstract class GridADT {
    public static final int SWAP_OK = 1;  // последняя swap() отработала нормально
    public static final int SWAP_OUT_OF_BOUNDS = 2; // хотя бы одна координата вне поля
    public static final int SWAP_NOT_NEIGHBOURS = 3; // координаты не соседние

    // конструктор
    // постусловие: создано поле 8x8, заполненное случайными элементами из `factory`, без готовых комбинаций и
    // как минимум одним возможным ходом
    public GridADT(final ElementsFactoryADT factory) {}

    //----------------запросы----------------

    public abstract Combo[] combos();

    public abstract boolean isStable();

    public abstract boolean hasMoves();

    public abstract String print();

    //----------------команды----------------

    // предусловие: `coords1`, `coords2` в границах поля и они соседние
    // постусловие: значения в ячейках `coords1` и `coords2` обменялись
    public abstract void swap(final CoordsADT first, final CoordsADT second);

    // постусловие: все ячейки указанных комбинаций имеют значение Element.NONE и дополнительно применены бонусы тех
    // комбинаций, у которых hasBonus()
    public abstract void resolve(final Combo[] combos);

    // постусловие: значения ячеек смещены вниз; все Element.NONE - в верхних позициях каждого столбца
    public abstract void gravity();

    // постусловие: все ячейки со значением Element.NONE заполнены новыми элементами из фабрики
    public abstract void refill();

    //----------------дополнительные запросы----------------

    public abstract int getSwapStatus(); // возвращает значение SWAP_*
}
