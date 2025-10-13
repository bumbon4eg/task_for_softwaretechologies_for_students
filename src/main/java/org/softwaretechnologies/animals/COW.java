package org.softwaretechnologies.animals;

public class COW extends Animal {
    public COW(String name) {
        super(name);
    }

    @Override
    public String sound() {
        return "moo";
    }
}
