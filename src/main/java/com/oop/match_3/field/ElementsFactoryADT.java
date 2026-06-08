package com.oop.match_3.field;

public abstract class ElementsFactoryADT {
    // постусловие: если фабрика до этого не создавалась - создана фабрика, иначе - возвращает существующую
    // public abstract ElementsFactoryADT instance();

    //----------------запросы----------------

    public abstract Element generate();
}
