package com.oop.match_3.field;

public abstract class Grid {
    public static final int SWAP_OK = 1;  // последняя swap() отработала нормально
    public static final int SWAP_OUT_OF_BOUNDS = 2; // хотя бы одна координата вне поля
    public static final int SWAP_NOT_NEIGHBOURS = 3; // координаты не соседние

    public static final int AT_OK = 1;  // последняя at() вернула корректную ячейку
    public static final int AT_OUT_OF_BOUNDS = 2; // координата вне поля

    // конструктор
    // постусловие: создано поле 8x8, заполненное случайными элементами из `factory`
    public abstract Grid Grid(ElementsFactory factory);

    //----------------запросы----------------

    // предусловие: `coords` в границах поля
    public abstract Cell at(Coords coords);

    public abstract Combo[] combos();

    public abstract boolean isStable();

    public abstract boolean hasMoves();

    public abstract boolean isWithin(Coords coords);

    //----------------команды----------------

    // предусловие: `coords1`, `coords2` в границах поля и они соседние
    // постусловие: значения в ячейках `coords1` и `coords2` обменялись
    public abstract void swap(Coords coords1, Coords coords2);

    // постусловие: все ячейки указанных комбинаций имеют значение Element.NONE
    public abstract void remove(Combo[] combos);

    // постусловие: значения ячеек смещены вниз; все Element.NONE - в верхних позициях каждого столбца
    public abstract void applyGravity();

    // постусловие: все ячейки со значением Element.NONE заполнены новыми элементами из сохранённой фабрики
    public abstract void refill();

    //----------------дополнительные запросы----------------

    public abstract int getSwapStatus(); // возвращает значение SWAP_*
    public abstract int getAtStatus();   // возвращает значение AT_*
}
