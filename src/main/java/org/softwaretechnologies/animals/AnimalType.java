package org.softwaretechnologies.animals;

public enum AnimalType {
    CAT{
        public Animal createAnimal(String name) {
            return new CAT(name);
        }
    }, DOG{
        public Animal createAnimal(String name) {
            return new DOG(name);
        }
    }, COW{
        public Animal createAnimal(String name) {
            return new COW(name);
        }
    };
    public abstract Animal createAnimal(String name);
}
