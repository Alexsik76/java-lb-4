import java.io.*;
import java.util.List;

public final class FileSystem {
    private FileSystem() {
    }

    public static void save(Zoo zoo) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("animals.dat"))) {
            oos.writeObject(zoo.cages);
            System.out.println("Animals saved to file.");
        } catch (IOException e) {
            System.err.println("Error saving animals to file: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static void load(Zoo zoo) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("animals.dat"))) {
            zoo.cages = (List<Cage<? extends Animal>>) ois.readObject();
            System.out.println("Animals loaded from file.");
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error loading animals from file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
