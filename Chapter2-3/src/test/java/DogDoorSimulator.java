/**
 * implementation and test 2.0 for happy path
 */
public class DogDoorSimulator {
    public static void main(String[] args) {
        DogDoor door = new DogDoor();
        BarkRecognizer recognizer = new BarkRecognizer(door);
        Remote remote = new Remote(door);

        // simulate the hardware hearing a bark
        System.out.println("Fido starts barking.");
        recognizer.recognize("Woof");

        System.out.println("\nFido has gone outside...");
        System.out.println("\nFido's all done...");

        try {
            Thread.currentThread().sleep(10000);
        } catch (InterruptedException e) {}

        System.out.println("...but he's stuck outside!");

        // simulate the hardware hearing bark again
        System.out.println("\nFido starts barking...");
        recognizer.recognize("Woof");

        System.out.println("\nFido's back inside...");
    }
}
