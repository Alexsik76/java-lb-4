import java.util.ArrayList;
import java.util.List;

public abstract class Cage<Animal> {
    protected final int capacity;
    protected final List<Animal> animals = new ArrayList<>();

    Cage(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Animal animal)
    {
        if (animals.size() >= capacity) {
            throw new UnsupportedOperationException("Cage is full!");
        }
        animals.add(animal);
    }

    public void remove(Animal animal) {
        if (animals.isEmpty()) {
            throw new UnsupportedOperationException("Animal not found in the cage!");
        }
        animals.remove(animal);
    }

    public int getCapacityOfCage() {
        return capacity;
    }

    public List<? extends Animal> getAnimals() {
        return animals;
    }

    public int getCountOfAnimals() {
        return animals.size();
    }
}

class BirdCage extends Cage<Bird> {
    BirdCage(int capacity) {
        super(capacity);
    }
}

abstract class MammalCage<Mammal> extends Cage<Mammal> {
    MammalCage(int capacity) {
        super(capacity);
    }
}

class LionCage extends MammalCage<Lion> {
    LionCage(int capacity) {
        super(capacity);
    }
}

class UngulatesCage extends MammalCage<Ungulates> {
    UngulatesCage(int capacity) {
        super(capacity);
    }
}
