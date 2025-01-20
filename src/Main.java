// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        Eagle eagle1 = new Eagle("Eagle");
        Lion lion1 = new Lion("Lion");
        BirdCage birdCage1 = new BirdCage(10);
        birdCage1.add(eagle1);
        Zoo zoo = new Zoo();
        zoo.addCage(birdCage1);
    }
}
