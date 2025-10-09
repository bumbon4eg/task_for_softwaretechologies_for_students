package org.softwaretechnologies.animals;

public enum AnimalType {
    CAT{
        public Animal createAnimal(String name) {
            return new Animal(name) {
                @Override
                public String sound() {
                    return "meow";
                }
            };
        }
    }, DOG{
        public Animal createAnimal(String name) {
            return new Animal(name) {
                @Override
                public String sound() {
                    return "woof";
                }
            };
        }
    }, COW{
        public Animal createAnimal(String name) {
            return new Animal(name) {
                @Override
                public String sound() {
                    return "moo";
                }
            };
        }
    };

public abstract Animal createAnimal(String name);
}
