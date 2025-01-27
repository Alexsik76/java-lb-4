import java.util.Map;
import java.util.Scanner;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Zoo zoo = new Zoo();
        BirdCage birdCage = new BirdCage("birdCage", 10);
        LionCage lionCage = new LionCage("lionCage", 10);
        UngulatesCage ungulatesCage = new UngulatesCage("ungulatesCage", 20);
        zoo.addCage(birdCage);
        zoo.addCage(lionCage);
        zoo.addCage(ungulatesCage);
        System.out.println("Welcome to the Zoo Management System!");
        Menu.run(zoo);

    }
}
