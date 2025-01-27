import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CageTest {

    @Test
    void testAddAnimalSuccessfully() {
        BirdCage birdCage = new BirdCage("birdCage", 2);
        Bird bird1 = new Eagle("Rio");
        birdCage.add(bird1);

        List<? extends Bird> animals = birdCage.getAnimals();
        assertEquals(1, animals.size());
        assertTrue(animals.contains(bird1));
    }

    @Test
    void testAddAnimalToFullCageThrowsException() {
        LionCage lionCage = new LionCage("lionCage", 1);
        Lion lion1 = new Lion("Alex");
        Lion lion2 = new Lion("Leon");

        lionCage.add(lion1);

        Exception exception = assertThrows(UnsupportedOperationException.class, () -> lionCage.add(lion2));
        assertEquals("Cage is full!", exception.getMessage());
    }
    @Test
    void testAddWrongAnimalTypeToCageThrowsException() {
        LionCage lionCage = new LionCage("lionCage", 1);
        Animal bird1 = new Eagle("Eagle");

        Exception exception = assertThrows(ClassCastException.class, () -> lionCage.add((Lion) bird1));
        assertEquals("class Eagle cannot be cast to class Lion (Eagle and Lion are in unnamed module of loader 'app')", exception.getMessage());
    }


    @Test
    void testAddMultipleAnimalsUntilCageIsFull() {
        BirdCage birdCage = new BirdCage("BirdCage", 3);
        Eagle animal1 = new Eagle("Penguin1");
        Eagle animal2 = new Eagle("Penguin2");
        Eagle animal3 = new Eagle("Penguin3");


        birdCage.add(animal1);
        birdCage.add(animal2);
        birdCage.add(animal3);


        List<? extends Animal> animals = birdCage.getAnimals();
        assertEquals(3, animals.size());
        assertTrue(animals.contains(animal1));
        assertTrue(animals.contains(animal2));
        assertTrue(animals.contains(animal3));
    }

    @Test
    void testAddAnimalWithZeroCapacityCageThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new BirdCage("birdCage", 0));
        assertEquals("Capacity must be positive", exception.getMessage());
    }

    @Test
    void testAddAnimalWithNegativeCapacityCageThrowsException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new LionCage("lionCage",-1));
        assertEquals("Capacity must be positive", exception.getMessage());
    }
}

