package com.oop.match_3.field;

import java.util.concurrent.ThreadLocalRandom;

public class ElementsFactory extends ElementsFactoryADT {
    private static ElementsFactory instance;
    private final ThreadLocalRandom random;

    private ElementsFactory() {
        super();
        this.random = ThreadLocalRandom.current();
    }

    public static ElementsFactory instance() {
        if (instance == null) {
            instance = new ElementsFactory();
        }
        return instance;
    }

    @Override
    public Element generate() {
        return Element.values()[random.nextInt(Element.values().length - 1)];
    }
}
